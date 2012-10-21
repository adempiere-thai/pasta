package org.pasta.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.util.Env;

public class MCWHTaxTransLine extends X_C_WHTaxTransLine {

	public MCWHTaxTransLine(Properties ctx, int C_WHTaxTransLine_ID,
			String trxName) {
		super(ctx, C_WHTaxTransLine_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MCWHTaxTransLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MCWHTaxTransLine(MCWHTaxTrans trans, X_C_BP_Withholding tax) {
		this(trans.getCtx(),0,trans.get_TrxName());
		setC_WHTaxTrans_ID(trans.getC_WHTaxTrans_ID());
		setC_RevenueType_ID(tax.getC_RevenueType_ID());
		setC_Withholding_ID(tax.getC_Withholding_ID());
		setTaxBaseAmt(Env.ZERO);
		setTaxAmt(Env.ZERO);
	}
	
}
