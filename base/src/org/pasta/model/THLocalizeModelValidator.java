package org.pasta.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.apache.commons.lang.StringUtils;
import org.compiere.acct.Doc;
import org.compiere.acct.DocLine;
import org.compiere.acct.Fact;
import org.compiere.acct.FactLine;
import org.compiere.model.FactsValidator;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAllocationHdr;
import org.compiere.model.MAllocationLine;
import org.compiere.model.MClient;
import org.compiere.model.MInvoice;
import org.compiere.model.MPayment;
import org.compiere.model.MPaymentAllocate;
import org.compiere.model.MSysConfig;
import org.compiere.model.MWithholding;
import org.compiere.model.ModelValidationEngine;
import org.compiere.model.ModelValidator;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.model.X_C_BP_Withholding;
import org.compiere.model.X_C_Withholding_Acct;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Msg;

public class THLocalizeModelValidator implements ModelValidator, FactsValidator {
	/** Logger */
	private static CLogger log = CLogger.getCLogger(THLocalizeModelValidator.class);
	
	/** Client */
	private int m_AD_Client_ID = -1;
	/** User */
	private int m_AD_User_ID = -1;
	/** Role */
	private int m_AD_Role_ID = -1;

	/** Organization **/
	private int m_AD_Org_ID = -1;

	public int getAD_Client_ID() {
		return m_AD_Client_ID;
	}
	
	private Properties m_ctx;
	
	private String trxName = "";

	public void initialize(ModelValidationEngine engine, MClient client) {
		// client = null for global validator
		if (client != null) {
			m_AD_Client_ID = client.getAD_Client_ID();
			log.info(client.toString());
		} else {
			log.info("Initializing Validator: " + this.toString());
		}

		// Add Document Validator 
		engine.addDocValidate(MPayment.Table_Name, this);
		engine.addDocValidate(MAllocationHdr.Table_Name, this);
		
		/// Add Validation for Credit Memo
		engine.addDocValidate(MInvoice.Table_Name, this);
		
		// Add Fact Validator
		engine.addFactsValidate(MPayment.Table_Name, this);
		engine.addFactsValidate(MAllocationHdr.Table_Name, this);
		
	}

	public String login(int AD_Org_ID, int AD_Role_ID, int AD_User_ID) {
		m_AD_User_ID = AD_User_ID;
		m_AD_Role_ID = AD_Role_ID;
		m_AD_Org_ID = AD_Org_ID;
		
		return null;
	}
	
	public String docValidate(PO po, int timing) {
		m_ctx = po.getCtx();
		trxName = po.get_TrxName();
		String msg ="";
		
		if(MPayment.Table_Name.equals(po.get_TableName())){
			MPayment payment = (MPayment)po;
			X_C_Payment x_payment = new X_C_Payment(m_ctx,payment.getC_Payment_ID(),trxName);
			if(TIMING_AFTER_COMPLETE == timing){
				setWithholdingStatus(X_C_WHTaxTrans.WHTCERTIFIEDSTATUS_Used,payment);
				MAllocationHdr[] allocates = MAllocationHdr.getOfPayment(m_ctx, payment.getC_Payment_ID(), trxName);
				for(MAllocationHdr m_allocate : allocates){
					X_C_AllocationHdr x_allocate = new X_C_AllocationHdr(m_ctx, m_allocate.getC_AllocationHdr_ID(), trxName);
					
					x_allocate.setWithholdingAmt(x_payment.getWithholdingAmt());
					if(!x_allocate.save(trxName))
						msg = "CANNOT_SAVE_WITHHOLDING_AMT_ALLOCATE" ;
				}
			}else if(TIMING_AFTER_REVERSECORRECT == timing){
				setWithholdingStatus(X_C_WHTaxTrans.WHTCERTIFIEDSTATUS_Prepared,payment);
				
				// Set Reverse Document 
				X_C_Payment reverse = new X_C_Payment(m_ctx,payment.getReversal_ID(),trxName);
				reverse.setWithholdingAmt(reverse.getWithholdingAmt().negate());
				
				if(!reverse.save(trxName))
					msg = "CANNOT_REVERSE_WITHHOLDING_TAX_AMT";
			}
		}
		if(MInvoice.Table_Name.equals(po.get_TableName())){
			MInvoice invoice = (MInvoice)po;
			if(invoice.isSOTrx() && invoice.isCreditMemo()){
				if( TIMING_BEFORE_COMPLETE  == timing ){
					String errMessage = validationCreditMemo(invoice);
					if(!StringUtils.isEmpty(errMessage)){
						msg = errMessage;
					}
				}
			}
		}
		
		if(!StringUtils.isEmpty(msg))
			return Msg.getMsg(m_ctx, msg);
		
		return null;
	}

