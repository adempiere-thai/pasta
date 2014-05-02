package org.gbv.process;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.webui.apps.AEnv;
import org.apache.commons.lang.StringUtils;
import org.compiere.apps.AWindow;
import org.compiere.model.MInOut;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.MQuery;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.pasta.model.MMMMatchPickPack;
import org.pasta.model.MMMPackage;
import org.pasta.model.MMMPackageLine;
import org.pasta.model.MMPicklist;
import org.pasta.model.MMPicklistLine;
import org.posterita.businesslogic.MinOutManager;

public class GenPicklist extends SvrProcess {
	
	private static final String ERR_CANNOT_SAVE_PACK_HEADER = "CANNOT_SAVE_PACK_HEADER";
	private static final String ERR_PICKLIST_WAS_GENERATED = "PICKLIST_WAS_GENERATED_FOR_ORDER";
	private static final String ERR_CANNOT_SAVE_PICKLIST_HDR = "CANNOT_SAVE_PICKLIST";
	private static final String ERR_CANNOT_SAVE_PACK_LINE = "CANNOT_SAVE_PACK_LINE";
	private static final String ERR_CANNOT_SAVE_MATCHPP = "CANNOT_SAVE_MATCH_PICK_PACK";
	
	private int				p_AD_Org_ID ;
	private int				p_C_Order_ID;

