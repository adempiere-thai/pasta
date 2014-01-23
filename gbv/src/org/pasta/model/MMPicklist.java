package org.pasta.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MClient;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.MStorage;
import org.compiere.model.MWarehouse;
import org.compiere.model.Query;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MMPicklist extends X_M_Picklist {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8217429824971523609L;
	private static final String ERR_CANNOT_SAVE_PICKLINE = "CANNOT_SAVE_PICKLIST_LINE";

	public MMPicklist(Properties ctx, int M_Picklist_ID, String trxName) {
		super(ctx, M_Picklist_ID, trxName);

		setDateDoc(new Timestamp(System.currentTimeMillis()));
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

	public void pickItemsFromOrder(MOrder order, int AD_Org_ID)
			throws Exception {
		MOrderLine[] olines = order.getLines();

		MWarehouse[] whs = MWarehouse.getForOrg(getCtx(), AD_Org_ID);
		if (whs == null || whs.length <= 0)
			throw new AdempiereException("ERR_NO_WAREHOUSE_FOR_ORG");

		MWarehouse wh = whs[0];

		int line = 0;
		BigDecimal currentPackQty = Env.ZERO;
		BigDecimal packLimit = BigDecimal.valueOf(6d);
		int packNo = 1;

		for (MOrderLine oline : olines) {
			BigDecimal orderdQty = oline.getQtyReserved();
			BigDecimal remainingQty = orderdQty;
			// Find Total Pack For Order Line
			int no_of_packs = orderdQty.add(currentPackQty).divide(packLimit, 0, BigDecimal.ROUND_UP).intValue();

			MStorage[] storages = MStorage.getWarehouse(getCtx(), wh
					.getM_Warehouse_ID(), oline.getM_Product_ID(), 0,
					new Timestamp(System.currentTimeMillis()),
					MClient.MMPOLICY_FiFo.equals(oline.getProduct()
							.getMMPolicy()), true, 0, get_TrxName());

			for(int n = 0; n < no_of_packs;n++){
				BigDecimal pickQty =  remainingQty;
				if(currentPackQty.signum() != 0 ){ // If Previous Pack Still Have Space
					pickQty = packLimit.subtract(currentPackQty);
				}
				else{
					// If Remaining Qty More Than Pack Qty 
					if(remainingQty.compareTo(packLimit) > 0)
						pickQty = packLimit;
				}
				
				currentPackQty = currentPackQty.add(pickQty);
				
				for (MStorage storage : storages) {
					int M_Locator_ID = storage.getM_Locator_ID();

					String sql = "SELECT COALESCE(SUM(pkl.qty),0) FROM M_PicklistLine pkl , C_OrderLine ol WHERE pkl.C_OrderLine_ID = ol.C_OrderLine_ID AND ol.qtyreserved > 0 AND pkl.M_Warehouse_ID = ? AND pkl.M_Locator_ID = ?";
					BigDecimal pickReserveQty = BigDecimal.valueOf(DB.getSQLValue(
							order.get_TrxName(), sql, wh.getM_Warehouse_ID(),
							M_Locator_ID));
					BigDecimal availableQty = storage.getQtyOnHand().subtract(
							pickReserveQty);

					if (availableQty.signum() > 0) {

						line = line + 10;
						MMPicklistLine pline = new MMPicklistLine(this);
						pline.setC_OrderLine_ID(oline.getC_OrderLine_ID());
						pline.setM_Product_ID(oline.getM_Product_ID());
						pline.setM_Warehouse_ID(storage.getM_Warehouse_ID());
						pline.setM_Locator_ID(storage.getM_Locator_ID());
						pline.setC_UOM_ID(oline.getC_UOM_ID());
						pline.setLine(line);

						BigDecimal actualQty = pickQty; // Actual Pick Qty In Line used to substract from remaining Qty
						// Order Qty is Less Than or Equals To Zero Then Generate
						// Pick Line From All Order Qty
						if (availableQty.compareTo(pickQty) >= 0) {
							pline.setQty(pickQty);
						} else {
							pline.setQty(availableQty);
							actualQty = availableQty;
						}

						pickQty = pickQty.subtract(availableQty);
						
						pline.setPackingNo(order.getDocumentNo()+"-"+packNo);

						if (!pline.save(order.get_TrxName()))
							throw new AdempiereException(ERR_CANNOT_SAVE_PICKLINE);
						
						remainingQty = remainingQty.subtract(actualQty);
					}

					if (pickQty.signum() <= 0)
						break;
				}
				
				if(currentPackQty.equals(packLimit)){
					packNo++;
					currentPackQty = Env.ZERO;
				}
			}
			
			// Generate Not enough Line Items
			if(remainingQty.signum() > 0){
				line = line + 10;
				MMPicklistLine pline = new MMPicklistLine(this);
				pline.setC_OrderLine_ID(oline.getC_OrderLine_ID());
				pline.setM_Product_ID(oline.getM_Product_ID());
				//pline.setM_Warehouse_ID(storage.getM_Warehouse_ID());
				//pline.setM_Locator_ID(storage.getM_Locator_ID());
				pline.setC_UOM_ID(oline.getC_UOM_ID());
				pline.setLine(line);
				pline.setQty(remainingQty);
				pline.setRemarks("Item is not enough!");
				
				if (!pline.save(order.get_TrxName()))
					throw new AdempiereException(ERR_CANNOT_SAVE_PICKLINE);

			}
		}
	}
}
