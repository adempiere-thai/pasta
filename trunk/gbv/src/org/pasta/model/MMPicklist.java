package org.pasta.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MClient;
import org.compiere.model.MInOut;
import org.compiere.model.MInOutLine;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.MStorage;
import org.compiere.model.MWarehouse;
import org.compiere.model.Query;
import org.compiere.util.DB;
import org.compiere.util.Msg;

public class MMPicklist extends X_M_Picklist {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8217429824971523609L;
	private static final String ERR_CANNOT_SAVE_PICKLINE = "CANNOT_SAVE_PICKLIST_LINE";
	
	MOrder order = null;

	public MMPicklist(Properties ctx, int M_Picklist_ID, String trxName) {
		super(ctx, M_Picklist_ID, trxName);

		setPickDate(new Timestamp(System.currentTimeMillis()));
	}

	public MMPicklist(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public static MMPicklist getPicklistFromOrder(MOrder order) {
		List<Object> params = new ArrayList<Object>();
		params.add(order.getC_Order_ID());

		String whereClause = MMPicklist.COLUMNNAME_C_Order_ID + " = ? ";

		Object obj = new Query(order.getCtx(), MMPicklist.Table_Name,
				whereClause.toString(), order.get_TrxName()).setParameters(
				params).first();

		if (obj == null) {
			return null;
		}

		return (MMPicklist) obj;
	}
	
	protected boolean beforeSave(boolean newRecord) {
		// TODO Auto-generated method stub
		if(newRecord){
			this.setDocumentNo("PL"+getC_Order().getDocumentNo()); 
		}
		
		return true;
	}

	List<MMPicklistLine> lines = null;

	public int pickItemsFromOrder(MOrder order, int AD_Org_ID) throws Exception {
		MOrderLine[] olines = order.getLines();
		MWarehouse wh = MWarehouse.get(order.getCtx(),
				order.getM_Warehouse_ID());

		lines = new ArrayList<MMPicklistLine>();
		
		int line = 0;
		for (MOrderLine oline : olines) {
			BigDecimal orderdQty = oline.getQtyReserved();
			BigDecimal remainingQty = orderdQty;

			if (remainingQty.signum() > 0) {
				MStorage[] storages = MStorage.getWarehouse(getCtx(), wh
						.getM_Warehouse_ID(), oline.getM_Product_ID(), 0,
						new Timestamp(System.currentTimeMillis()),
						MClient.MMPOLICY_FiFo.equals(oline.getProduct()
								.getMMPolicy()), true, 0, get_TrxName());

				for (MStorage storage : storages) {
					int M_Locator_ID = storage.getM_Locator_ID();

					String warehouseName = wh.getName();
					String locator = storage.getM_Locator().getValue();
					String sql = "SELECT COALESCE(SUM(pkl.qty),0) FROM M_PicklistLine pkl , C_OrderLine ol WHERE pkl.C_OrderLine_ID = ol.C_OrderLine_ID AND ol.qtyreserved > 0 AND pkl.M_Warehouse_ID = ? AND pkl.M_Locator_ID = ?";
					BigDecimal pickReserveQty = BigDecimal.valueOf(DB
							.getSQLValue(order.get_TrxName(), sql,
									wh.getM_Warehouse_ID(), M_Locator_ID));

					BigDecimal availableQty = storage.getQtyOnHand().subtract(
							pickReserveQty);

					log.fine(order.getDocumentNo() + " "
							+ oline.getProduct().getName() + " Location["
							+ warehouseName + ":" + locator + "]"
							+ " Qty Pick Reserverd [" + pickReserveQty
							+ "] Qty Available [" + availableQty + "]");

					if (availableQty.signum() > 0) {
						line = line + 10;
						MMPicklistLine pline = new MMPicklistLine(this);
						pline.setC_OrderLine_ID(oline.getC_OrderLine_ID());
						pline.setM_Product_ID(oline.getM_Product_ID());
						pline.setM_Warehouse_ID(storage.getM_Warehouse_ID());
						pline.setM_Locator_ID(storage.getM_Locator_ID());
						pline.setC_UOM_ID(oline.getC_UOM_ID());
						pline.setLine(line);

						/*
						 * Case 1 : Available Qty is enough for Order Reserved
						 * Qty Remaining Then set PickQty as Order Reserved Qty
						 * and Break Storage Loop 
						 * Case 2 : Available Qty is not
						 * enough for Order Reserved Qty Remaining Then set
						 * PickQty as Available Qty
						 */
						if (availableQty.compareTo(remainingQty) >= 0) {
							pline.setQty(remainingQty);
							remainingQty = remainingQty.subtract(remainingQty);
						} else {
							pline.setQty(availableQty);
							remainingQty = remainingQty.subtract(availableQty);
						}

						if (!pline.save(order.get_TrxName()))
							throw new AdempiereException(Msg.getMsg(getCtx(),
									ERR_CANNOT_SAVE_PICKLINE));
						
						lines.add(pline);
					}

					if (remainingQty.signum() <= 0)
						break;
				}

				// Qty is not Enough Create new Line
				if (remainingQty.signum() > 0) {
					line = line + 10;
					MMPicklistLine pline = new MMPicklistLine(this);
					pline.setC_OrderLine_ID(oline.getC_OrderLine_ID());
					pline.setM_Product_ID(oline.getM_Product_ID());
					pline.setC_UOM_ID(oline.getC_UOM_ID());
					pline.setLine(line);
					pline.setQty(remainingQty);
					pline.setRemarks("Item is not enough!");

					if (!pline.save(order.get_TrxName()))
						throw new AdempiereException(Msg.getMsg(getCtx(),
								ERR_CANNOT_SAVE_PICKLINE));
					
					lines.add(pline);
				}
			}

		}

		return line;
	}
	
	public List<MMPicklistLine> getLines(){
		return lines;
	}

	public void setOrder(MOrder order) {
		this.order = order;
	}

	public MOrder getOrder() {
		// TODO Auto-generated method stub
		return this.order;
	}

	public int pickItemsFromShipedOrder(MInOut shipment, int p_AD_Org_ID) {
		// TODO Auto-generated method stub
		lines = new ArrayList<MMPicklistLine>();
		MInOutLine[] shipLines = shipment.getLines();
		int line = 0;
		
		for(MInOutLine shipLine : shipLines ){
			line =  line +10;
			MMPicklistLine pline = new MMPicklistLine(this);
			pline.setC_OrderLine_ID(shipLine.getC_OrderLine_ID());
			pline.setM_Product_ID(shipLine.getM_Product_ID());
			pline.setM_Warehouse_ID(shipLine.getM_Warehouse_ID());
			pline.setM_Locator_ID(shipLine.getM_Locator_ID());
			pline.setC_UOM_ID(shipLine.getC_UOM_ID());
			pline.setLine(line);
			pline.setQty(shipLine.getQtyEntered());
			
			if (!pline.save(order.get_TrxName()))
				throw new AdempiereException(Msg.getMsg(getCtx(),
						ERR_CANNOT_SAVE_PICKLINE));
			
			lines.add(pline);
		}		
		
		return shipLines.length;
	}
}
