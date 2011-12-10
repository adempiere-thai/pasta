package org.pasta.model;

import java.math.BigDecimal;
import java.util.Properties;

import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.pasta.model.X_C_Payment;


public class CalloutPayment extends CalloutEngine {
	/*public String withholding (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value)
	{
		if(value == null){
			mTab.setValue(X_C_Payment.COLUMNNAME_WithholdingAmt, value);
			return "";
		}
		
		int C_WHTaxTrans_ID = 0 ;
		C_WHTaxTrans_ID = (Integer)value;
		if(C_WHTaxTrans_ID==0){
			mTab.setValue(X_C_Payment.COLUMNNAME_WithholdingAmt, value);
			return "";
		}
			
		String sql = "SELECT SUM(TaxAmt) FROM C_WHTaxTransLine WHERE C_WHTaxTrans_ID = ? ";
		BigDecimal taxAmt = DB.getSQLValueBD(null, sql, C_WHTaxTrans_ID);
		mTab.setValue(X_C_Payment.COLUMNNAME_WithholdingAmt, taxAmt);
		return "";
	}*/
}
