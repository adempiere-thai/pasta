package org.pasta.model;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.compiere.model.MBPartner;
import org.compiere.model.ModelValidationEngine;
import org.compiere.model.ModelValidator;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.DocumentEngine;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MSOJobsOrder extends X_SO_JobsOrder implements DocAction {

	private String m_processMsg;

	public MSOJobsOrder(Properties ctx, int SO_JobsOrder_ID, String trxName) {
		super(ctx, SO_JobsOrder_ID, trxName);
	}

	public boolean approveIt() {
		log.info("approveIt - " + toString());
		return true;
	}

	public boolean closeIt() {
		log.info(toString());
		// Before Close
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,ModelValidator.TIMING_BEFORE_CLOSE);
		if (m_processMsg != null)
			return false;
		
		
		
		setProcessed(true);
		setDocAction(DOCACTION_None);
		
		// After Close
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,ModelValidator.TIMING_AFTER_CLOSE);
		if (m_processMsg != null)
			return false;
		return true;
	}

	public String completeIt() {
		log.info(toString());
		
		// Before Completed
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this, ModelValidator.TIMING_BEFORE_COMPLETE);
		if (m_processMsg != null)
			return DocAction.STATUS_Invalid;
		
		setProcessed(true);
		String sql = "UPDATE SO_JobsOrderLine SET PROCESSED = 'Y' WHERE SO_JobsOrder_ID = ? ";
		int no_of_line = DB.executeUpdate(sql, getSO_JobsOrder_ID(), get_TrxName());
		
		// After Completed
		m_processMsg= ModelValidationEngine.get().fireDocValidate(this, ModelValidator.TIMING_AFTER_COMPLETE);
		if (m_processMsg != null)
			return DocAction.STATUS_Invalid;
		
		//
		setDocAction(DOCACTION_Close);
		return DocAction.STATUS_Completed;
	}
	
	public File createPDF() {
		return null;
	}

	public BigDecimal getApprovalAmt() {
		return Env.ZERO;
	}

	public int getC_Currency_ID() {
		return Env.getContextAsInt(this.getCtx(), "$C_Currency_ID");
	}
	
	public int getDoc_User_ID() {
		return getPersonInCharge_ID();
	}

	public String getDocumentInfo() {
		String info = "Order No. "+getC_Order().getDocumentNo()+" "+getPartner().getName();
		return null;
	}
	
	public MBPartner getPartner(){
		return MBPartner.get(getCtx(), getC_BPartner_ID());
	}

	public String getProcessMsg() {
		return m_processMsg;
	}

	public String getSummary() {
		
		return getDocumentInfo();
	}

	public boolean invalidateIt() {
		log.info(toString());
		setDocAction(DOCACTION_Prepare);
		return true;
	}

	public String prepareIt() {
		log.info(toString());
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this, ModelValidator.TIMING_BEFORE_PREPARE);
		if (m_processMsg != null)
			return DocAction.STATUS_Invalid;
		
		//Count Line
		String whereClause = X_SO_JobsOrderLine.COLUMNNAME_SO_JobsOrder_ID+" = ? ";
		int no_of_lines = new Query(getCtx(),X_SO_JobsOrderLine.Table_Name,whereClause,get_TrxName())
							.setParameters(getSO_JobsOrder_ID()).count();
		
		if(no_of_lines<0){
			m_processMsg = "@NoLines@";
			return DocAction.STATUS_Invalid;
		}
		
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this, ModelValidator.TIMING_AFTER_PREPARE);
		if (m_processMsg != null)
			return DocAction.STATUS_Invalid;
		
		return DocAction.STATUS_InProgress;
	}

	public boolean processIt(String action) throws Exception {
		m_processMsg = null;
		DocumentEngine engine = new DocumentEngine (this, getDocStatus());
		return engine.processIt (action, getDocAction());
	}

	public boolean reActivateIt() {
		return true;
	}

	public boolean rejectIt() {
		log.info("rejectIt - " + toString());
		return true;
	}

	public boolean reverseAccrualIt() {
		log.info(toString());
		// Before reverseAccrual
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,ModelValidator.TIMING_BEFORE_REVERSEACCRUAL);
		if (m_processMsg != null)
			return false;
		
		// After reverseAccrual
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,ModelValidator.TIMING_AFTER_REVERSEACCRUAL);
		if (m_processMsg != null)
			return false;
		
		return false;
	}

	public boolean reverseCorrectIt() {
		log.info(toString());
		// Before reverseCorrect
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,ModelValidator.TIMING_BEFORE_REVERSECORRECT);
		if (m_processMsg != null)
			return false;
		
		// After reverseCorrect
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,ModelValidator.TIMING_AFTER_REVERSECORRECT);
		if (m_processMsg != null)
			return false;
		
		return voidIt();
	}

	public boolean unlockIt() {
		log.info("unlockIt - " + toString());
		setProcessing(false);
		return true;
	}

	public boolean voidIt() {
		log.info(toString());
		// Before Void
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,ModelValidator.TIMING_BEFORE_VOID);
		if (m_processMsg != null)
			return false;
		
		// After Void
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this,ModelValidator.TIMING_AFTER_VOID);
		if (m_processMsg != null)
			return false;
		
		setProcessed(true);
		setDocAction(DOCACTION_None);
		return true;
	}
	
	public MSOJobsOrderLine[] getLines(){
		String whereClause = MSOJobsOrderLine.COLUMNNAME_SO_JobsOrder_ID+"= ? ";
		List<MSOJobsOrderLine> lineL = new Query(getCtx(),MSOJobsOrderLine.Table_Name,whereClause,get_TrxName())
								.setParameters(get_ID()).list();
		
		if(lineL == null || lineL.size() <= 0)
			return null;
		
		return lineL.toArray(new MSOJobsOrderLine[lineL.size()]);
	}
}
