package org.gbv.process;

import java.sql.ResultSet;
import java.math.BigDecimal;
import java.util.logging.Level;

import org.compiere.apps.AEnv;
import org.compiere.model.MBPartner;
import org.compiere.model.MInvoice;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MPeriod;
import org.compiere.model.MPriceList;
import org.compiere.model.MProduct;
import org.compiere.model.MTax;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.CPreparedStatement;
import org.compiere.util.DB;
import org.compiere.util.Env;

import org.apache.commons.lang.StringUtils;

public class SpecialInvoiceGenerate extends SvrProcess {
	
	private int				p_C_Period_ID ;
	private int				p_C_Tax_ID;
	private int 			p_C_BPartner_ID;
	private int				p_M_PriceList_ID;
	private String			p_DocStatus;

	protected void prepare() {
		// TODO Auto-generated method stub
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++)
		{
			String name = para[i].getParameterName();
			if (para[i].getParameter() == null)
					;
			else if (name.equals("C_Period_ID"))
				p_C_Period_ID = ((BigDecimal)para[i].getParameter()).intValue();
			else if (name.equals("C_Tax_ID"))
				p_C_Tax_ID = ((BigDecimal)para[i].getParameter()).intValue();
			else if (name.equals("C_BPartner_ID"))
				p_C_BPartner_ID = ((BigDecimal)para[i].getParameter()).intValue();
			else if (name.equals("M_PriceList_ID"))
				p_M_PriceList_ID = ((BigDecimal)para[i].getParameter()).intValue();
			else if (name.equals("DocStatus"))
				p_DocStatus = (String)para[i].getParameter();
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}
	}

	protected String doIt() throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer("SELECT pd.M_Product_ID , SUM(ivl.qtyentered) as qty ,array_to_string(array_agg( distinct ivh.C_Invoice_ID),',') as ids ");
		sql.append("FROM C_Invoice ivh ")
			.append("INNER JOIN C_InvoiceLine ivl ON ivh.C_Invoice_ID = ivl.C_Invoice_ID ")
			.append("INNER JOIN C_Tax t ON t.C_Tax_ID = ivl.C_Tax_ID ")
			.append("INNER JOIN C_DocType dt ON ivh.C_DocType_Id = dt.C_DocType_ID ")
			.append("INNER JOIN M_Product pd ON pd.M_Product_Id = ivl.M_Product_ID ")
			.append("WHERE dt.IsTaxInvoice = 'N' ")
			.append("AND ivh.AD_Org_Id = 1000005 ")
			.append("AND ivh.IsGenerated <= 'N' ")
			.append("AND t.rate = 0 ")
			.append("AND ivh.DateInvoiced >= ?  ")
			.append("ANd ivh.DateInvoiced <= ? ")
			.append("GROUP BY  pd.M_Product_ID ");
		
		MPeriod period = MPeriod.get(getCtx(), p_C_Period_ID);
		MTax tax = MTax.get(getCtx(), p_C_Tax_ID);
		MBPartner partner = MBPartner.get(getCtx(), p_C_BPartner_ID);
		MPriceList price = MPriceList.get(getCtx(), p_M_PriceList_ID, get_TrxName());
		
		MInvoice invoice = null;
		
		CPreparedStatement ppstmt = DB.prepareStatement(sql.toString(), get_TrxName());
		ppstmt.setTimestamp(1, period.getStartDate());
		ppstmt.setTimestamp(2, period.getEndDate());
		
		ResultSet rset = ppstmt.executeQuery();
		String invoiceList = "";
		
		while(rset.next()){
			if(invoice == null){
				invoice = createInvoiceHeader(partner,price,period);
			}
			
			MProduct product = MProduct.get(getCtx(), rset.getInt(1));
			
			MInvoiceLine line = new MInvoiceLine(invoice);
			line.setProduct(product);
			line.setC_Tax_ID(tax.getC_Tax_ID());
			line.setQty(rset.getBigDecimal(2));
			
			if(StringUtils.isEmpty(invoiceList))
				invoiceList = rset.getString("ids");
			else
				invoiceList = invoiceList +","+ rset.getString("ids");
			
			if(!line.save(get_TrxName())){
				return ERR_CANNOT_SAVE_INVOICELINE;
			}
		}
		
		if(invoice == null)
			return ERR_NO_INVOICE_WAS_GENERATED;
		
		if("CO".equals(p_DocStatus))
			invoice.completeIt();
		
		if(!invoice.save(get_TrxName()))
			return ERR_CANNOT_SAVE_INVOICE;
		
		// Update Invoice Was Was Generated
		String updateSql = "UPDATE C_Invoice SET IsGenerated = 'Y' WHERE C_Invoice_ID IN ("+invoiceList+")";
		DB.executeUpdate(updateSql, get_TrxName());
		//
		
		//AEnv.zoom(MInvoice.Table_ID, invoice.getC_Invoice_ID());
		return "Invoice No. "+invoice.getDocumentNo()+" was geranterd!";
	}
	
	private static final String ERR_NO_INVOICE_WAS_GENERATED = "NO_INVOICE_WAS_GENERATED";
	private static final String ERR_CANNOT_SAVE_INVOICELINE = "CANNOT_SAVE_INVOICE_LINE";
	private static final String ERR_CANNOT_SAVE_INVOICE = "CANNOT_SAVE_INVOICE";

	private MInvoice createInvoiceHeader(MBPartner partner, MPriceList price, MPeriod period) {
		MInvoice invoice = new MInvoice(getCtx(),0,get_TrxName());
		invoice.setBPartner(partner);
		invoice.setM_PriceList_ID(price.getM_PriceList_ID());
		invoice.setC_DocTypeTarget_ID(1000128);
		invoice.setC_DocType_ID(1000128);
		invoice.setAD_Org_ID(1000005);
		
		invoice.setDateInvoiced(period.getEndDate());
		invoice.setDateAcct(period.getEndDate());
		
		invoice.save(get_TrxName());
		return invoice;
	}
}