	private String validationCreditMemo(MInvoice creditNote) {
		/** Validation Credit Memo
		 *  1. Check Orgiginal Invoice Date Should Open Before Credit Note Invoice Date
		 *  2. Check Client,Organization,BusinessPartner,Price list and Currency should match with original Invoice 
		 **/
		String errMsg = "";
		MInvoice invoice = MInvoice.get(creditNote.getCtx(), creditNote.getRef_Invoice_ID());
		
		if(invoice.getAD_Org_ID() != creditNote.getAD_Org_ID() ||
			invoice.getC_BPartner_ID() != creditNote.getC_BPartner_ID() ||
				invoice.getM_PriceList_ID() != creditNote.getM_PriceList_ID() ||
					invoice.getC_Currency_ID() != creditNote.getC_Currency_ID())
		{
			errMsg = "CREDIT_NOTE_INFO_NOT_MATCH_INVOICE";
		}
		else if(!creditNote.getDateInvoiced().after(invoice.getDateInvoiced())){
			errMsg = "CREDIT_NOTE_DATE_BEFORE_INVOICE_DATE";
		}
		
		return errMsg;
	}

	public String factsValidate(MAcctSchema as, List<Fact> facts, PO po) {
		m_ctx = po.getCtx();
		trxName = po.get_TrxName();
		
		Doc doc = po.getDoc();
		
		if(MPayment.Table_Name.equals(po.get_TableName())){
			X_C_Payment payment = new X_C_Payment(m_ctx,po.get_ID(),trxName);
			
			// Case Charge Payment + Withholding Tax
			if(payment.getC_Charge_ID() > 0 
					&& payment.getWithholdingAmt().signum() !=  0 
					&& !payment.isReceipt())
			{
				BigDecimal withholdingAmt = payment.getWithholdingAmt();
				for(Fact fact : facts){
					FactLine[] lines = fact.getLines();
					MAccount acct = doc.getAccount(Doc.ACCTTYPE_BankInTransit, as);
					
					for(FactLine line : lines){
						if(acct.equals(line.getAccount())){
							if( payment.DOCSTATUS_Completed.equals(payment.getDocStatus())){
								line.setAmtAcct(line.getAmtAcctDr(), line.getAmtAcctCr().subtract(withholdingAmt));
								line.setAmtSource(payment.getC_Currency_ID(), line.getAmtSourceDr(), line.getAmtSourceCr());
							}
							else{ 
								line.setAmtAcct(line.getAmtAcctDr().add(withholdingAmt), line.getAmtAcctCr());
								line.setAmtSource(payment.getC_Currency_ID(), line.getAmtSourceDr(), line.getAmtSourceCr());
							}
						}
					}
					// Add Withholding Tax 
					MWithholding withholding = getWithholding(payment.getC_BPartner_ID());
					if(withholding == null)
						new AdempiereException("CANNOT_FOUND_BPARTNER_WITHHOLDING_TAX");
					
					// Found Account
					String whereClause = X_C_Withholding_Acct.COLUMNNAME_C_Withholding_ID+" = ? AND "+
											X_C_Withholding_Acct.COLUMNNAME_C_AcctSchema_ID + " = ? ";
					
					Object[] params = {withholding.getC_Withholding_ID(),as.getC_AcctSchema_ID()};
					
					X_C_Withholding_Acct whtAcct = new Query(m_ctx,X_C_Withholding_Acct.Table_Name,whereClause,trxName)
													.setParameters(params).first();
					
					int C_ValidCombination_ID =  whtAcct.getWithholding_Acct();
					MAccount account = MAccount.get(m_ctx, C_ValidCombination_ID);
					
					DocLine line = new DocLine(payment,doc);
					fact.createLine(line, account, payment.getC_Currency_ID(), Env.ZERO, withholdingAmt);
				}
			}
			else if( payment.getWithholdingAmt().signum() !=  0 && !payment.isReceipt())
			{
				BigDecimal withholdingAmt = payment.getWithholdingAmt();
				for(Fact fact : facts){
					FactLine[] lines = fact.getLines();
					MAccount bank_acct = doc.getAccount(Doc.ACCTTYPE_BankInTransit, as);
					MAccount pay_acct = doc.getAccount(Doc.ACCTTYPE_PaymentSelect, as);
					
					for(FactLine line : lines){
						if(bank_acct.equals(line.getAccount())){
							if( payment.DOCSTATUS_Completed.equals(payment.getDocStatus())){
								line.setAmtAcct(line.getAmtAcctDr(), line.getAmtAcctCr().subtract(withholdingAmt));
								line.setAmtSource(payment.getC_Currency_ID(), line.getAmtSourceDr(), line.getAmtSourceCr());
							}
							else{ 
								line.setAmtAcct(line.getAmtAcctDr().add(withholdingAmt), line.getAmtAcctCr());
								line.setAmtSource(payment.getC_Currency_ID(), line.getAmtSourceDr(), line.getAmtSourceCr());
							}
						}
						
						if(pay_acct.equals(line.getAccount())){
							if( payment.DOCSTATUS_Completed.equals(payment.getDocStatus())){
								line.setAmtAcct(line.getAmtAcctDr().subtract(withholdingAmt), line.getAmtAcctCr());
								line.setAmtSource(payment.getC_Currency_ID(), line.getAmtSourceDr(), line.getAmtSourceCr());
							}
							else{ 
								line.setAmtAcct(line.getAmtAcctDr(), line.getAmtAcctCr().add(withholdingAmt));
								line.setAmtSource(payment.getC_Currency_ID(), line.getAmtSourceDr(), line.getAmtSourceCr());
							}
						}
					}
				}
			}
		}
		else if(MAllocationHdr.Table_Name.equals(po.get_TableName())){
			X_C_AllocationHdr allcation = new X_C_AllocationHdr(m_ctx,po.get_ID(),trxName);
			MAllocationHdr m_allocation = (MAllocationHdr)po;
			
			int C_BPartner_ID = 0;
			int C_Currency_ID = 0;
			boolean postWHTax = false;
			
			MAllocationLine[] allLines = m_allocation.getLines(true);
			for(MAllocationLine m_line:allLines){
				if(m_line.getC_BPartner_ID() > 0 && m_line.getC_Payment_ID() > 0 ){
					if(m_line.getC_Payment().getC_Charge_ID() <= 0){
						postWHTax = true;
						C_BPartner_ID = m_line.getC_BPartner_ID();
						C_Currency_ID = m_line.getC_Payment().getC_Currency_ID(); 
						break;
					}
				}
			}
			
			if(allcation.getWithholdingAmt().signum() != 0 && postWHTax){
				BigDecimal whTaxAmt = allcation.getWithholdingAmt();
				for(Fact fact : facts){
					FactLine[] lines = fact.getLines();
					MAccount pay_Acct = doc.getAccount(Doc.ACCTTYPE_PaymentSelect, as);
					
					for(FactLine line : lines){
						if(pay_Acct.equals(line.getAccount())){
							line.setAmtAcct(line.getAmtAcctDr(), line.getAmtAcctCr().subtract(whTaxAmt));
							line.setAmtSource(C_Currency_ID, line.getAmtSourceDr(), line.getAmtSourceCr().subtract(whTaxAmt));
						}
					}
					
					MWithholding withholding = getWithholding(C_BPartner_ID);
					if(withholding == null)
						new AdempiereException("CANNOT_FOUND_BPARTNER_WITHHOLDING_TAX");
					
					// Found Account
					String whereClause = X_C_Withholding_Acct.COLUMNNAME_C_Withholding_ID+" = ? AND "+
											X_C_Withholding_Acct.COLUMNNAME_C_AcctSchema_ID + " = ? ";
					
					Object[] params = {withholding.getC_Withholding_ID(),as.getC_AcctSchema_ID()};
					
					X_C_Withholding_Acct whtAcct = new Query(m_ctx,X_C_Withholding_Acct.Table_Name,whereClause,trxName)
													.setParameters(params).first();
					
					int C_ValidCombination_ID =  whtAcct.getWithholding_Acct();
					MAccount account = MAccount.get(m_ctx, C_ValidCombination_ID);
					
					DocLine line = new DocLine(allcation,doc);
					FactLine fLine = fact.createLine(line, account, C_Currency_ID, Env.ZERO, whTaxAmt);
					fLine.setC_BPartner_ID(C_BPartner_ID);
					fLine.save();
				}
			}
		}

		return null;
	}
	
