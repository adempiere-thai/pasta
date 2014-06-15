/******************************************************************************
 * Copyright (C) 2009 Low Heng Sin                                            *
 * Copyright (C) 2009 Idalica Corporation                                     *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 *****************************************************************************/
package org.pasta.apps.form;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;

import org.apache.commons.lang.StringUtils;
import org.compiere.minigrid.IMiniTable;
import org.pasta.model.MInvoice;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;
import org.compiere.util.Msg;

/**
 * Create Charge from Accounts
 * 
 * @author Jorg Janke
 * @version $Id: Charge.java,v 1.3 2006/07/30 00:51:28 jjanke Exp $
 */
public class InvoiceReturn {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2478440763968206819L;

	/** Window No */
	public int m_WindowNo = 0;
	// /** FormFrame */
	// private FormFrame m_frame;

	/** Account Element */
	public int m_C_Element_ID = 0;
	/** AccountSchema */
	private int m_C_AcctSchema_ID = 0;
	
	
	/** Logger */
	public static CLogger log = CLogger.getCLogger(InvoiceReturn.class);

	/**
	 * Finds the Element Identifier for the current charge.
	 * 
	 */
	public void findChargeElementID() {
		m_C_AcctSchema_ID = Env.getContextAsInt(Env.getCtx(),
				"$C_AcctSchema_ID");
		// get Element
		String sql = "SELECT C_Element_ID " + "FROM C_AcctSchema_Element "
				+ "WHERE ElementType='AC' AND C_AcctSchema_ID=?";

		try {
			PreparedStatement pstmt = DB.prepareStatement(sql, null);
			pstmt.setInt(1, m_C_AcctSchema_ID);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				m_C_Element_ID = rs.getInt(1);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException exception) {
			log.log(Level.SEVERE, sql, exception);
		}
	}

	public Vector<String> getColumnNames() {
		// Header Info
		Vector<String> columnNames = new Vector<String>(7);
		columnNames.add(Msg.getMsg(Env.getCtx(), "Selected"));
		columnNames.add(Msg.translate(Env.getCtx(), "Invoice No"));
		columnNames.add(Msg.translate(Env.getCtx(), "Customer Name"));
		columnNames.add(Msg.getMsg(Env.getCtx(), "Invoice Date"));
		columnNames.add(Msg.getMsg(Env.getCtx(), "Grand Total"));
		columnNames.add(Msg.getMsg(Env.getCtx(), "Invoice Status"));
		columnNames.add(Msg.getMsg(Env.getCtx(), "Sent"));
		return columnNames;
	}

	public void setColumnClass(IMiniTable dataTable) {
		dataTable.setColumnClass(0, Boolean.class, false); // 0-Sent
		dataTable.setColumnClass(1, String.class, true); // 1-Invoice No
		dataTable.setColumnClass(2, String.class, true); // 2-Customer Name
		dataTable.setColumnClass(3, Date.class, true); // 3-Invoice Date
		dataTable.setColumnClass(4, BigDecimal.class, true); // 4-Grand Total
		dataTable.setColumnClass(5, String.class, false); // 5-Invoice Status
		dataTable.setColumnClass(6, Boolean.class, false);
		// Table UI
		dataTable.autoSize();
	}

	Properties ctx = null;
	
	Map ids = new HashMap<String,Integer>();

	public Map getIds() {
		return ids;
	}

	public void setIds(Map ids) {
		this.ids = ids;
	}

