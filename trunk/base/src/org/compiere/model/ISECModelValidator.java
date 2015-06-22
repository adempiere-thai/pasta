package org.compiere.model;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.process.DocAction;
import org.compiere.util.CLogger;

public class ISECModelValidator implements ModelValidator   {

	public ISECModelValidator() {
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
		
		engine.addModelChange(MMovementConfirm.Table_Name, this);

		//engine.addDocValidate(MMovementConfirm.Table_Name, this);
	}

	/** Logger */
	private static CLogger log = CLogger.getCLogger(ISECModelValidator.class);
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

	@Override
	public String modelChange(PO po, int type) throws Exception {
		// TODO Auto-generated method stub
		log.info(po.get_TableName() + " Type: " + type);
		if (po.get_TableName().equals("M_MovementConfirm")
				&& type == ModelValidator.TYPE_AFTER_CHANGE )
			return autoconfirmMovement((MMovementConfirm) po);
		
		return null;
	}

	@Override
	public String docValidate(PO po, int timing) {
		log.info(po.get_TableName() + " Timing: " + timing);

		return null;
	}

	// FR 2980857 Inventory Move Confirmation AutoUpdate
	private String autoconfirmMovement(MMovementConfirm po) {
		log.info(MMovementConfirm.class
				+ ":after save via MyValidatorThailand after CompleteIt");
		if(!po.DOCSTATUS_Completed.equals(po.getDocStatus()))
			return null;
		
		MMovement move = new MMovement(po.getCtx(), po.getM_Movement_ID(),
				po.get_TrxName());
		
		if (!move.processIt(DocAction.ACTION_Complete))
		{
			log.warning("completeMovement - failed: " + move);
			throw new AdempiereException("Cannot Complete Movement");
		}
		move.saveEx();
		
		/*
		move.completeIt(); // by completing the originating MMovement the
							// inventory is resolved
		move.setDocStatus(X_M_MovementConfirm.DOCSTATUS_Completed); // now it
																	// sets
																	// Status to
																	// Complete
		/*if (!move.saveUpdate()) // now it updates work to DB
			return (MMovement.class + ":not updated");*/
		return null;
		// FR 2980857 -- end -- if ok return null;
	}

	/**
	 * String Representation
	 * 
	 * @return info
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer("ISECModelValidator[CUSTOM");sb.append("]");
		return sb.toString();
	} // toString

}
