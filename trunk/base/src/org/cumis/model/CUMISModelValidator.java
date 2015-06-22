package org.cumis.model;

import java.math.BigDecimal;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.compiere.model.MClient;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.MProduct;
import org.compiere.model.MStorage;
import org.compiere.model.ModelValidationEngine;
import org.compiere.model.ModelValidator;
import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.compiere.util.Msg;

public class CUMISModelValidator implements ModelValidator   {

	public CUMISModelValidator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(ModelValidationEngine engine, MClient client) {
		// client = null for global validator
		if (client != null) {
			m_AD_Client_ID = client.getAD_Client_ID();
			log.info(client.toString());
		} else {
			log.info("Initializing global validator: " + this.toString());
		}
		
		/// Add Validation for Order
		engine.addDocValidate(MOrder.Table_Name, this);

		//engine.addDocValidate(MMovementConfirm.Table_Name, this);
	}

	/** Logger */
	private static CLogger log = CLogger.getCLogger(CUMISModelValidator.class);
	/** Client */
	private int m_AD_Client_ID = -1;
	/** User */
	private int m_AD_User_ID = -1;
	/** Role */
	private int m_AD_Role_ID = -1;

	/** for SinglePaySchedule */

	/**
	 * User Login. Called when preferences are set
	 * 
	 * @param AD_Org_ID
	 *            org
	 * @param AD_Role_ID
	 *            role
	 * @param AD_User_ID
	 *            user
	 * @return error message or null
	 */
	public String login(int AD_Org_ID, int AD_Role_ID, int AD_User_ID) {
		log.info("AD_User_ID=" + AD_User_ID);
		m_AD_User_ID = AD_User_ID;
		m_AD_Role_ID = AD_Role_ID;
		return null;
	} // login

	/**
	 * Get Client to be monitored
	 * 
	 * @return AD_Client_ID client
	 */
	public int getAD_Client_ID() {
		return m_AD_Client_ID;
	} // getAD_Client_ID
	
	private Properties m_ctx;
	
	private String trxName = "";
	
	String message = "";

	public String docValidate(PO po, int timing) {
		log.info(po.get_TableName() + " Timing: " + timing);
		m_ctx = po.getCtx();
		trxName = po.get_TrxName();
		String msg ="";
		
		if(MOrder.Table_Name.equals(po.get_TableName())){
			MOrder order = (MOrder)po;
			if(order.isSOTrx()){
				if( TIMING_BEFORE_PREPARE  == timing ){
					if(!isItemsSufficient(order) && order.isCheckAvailable()){
						return this.message;

						/*log.saveWarning("Warning", this.message);

						if(!org.adempiere.webui.window.FDialog.ask(1,null,this.message)){
							return Msg.getMsg(m_ctx, "CancelledCompleted");
						}*/
					}
				}
			}
		}
		
		if(!StringUtils.isEmpty(msg))
			return Msg.getMsg(m_ctx, msg);
		
		return null;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer("ISECModelValidator[CUSTOM");sb.append("]");
		return sb.toString();
	} // toString
	
	private boolean isItemsSufficient(MOrder order) {
		// TODO Auto-generated method stub
		MOrderLine[] lines = order.getLines();
		for(MOrderLine line : lines){
			MProduct product = line.getProduct();
			if (product.isStocked())
			{
				BigDecimal QtyOrdered = line.getQtyOrdered();
				int M_Warehouse_ID = line.getM_Warehouse_ID();
				int M_AttributeSetInstance_ID = line.getM_AttributeSetInstance_ID();
				BigDecimal available = MStorage.getQtyAvailable
					(M_Warehouse_ID, product.getM_Product_ID(), M_AttributeSetInstance_ID, null);
				
				if (available.compareTo(QtyOrdered) < 0){
					message = product.getName()+" is insufficient! (Available : "+available.intValue()+")";
					return false;
				}
				
			}	//	stocked
		}
		
		return true;
	}

	@Override
	public String modelChange(PO po, int type) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