	public Vector<Vector<Object>> getData(int orgId, String invoiceFrom,
			String invoiceTo, java.util.Date invoiceDateFrom,
			java.util.Date invoiceDateTo, int invoiceDocType, int customerId,
			String invoiceSent) 
	{
		Vector<Vector<Object>> dataL = new Vector<Vector<Object>>();

		List<Object> params = new ArrayList<Object>();
		
		StringBuffer sql = new StringBuffer("SELECT iv.IsSent , iv.DocumentNo , bp.Name as CustomerName , iv.DateInvoiced , iv.GrandTotal , iv.InvoiceStatusNote , iv.C_Invoice_ID\n");
		sql.append("FROM C_Invoice iv INNER JOIN C_BPartner bp ON iv.C_BPartner_ID = bp.C_BPartner_ID ")
		   .append("WHERE iv.IsSOTrx = 'Y' AND iv.DocStatus ='CO' AND iv.AD_Client_ID = ? AND iv.AD_Org_Id = ? \n");
		   
		params.add(Env.getAD_Client_ID(getCtx()));
		params.add(orgId);
		
		if(!StringUtils.isEmpty(invoiceFrom)){
			sql.append("AND iv.DocumentNo >= ? ");
			params.add(invoiceFrom);
		}
		
		if(!StringUtils.isEmpty(invoiceTo)){
			sql.append("AND iv.DocumentNo <= ? ");
			params.add(invoiceTo);
		}
		
		if(invoiceDateFrom!=null){
			sql.append("AND iv.DateInvoiced >= ? ");
			java.sql.Date dateFrom = new java.sql.Date(invoiceDateFrom.getTime());
			params.add(dateFrom);
		}
		
		if(invoiceDateTo!=null){
			sql.append("AND iv.DateInvoiced <= ? ");
			java.sql.Date dateTo = new java.sql.Date(invoiceDateTo.getTime());
			params.add(dateTo);
		}
		
		if(invoiceDocType > 0){
			sql.append("AND iv.C_DocType_ID = ? ");
			params.add(invoiceDocType);
		}
		
		if(customerId > 0){
			sql.append("AND iv.C_BPartner_ID = ? ");
			params.add(customerId);
		}
		
		if(!StringUtils.isEmpty(invoiceSent)){
			sql.append("AND COALESCE(iv.IsSent,'N') = ? ");
			params.add(invoiceSent);
		}
		
		sql.append("ORDER BY iv.DocumentNo Desc , iv.DateInvoiced ");
		
		PreparedStatement pstmt = DB.prepareStatement(sql.toString(), null);
		try {
			int prmIdx = 1;
			for(Object param : params){
				pstmt.setObject(prmIdx++, param);
			}
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				ids.put(rs.getString("DocumentNo"), rs.getInt("C_Invoice_ID"));
				
				Vector<Object> line = new Vector<Object>(7);
				line.add(new Boolean(false));
				
				KeyNamePair pp = new KeyNamePair(rs.getInt("C_Invoice_ID"), rs.getString("DocumentNo"));
				line.add(pp);
				line.add(rs.getString("CustomerName"));
				line.add(rs.getTimestamp("DateInvoiced"));
				line.add(rs.getBigDecimal("GrandTotal"));
				line.add(StringUtils.defaultIfEmpty(rs.getString("InvoiceStatusNote"), ""));
				line.add(new Boolean("Y".equals(rs.getString("IsSent"))));
				
				dataL.add(line);
			}
			rs.close();
			pstmt.close();
		}
		catch(Exception ex){
			log.log(Level.SEVERE, sql.toString(), ex);
		}

		return dataL;
	}

	public Properties getCtx() {
		if(ctx == null)
			ctx = Env.getCtx();
		return ctx;
	}

	public ArrayList<KeyNamePair> getDocTypeData(int AD_Org_ID) {
		// TODO Auto-generated method stub
		ArrayList<KeyNamePair> list = new ArrayList<KeyNamePair>();
		String sql = "SELECT C_DocType_ID , Name as DocTypeName FROM C_DocType WHERE DocBaseType = 'ARI' AND AD_Client_ID = ? AND AD_Org_ID = ? AND AD_ORG_ID <> 0";
		try {
			KeyNamePair dt = new KeyNamePair(0, "");
			list.add(dt);
			PreparedStatement pstmt = DB.prepareStatement(sql, null);
			pstmt.setInt(1, Env.getAD_Client_ID(Env.getCtx())); // Client
			pstmt.setInt(2, AD_Org_ID);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				dt = new KeyNamePair(rs.getInt(1), rs.getString(2));
				list.add(dt);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException ex) {
			log.log(Level.SEVERE, sql, ex);
		}

		return list;
	}
	
	public boolean updateInvoice(int C_Invoice_ID, String invoiceStatus, boolean isSent){
		MInvoice invoice = new MInvoice(getCtx(),C_Invoice_ID,null);
		invoice.setInvoiceStatusNote(invoiceStatus);
		invoice.setIsSent(isSent);
		
		return invoice.save();
	}
}
