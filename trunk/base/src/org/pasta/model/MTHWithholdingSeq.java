package org.pasta.model;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.compiere.model.Query;


public class MTHWithholdingSeq extends X_TH_WithholdingSeq {
	
	public static String SYSTEM_VARIABLE_FOR_DOCUMENT_TIME_NAME = "TH_WITHHOLDING_TAX_SEQ_RUNNING_TIME";
	// Value For Document No Generated Time
	public static String BEFORE_SAVE_WHTAX_TRANSACTION = "S";
	public static String BEFORE_PRINT_WHTAX_CERTIFIED = "P";

	public MTHWithholdingSeq(Properties ctx, int TH_WithholdingSeq_ID,
			String trxName) {
		super(ctx, TH_WithholdingSeq_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MTHWithholdingSeq(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public static MTHWithholdingSeq getSequence(MCWHTaxTrans trans){
		String whereClause = MTHWithholdingSeq.COLUMNNAME_AD_Client_ID+ "= ? "
							+"AND "+MTHWithholdingSeq.COLUMNNAME_AD_Org_ID + " = ? "
							+"AND "+MTHWithholdingSeq.COLUMNNAME_IsActive + "= 'Y' ";
		
		List<Object> params = new ArrayList<Object>();
		params.add(trans.getAD_Client_ID());
		params.add(trans.getAD_Org_ID());
		
		MTHWithholdingSeq withholdingSeq = new Query(trans.getCtx(),MTHWithholdingSeq.Table_Name,whereClause.toString(),trans.get_TrxName())
		.setParameters(params)
		.first();
		
		return withholdingSeq;
	}
	
	public String getNextDocumentNo(Timestamp datetime){
		StringBuffer withholdingTaxNo = new StringBuffer();
		if(!StringUtils.isEmpty(getPrefix()))
			withholdingTaxNo.append(getPrefix());
		
		int budhaYear = -1;
		int monthNo = -1;
		
		if(isUseDatePrefix()){
			String format = getFormatDate();
			SimpleDateFormat sdFmt = new SimpleDateFormat(format,new Locale("th","TH")); 
			String prefixDate = sdFmt.format(datetime);
			
			log.finer("Use Date Format Prefix ["+format+"] "+prefixDate);
			withholdingTaxNo.append(prefixDate);
			
			if(isResetByYear()){
				budhaYear = datetime.getYear()+543;
			}
			
			if(isResetByMonth()){
				monthNo = datetime.getMonth()+1;
			}
		}
		
		int nextSeq = MTHWithholdingSeqRunning.getNextSequence(this, budhaYear, monthNo);
		
		withholdingTaxNo.append( StringUtils.leftPad(""+nextSeq,getSequenceDigit(), "0"));
		if(StringUtils.isEmpty(withholdingTaxNo.toString()))
			return "";
		
		return withholdingTaxNo.toString();
	}
}
