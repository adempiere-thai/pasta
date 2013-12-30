package org.pasta.process;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.math.BigDecimal;

import org.adempiere.exceptions.AdempiereException;
import org.apache.commons.lang.StringUtils;
import org.compiere.model.MInOut;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInvoice;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.MSysConfig;
import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;

public class ShipmentInvoiceGenerate extends SvrProcess {

	private String			p_DocumentNo ;
	private int				p_AD_Org_ID ;
	private Timestamp		p_MovementDate;
	private Timestamp		p_InvoicedDate;
	
	protected void prepare() {
		// TODO Auto-generated method stub
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++)
		{
			String name = para[i].getParameterName();
			if (para[i].getParameter() == null)
				;
			else if (name.equals("AD_Org_ID"))
				p_AD_Org_ID = ((BigDecimal)para[i].getParameter()).intValue();
			else if (name.equals("DocumentNo"))
				p_DocumentNo = (String)para[i].getParameter();
			else if (name.equals("MovementDate"))
				p_MovementDate = (Timestamp)para[i].getParameter();
			else if (name.equals("DateInvoiced"))
				p_InvoicedDate = (Timestamp)para[i].getParameter();
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}
	}
	
	private static final String ERR_CANNOT_FOUND_SO = "CANNOT_FOUND_SALES_ORDER";
	private static final String ERR_SO_WAS_GENERATED = "SALES_ORDER_WAS_GENERATED";
	private static final String ERR_SO_NOT_COMPLETED = "SALES_ORDER_NOT_COMPLETED";
	private static final String ERR_CANNOT_SAVE_SHIPMENT = "CANNOT_SAVE_SHIPMENT";
	private static final String ERR_CANNOT_SAVE_SHIPMENT_LINE = "CANNOT_SAVE_SHIPMENT_LINE";
	private static final String ERR_CANNOT_SAVE_INVOICE = "CANNOT_SAVE_INVOICE";
	private static final String ERR_CANNOT_SAVE_INVOICE_LINE = "CANNOT_SAVE_INVOICE_LINE";
	private static final String ERR_CONNOT_COMPLETE_SHIPMENT = "CANNOT_COMPLETE_SHIPMENT";
	private static final String ERR_CONNOT_COMPLETE_INVOICE = "CANNOT_COMPLETE_INVOICE";

	protected String doIt() throws Exception {
		// TODO Auto-generated method stub
		
		String sql = "select * from c_order where ad_org_id = ? and documentno = ?";
		
		PreparedStatement pstmt = null;
		try
		{
			pstmt = DB.prepareStatement (sql, get_TrxName());
			int index = 1;
			
			if (p_AD_Org_ID != 0)
				pstmt.setInt(index++, p_AD_Org_ID);
			if (!StringUtils.isEmpty(p_DocumentNo))
				pstmt.setString(index++, p_DocumentNo);
		}
		catch (Exception e)
		{
			log.log(Level.SEVERE, sql, e);
		}
		return generate(pstmt);
	}

	private String generate(PreparedStatement pstmt) {
		String retValue = "No Document Was Generated";
		try
		{
			ResultSet rs = pstmt.executeQuery ();
			int i = 0;
			if (rs.next ())
			{
				i++;
				MOrder order = new MOrder(getCtx(),rs,get_TrxName());
				validateSalesOrder(order);
				MInOut shipment = generateShipment(order);
				retValue = generateInvoice(order,shipment);
			}
			if(i == 0){
				throw new AdempiereException(ERR_CANNOT_FOUND_SO);
			}
		}
		catch (Exception e)
		{
			log.log(Level.SEVERE, "", e);
		}
		try
		{
			if (pstmt != null)
				pstmt.close ();
			pstmt = null;
		}
		catch (Exception e)
		{
			pstmt = null;
		}
		// TODO Auto-generated method stub
		return retValue;
	}

	private void validateSalesOrder(MOrder order) throws Exception {
		if(!MOrder.DOCSTATUS_Completed.equals(order.getDocStatus()))
			throw new AdempiereException(ERR_SO_NOT_COMPLETED);
		
		MInOut[] inouts = order.getShipments();
		for(MInOut inout : inouts){
			if(inout.isComplete() || MInOut.DOCSTATUS_Drafted.equals(inout.getDocStatus())){
				throw new AdempiereException(ERR_SO_WAS_GENERATED);
			}
		}
	}
	
	// SYSTEM CONFIG DOCUMENT TYPE ID OF AR INVOICE FOR GBV AND MNP
	private static final String SYSTEM_CONFIG_GBV_AR_INVOICE_ID = "GBV_AR_INVOICE_ID";
	private static final String SYSTEM_CONFIG_MNP_AR_INVOICE_ID = "MNP_AR_INVOICE_ID";

	private String generateInvoice(MOrder order, MInOut shipment) throws Exception {
		// TODO Auto-generated method stub
		MInvoice invoice = new MInvoice(shipment,p_InvoicedDate);
		
		// Set Invoice Document Type To AR Invoice
		int C_DocType_ID = invoice.getC_DocTypeTarget_ID();
		if(p_AD_Org_ID == 1000005)
			C_DocType_ID = MSysConfig.getIntValue(SYSTEM_CONFIG_GBV_AR_INVOICE_ID, C_DocType_ID);
		else if(p_AD_Org_ID == 1000006)
			C_DocType_ID = MSysConfig.getIntValue(SYSTEM_CONFIG_MNP_AR_INVOICE_ID, C_DocType_ID);
		
		invoice.setC_DocTypeTarget_ID(C_DocType_ID);
		if(!invoice.save(get_TrxName()))
			throw new AdempiereException(ERR_CANNOT_SAVE_INVOICE);
		
		MInOutLine[] ioLines = shipment.getLines();
		for(MInOutLine ioLine : ioLines){
			MInvoiceLine iline = new MInvoiceLine(invoice);
			iline.setShipLine(ioLine);
			iline.setQty(ioLine.getQtyEntered());
			if(!iline.save(get_TrxName()))
				throw new AdempiereException(ERR_CANNOT_SAVE_INVOICE_LINE);
		}
		;
		
		if (invoice != null)
		{
			if (!invoice.processIt(DocAction.ACTION_Complete))
			{
				log.warning("completeInvoice - failed: " + invoice);
				addLog("completeInvoice - failed: " + invoice);
				throw new AdempiereException(ERR_CONNOT_COMPLETE_INVOICE);
			}
			invoice.saveEx();

			addLog(invoice.getC_Invoice_ID(), invoice.getDateInvoiced(), null, invoice.getDocumentNo());
		}
		
		return invoice.getDocumentInfo();
	}

	private MInOut generateShipment(MOrder order) throws Exception {
		MInOut shipment = new MInOut(order,0,p_MovementDate);
		if(!shipment.save(get_TrxName()))
			throw new AdempiereException(ERR_CANNOT_SAVE_SHIPMENT);
			
		for(MOrderLine oline:order.getLines()){
			MInOutLine sline = new MInOutLine(shipment);
			sline.setOrderLine(oline, 0, oline.getQtyOrdered().subtract(oline.getQtyDelivered()));
			sline.setQty(oline.getQtyOrdered().subtract(oline.getQtyDelivered()));
			if(!sline.save(get_TrxName()))
				throw new AdempiereException(ERR_CANNOT_SAVE_SHIPMENT_LINE);
		}
		
		if (shipment != null)
		{
			if (!shipment.processIt(DocAction.ACTION_Complete))
			{
				log.warning("completeShipment - failed: " + shipment);
				addLog("completeShipment - failed: " + shipment);
				throw new AdempiereException(ERR_CONNOT_COMPLETE_SHIPMENT);
			}
			shipment.saveEx();

			addLog(shipment.getM_InOut_ID(), shipment.getMovementDate(), null, shipment.getDocumentNo());
		}
		
		
		return shipment;
	}

}