	private void setWithholdingStatus(String changeStatus,MPayment payment) {
		List<MCMatchWHTax> matchs = getWHTaxMap(payment.getC_Payment_ID());
		
		if(matchs == null || matchs.size() == 0)
			return ;
		
		for(MCMatchWHTax match : matchs){
			 X_C_WHTaxTrans trans = (X_C_WHTaxTrans)match.getC_WHTaxTrans();
			trans.setWHTCertifiedStatus(changeStatus);
			trans.setProcessed(true);
			
			if(!trans.save(trxName))
				throw new AdempiereException("CANNOT_UPDATE_WHTAX_CERTIFIED_STATUS "+changeStatus);
		}
	}
	
	private List<MCMatchWHTax> getWHTaxMap(int C_Payment_ID){
		String whereClause = MCMatchWHTax.COLUMNNAME_C_Payment_ID + "= ? ";
		List<MCMatchWHTax> matchs = new Query(m_ctx, MCMatchWHTax.Table_Name, whereClause, trxName)
								.setParameters(C_Payment_ID).list();
		
		return matchs;
	}
	
	private MWithholding getWithholding(int C_BPartner_ID){
		String whereClause = X_C_BP_Withholding.COLUMNNAME_C_BPartner_ID +" = ? AND IsActive = 'Y' ";
		X_C_BP_Withholding bpWH = new Query(m_ctx, X_C_BP_Withholding.Table_Name, whereClause, trxName)
								.setParameters(C_BPartner_ID).first();
		
		if(bpWH == null)
			return null;
		
		MWithholding withholding = (MWithholding)bpWH.getC_Withholding();
		return withholding;
	}

	@Override
	public String modelChange(PO po, int type) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
