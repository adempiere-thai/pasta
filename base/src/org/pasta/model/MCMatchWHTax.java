package org.pasta.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class MCMatchWHTax extends X_C_MatchWHTax {

	public MCMatchWHTax(Properties ctx, int C_MatchWHTax_ID, String trxName) {
		super(ctx, C_MatchWHTax_ID, trxName);
	}

	public MCMatchWHTax(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	protected boolean afterDelete(boolean success) {
		if(!setPaymentWithholdingTaxAmt(-1))
			return false;
		return true;
	}

	protected boolean afterSave(boolean newRecord, boolean success) {
		if(!setPaymentWithholdingTaxAmt(1))
			return false;
		return true;
	}
	
	public X_C_Payment getPayment() throws RuntimeException {
		X_C_Payment payment = new X_C_Payment(getCtx(),getC_Payment_ID(),get_TrxName());
		return payment;
	}

	private boolean setPaymentWithholdingTaxAmt(int multiplier) {
		X_C_Payment payment = getPayment();
		BigDecimal totalWithholdingTaxAmt = getTotalPaymentWithholdingTaxAmt();
		payment.setWithholdingAmt(totalWithholdingTaxAmt);
		
		if(!payment.save(get_TrxName())){
			throw new AdempiereException("CannotUpdatePaymentWithholdingTaxAmt");
		}
		
		return true;
	}
	
	private BigDecimal getTotalPaymentWithholdingTaxAmt(){
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT SUM(wht.TaxAmt) FROM "+Table_Name+" mwt ")
			.append(" INNER JOIN "+X_C_WHTaxTransLine.Table_Name+" wht") 
			.append(" ON mwt."+COLUMNNAME_C_WHTaxTrans_ID+" = wht."+COLUMNNAME_C_WHTaxTrans_ID)
			.append(" WHERE mwt."+COLUMNNAME_C_Payment_ID+" = ? ");
		
		BigDecimal totalAmt = DB.getSQLValueBD(get_TrxName(), sql.toString(), getC_Payment_ID());
		if(totalAmt == null)
			return Env.ZERO;
		
		return totalAmt;
	}
}
