package org.pasta.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.Query;

public class MTHWithholdingSeqRunning extends X_TH_WithholdingSeq_Running {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2551498055087777706L;

	public MTHWithholdingSeqRunning(Properties ctx,
			int TH_WithholdingSeq_Running_ID, String trxName) {
		super(ctx, TH_WithholdingSeq_Running_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MTHWithholdingSeqRunning(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public static int getNextSequence(MTHWithholdingSeq sequence,int budhaYear , int monthNo){
		int nextSeq = 1;
		StringBuffer whereClause = new StringBuffer(COLUMNNAME_TH_WithholdingSeq_ID + "= ? ");
		List<Object> params = new ArrayList<Object>();
		params.add(sequence.getTH_WithholdingSeq_ID());
		
		if(budhaYear > 0){
			whereClause.append("AND "+COLUMNNAME_BudhaYear+"= ? ");
			params.add(budhaYear);
		}
		
		if(monthNo > 0){
			whereClause.append("AND "+COLUMNNAME_MonthMM+"= ? ");
			params.add(monthNo);
		}
		
		MTHWithholdingSeqRunning seqRunning = new Query(sequence.getCtx(),MTHWithholdingSeqRunning.Table_Name,whereClause.toString(),sequence.get_TrxName())
											.setParameters(params)
											.first();
		
		if(seqRunning != null){
			nextSeq = seqRunning.getCurrentSeq();
			nextSeq++;
			
			seqRunning.setCurrentSeq(nextSeq);
			if(!seqRunning.save(sequence.get_TrxName()))
				throw new AdempiereException("CANNOT_UPDATE_WHTAX_SEQ_NEXT");
		}
		else{
			seqRunning = new MTHWithholdingSeqRunning(sequence,budhaYear,monthNo);
			seqRunning.setCurrentSeq(nextSeq);
			if(!seqRunning.save(sequence.get_TrxName()))
				throw new AdempiereException("CANNOT_INSERT_NEW_WHTAX_SEQ_NEXT");
		}
		
		return nextSeq;
	}

	private MTHWithholdingSeqRunning(MTHWithholdingSeq sequence,int year , int month){
		this(sequence.getCtx(),0,sequence.get_TrxName());
		
		log.fine("New Withholding Tax Running Year ["+year+"] Month["+month+"]");
		setTH_WithholdingSeq_ID(sequence.getTH_WithholdingSeq_ID());
		setBudhaYear(year);
		setMonthMM(month);
		
	}
}