	protected void prepare() {
		// TODO Auto-generated method stub
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++)
		{
			String name = para[i].getParameterName();
			if (para[i].getParameter() == null)
					;
			else if (name.equals("AD_Org_ID"))
				p_AD_Org_ID = ((BigDecimal)para[i].getParameter()).intValue();
			else if (name.equals("C_Order_ID"))
				p_C_Order_ID = ((BigDecimal)para[i].getParameter()).intValue();
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}
	}
	
	private final String ERR_ORDER_SHIPED = "ORDER_ALREADY_SHIPED";
	private final String ERR_ORG_NOT_MATCH = "ORDER_ORGANIZATION_IS_NOT_MATCH_WITH_PARAM"; 

	@Override
	protected String doIt() throws Exception {
		// TODO Auto-generated method stub
		MOrder order = new MOrder(getCtx(),p_C_Order_ID,get_TrxName());
		
		if(p_AD_Org_ID != order.getAD_Org_ID())
			throw new AdempiereException(ERR_ORG_NOT_MATCH);
		
		MMPicklist picklist = MMPicklist.getPicklistFromOrder(order);
		
		if(picklist != null){
			throw new AdempiereException(ERR_PICKLIST_WAS_GENERATED);
		}
		
		picklist = new MMPicklist(getCtx(),0,get_TrxName());
		picklist.setAD_Org_ID(p_AD_Org_ID);
		picklist.setC_Order_ID(order.getC_Order_ID());
		picklist.setDocumentNo(order.getDocumentNo());
		picklist.setPickBy(Env.getAD_User_ID(getCtx())); // Set Pick BY as Login User
		picklist.setOrder(order);
		
		if(!picklist.save(get_TrxName()))
			throw new AdempiereException(ERR_CANNOT_SAVE_PICKLIST_HDR);
		
		
		int line = 0 ;
		if(isShipedOrder(order))
			line = picklist.pickItemsFromShipedOrder(shipment,p_AD_Org_ID);
		else
			line = picklist.pickItemsFromOrder(order,p_AD_Org_ID);
		
		if(line <= 0)
			throw new AdempiereException(Msg.getMsg(getCtx(), ERR_ORDER_SHIPED));
		
		// Generate Pack
		generatePackage(picklist);
		
		//popupPicklistWindows(picklist.getM_Picklist_ID());
		
		return picklist.getDocumentNo();
	}
	
	private MInOut shipment = null;
	
	private boolean isShipedOrder(MOrder order) {
		// TODO Auto-generated method stub
		List<Object> params = new ArrayList<Object>();
		params.add(order.getC_Order_ID());

		String whereClause = MInOut.COLUMNNAME_C_Order_ID + " = ? AND "+MInOut.COLUMNNAME_DocStatus +" NOT IN ('VO','RE') ";

		Object obj = new Query(order.getCtx(), MInOut.Table_Name,
				whereClause.toString(), order.get_TrxName()).setParameters(
				params).first();

		if (obj == null) {
			return false;
		}
		
		shipment = (MInOut)obj;

		return true;
	}

	private void popupPicklistWindows(int recordId) {
		/** AD_Window_ID of purchase order window */
		 /** filter the data - needs to be generated for real use... */
		 String whereString = " M_Picklist_ID = "+recordId; 
		 //final AWindow popupWindows = new AWindow(); 
		 final MQuery query = new MQuery("M_Picklist"); 
		 query.addRestriction(whereString); 
		 AEnv.zoom(recordId, query);
		 AEnv.zoom(query);
	}

	private void generatePackage(MMPicklist picklist) throws Exception {
		List<MMPicklistLine> plines = picklist.getLines();
		boolean isNewPack = true; 
		MMMPackage pack = null;
		
		List<String> packageL = new ArrayList<String>();
		 
		BigDecimal packLimitedQty = BigDecimal.valueOf(6d);
		BigDecimal currentPackQty = BigDecimal.valueOf(0d);
		int running = 0;
		
		for(MMPicklistLine pline : plines){
			if(pline.getM_Locator_ID() > 0) // Check Pick Line is not the Empty Line
			{
				BigDecimal qty = pline.getQty();
				BigDecimal remainingQtyInPreviousPack = BigDecimal.valueOf(0d);
				if(currentPackQty.signum() > 0)
					remainingQtyInPreviousPack = packLimitedQty.subtract(currentPackQty);
				
				//int totalPack = (qty.add(remainingQtyInPreviousPack)).divide(packLimitedQty,0,BigDecimal.ROUND_UP).intValue();
				
				int totalPack = calculateTotalPack(qty,remainingQtyInPreviousPack,packLimitedQty);
				for(int i=0;i<totalPack ; i++){
					if(isNewPack){
						running++;
						pack = new MMMPackage(picklist.getOrder(),running);
						pack.setAD_Org_ID(p_AD_Org_ID);
						if(!pack.save(get_TrxName()))
							throw new AdempiereException(Msg.getMsg(getCtx(), ERR_CANNOT_SAVE_PACK_HEADER));
						
						isNewPack = false;
						currentPackQty = Env.ZERO;
						
						packageL.add(pack.getDocumentNo());
					}
					
					MMMPackageLine packLine = new MMMPackageLine(pack);
					packLine.setM_Product_ID(pline.getM_Product_ID());
					packLine.setC_OrderLine_ID(pline.getC_OrderLine_ID());
					packLine.setM_PicklistLine_ID(pline.getM_PicklistLine_ID());
					
					BigDecimal remainingSpaceQty = packLimitedQty.subtract(currentPackQty);
					
					if(qty.compareTo(remainingSpaceQty) > 0) {
						packLine.setPackQty(remainingSpaceQty);
						qty = qty.subtract(remainingSpaceQty);
						currentPackQty = currentPackQty.add(remainingSpaceQty);
					}
					else{
						packLine.setPackQty(qty);
						currentPackQty = currentPackQty.add(qty);
						qty = Env.ZERO;
					}
					
					if(!packLine.save(get_TrxName()))
						throw new AdempiereException(Msg.getMsg(getCtx(), ERR_CANNOT_SAVE_PACK_LINE));
					
//					matchPickPack(pline,pack);
					
					if(currentPackQty.compareTo(packLimitedQty)>=0){
						isNewPack = true;
					}
				} /// End Pack Loop
			}
		}
		
		String packagesToUpdate = StringUtils.join(packageL.iterator(), ",");  
		log.fine("Package To Update To Invoice : "+packagesToUpdate);
		updatePackageToInvoice(packagesToUpdate);
	}

	/** Private Function Using To Calculate No Of Pack Using to Pack Item In Pick Line*/
	private int calculateTotalPack(BigDecimal qty,
			BigDecimal remainingQtyInPreviousPack, BigDecimal packLimitedQty) {
		// TODO Auto-generated method stub
		
		int totalPack = 0;
		
		if(remainingQtyInPreviousPack.signum() >0){
			qty = qty.subtract(remainingQtyInPreviousPack);
			totalPack++;
		}
		
		while(qty.signum() >0){
			qty = qty.subtract(packLimitedQty);
			totalPack++;
		}
		
		return totalPack;
	}

	private void updatePackageToInvoice(String packagesToUpdate) {
		// TODO Auto-generated method stub
		String sqlUpdate = "UPDATE C_INVOICE SET PACKINGNO = '"+packagesToUpdate+"' WHERE C_ORDER_ID = ? AND DOCSTATUS='CO' " ;
		
		if(DB.executeUpdate(sqlUpdate, p_C_Order_ID, get_TrxName())<0)
			log.warning("Package No was not updated to Invoice");
	}

	private void matchPickPack(MMPicklistLine pline, MMMPackage pack) throws Exception {
		MMMMatchPickPack matchPP = new MMMMatchPickPack(pline,pack);
		if(!matchPP.save(pack.get_TrxName()))
			throw new AdempiereException(Msg.getMsg(getCtx(), ERR_CANNOT_SAVE_MATCHPP));
		
	}
}
