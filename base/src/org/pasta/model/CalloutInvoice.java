package org.pasta.model;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MDocType;
import org.compiere.util.DB;

public class CalloutInvoice extends CalloutEngine {
	public String docType(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value) {
		if (value == null)
			return "";

		int C_DocType_ID = (Integer) value;
		MDocType docType = null;
		if (C_DocType_ID > 0)
			docType = MDocType.get(ctx, C_DocType_ID);

		String docBaseType = String.valueOf(docType.getDocBaseType().charAt(2));
		if ("C".equals(docBaseType) || "D".equals(docBaseType))
			mTab.setValue("IsCreditDebit", true);
		else
			mTab.setValue("IsCreditDebit", false);

		return "";
	}

	public String refTaxInvoiceNo(Properties ctx, int WindowNo, GridTab mTab,
			GridField mField, Object value) {
		if (value == null) {
			return "";
		}

		String taxInvoiceNo = (String) value;
		boolean isSOTrx = mTab.getValueAsBoolean("IsSOTrx");
		int AD_Client_ID = (Integer)mTab.getValue("AD_Client_ID");
		int AD_Org_ID = (Integer)mTab.getValue("AD_Org_ID");

		String sql = "SELECT ivt.datetaxinvoice , iv.grandtotal , iv.C_Invoice_ID "
				+ "FROM c_invoice iv ,c_invoicetax ivt "
				+ "WHERE iv.c_invoice_id = ivt.c_invoice_id "
				+ "AND iv.ispaid = 'Y' "
				+ "AND iv.ad_client_id = ? AND iv.ad_org_id = ?  " 
				+ "AND ivt.taxinvoiceno = ? AND iv.issotrx = ? ";

		PreparedStatement ppstmt = DB.prepareStatement(sql, null);
		try {
			ppstmt.setInt(1, AD_Client_ID);
			ppstmt.setInt(2, AD_Org_ID);
			ppstmt.setString(3, taxInvoiceNo);
			ppstmt.setString(4, isSOTrx ? "Y" : "N");
			
			ResultSet rs = ppstmt.executeQuery();
			
			if(rs.next()){
				Timestamp dateTaxInvoice = rs.getTimestamp(1);
				BigDecimal grandTotal = rs.getBigDecimal(2);
				int C_Invoice_ID = rs.getInt(3);
				
				mTab.setValue("RefTaxInvoiceDate", dateTaxInvoice);
				mTab.setValue("RefTaxInvoiceAmt", grandTotal);
				mTab.setValue("Ref_Invoice_ID", C_Invoice_ID);
			}
			else{
				mTab.setValue("Ref_Invoice_ID", null);
			}
		} catch (Exception ex) {
			return ex.getMessage();
		}

		return "";
	}
}
