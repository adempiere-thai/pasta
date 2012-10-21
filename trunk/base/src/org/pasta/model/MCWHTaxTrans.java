package org.pasta.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.apache.commons.lang.StringUtils;
import org.compiere.model.MSysConfig;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.pasta.util.DateTimeUtils;

public class MCWHTaxTrans extends X_C_WHTaxTrans {

	public MCWHTaxTrans(Properties ctx, int C_WHTaxTrans_ID, String trxName) {
		super(ctx, C_WHTaxTrans_ID, trxName);
	}

	public MCWHTaxTrans(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
	
	public static List<X_C_WHTaxTransLine> getLines(Properties ctx,int id,String trxName){
		if(id ==0 )
			throw new AdempiereException("NO_WHTAX_HEADER_ID");
		
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		
		String whereClause = MCWHTaxTransLine.COLUMNNAME_C_WHTaxTrans_ID + " = ? ";
		String orderBy = MCWHTaxTransLine.COLUMNNAME_C_RevenueType_ID;
		
		return new Query(ctx,X_C_WHTaxTransLine.Table_Name,whereClause.toString(),trxName)
					.setOrderBy(orderBy)
					.setParameters(params)
					.list();
	}

	protected boolean beforeSave(boolean newRecord) {
		if(newRecord){
			// make sure Withholding Tax Status Should Be 'Draft'
			setWHTCertifiedStatus(WHTCERTIFIEDSTATUS_Draft);
			setWithholdingAction(WITHHOLDINGACTION_Prepared);
		}
		
		if(StringUtils.isEmpty(getDocumentNo())){
			// Check SystemConfig Withholding Tax Was Generate When Save Transaction 
			if(MTHWithholdingSeq.BEFORE_SAVE_WHTAX_TRANSACTION.equalsIgnoreCase(MSysConfig.getValue(MTHWithholdingSeq.SYSTEM_VARIABLE_FOR_DOCUMENT_TIME_NAME))){
				MTHWithholdingSeq sequenceSetup = MTHWithholdingSeq.getSequence(this);
				
				Timestamp datetime = getDateDoc(); 
				if(sequenceSetup.getAD_DateColumn_ID() > 0)
					datetime =  (Timestamp)get_Value(sequenceSetup.getAD_DateColumn().getColumnName());
				
				String docNo = sequenceSetup.getNextDocumentNo(datetime);
				if(!StringUtils.isEmpty(docNo))
					setDocumentNo(docNo);
			}
		}
		
		// Default Sequence No
		if(getSeqNo() <= 0 || newRecord){
			if(MTHWithholdingSeq.BEFORE_SAVE_WHTAX_TRANSACTION.equalsIgnoreCase(MSysConfig.getValue(MTHWithholdingSeq.SYSTEM_VARIABLE_FOR_DOCUMENT_TIME_NAME))){
				String whereClause = this.COLUMNNAME_AD_Client_ID +" = ? AND "
									+this.COLUMNNAME_AD_Org_ID + " = ? AND "
									+this.COLUMNNAME_DateDoc + " >= ? AND " // From Date
									+this.COLUMNNAME_DateDoc + " <= ? ";
				
				List<Object> params = new ArrayList<Object>();
				params.add(getAD_Client_ID());
				params.add(getAD_Org_ID());
				params.add(DateTimeUtils.getFistDayOfMonth(getDateDoc()));
				params.add(DateTimeUtils.getLastDayOfMonth(getDateDoc()));
						
				BigDecimal maxSeq = new Query(this.getCtx(),this.Table_Name,whereClause,this.get_TrxName())
				.setParameters(params)
				.aggregate(this.COLUMNNAME_SeqNo, "max");
				
				if(maxSeq ==null)
					maxSeq = Env.ZERO;
				
				setSeqNo(maxSeq.intValue() + 1);
			}
		}
		
		return true;
	}

	protected boolean afterSave(boolean newRecord, boolean success) {
		if(newRecord)
			setDefaultWithholdingTaxLines();
		
		return true;
	}

	private void setDefaultWithholdingTaxLines() {
		List<X_C_BP_Withholding> partnerTaxes = null; 
		
		if(getC_BPartner_ID() > 0 )
			try {
				partnerTaxes = MCBPWithholding.getPartnerWithholdingTax(getCtx(), getC_BPartner_ID(), get_TrxName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.saveError(Msg.getMsg(getCtx(), "CANNOT_DEFAULT_WITHHOLDING_TAX_TRANSACTION_LINE")+" ["+getC_BPartner_ID()+"]", e);
			}
		
		if(partnerTaxes != null){
			for(X_C_BP_Withholding partnerTaxs : partnerTaxes){
				MCWHTaxTransLine line = new MCWHTaxTransLine(this,partnerTaxs);
				
				if(!line.save(this.get_TrxName()))
					log.warning(Msg.getMsg(getCtx(), "CANNOT_DEFAULT_WITHHOLDING_TAX_TRANSACTION_LINE"+" ["+getC_BPartner_ID()+"]"));
					
			}
		}
	}
}
