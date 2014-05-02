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

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.minigrid.IMiniTable;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCharge;
import org.compiere.model.MElementValue;
import org.compiere.model.MShipper;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;
import org.compiere.util.Msg;
import org.pasta.model.MMMPackage;
import org.pasta.model.MSDDelivery;

/**
 *  Create Charge from Accounts
 *
 *  @author Jorg Janke
 *  @version $Id: Charge.java,v 1.3 2006/07/30 00:51:28 jjanke Exp $
 */
public class Delivery
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2478440763968206819L;

	/**	Window No			*/
	public int         m_WindowNo = 0;
//	/**	FormFrame			*/
//	private FormFrame 	m_frame;

	/** Account Element     */
	public int         m_C_Element_ID = 0;
	/** AccountSchema       */
	private int         m_C_AcctSchema_ID = 0;
	/** Default Charge Tax Category */
	private int         m_C_TaxCategory_ID = 0;
	private int         m_AD_Client_ID = 0;
	private int         m_AD_Org_ID = 0;
	private int         m_CreatedBy = 0;
	private MAcctSchema  m_acctSchema = null;
	/**	Logger			*/
	public static CLogger log = CLogger.getCLogger(Delivery.class);
	
	/**
     * Finds the Element Identifier for the current charge.
     *
     */
    public void findChargeElementID()
    {
    	m_C_AcctSchema_ID = Env.getContextAsInt(Env.getCtx(), "$C_AcctSchema_ID");
        //  get Element
        String sql = "SELECT C_Element_ID "
            + "FROM C_AcctSchema_Element "
            + "WHERE ElementType='AC' AND C_AcctSchema_ID=?";

        try
        {
            PreparedStatement pstmt = DB.prepareStatement(sql, null);
            pstmt.setInt(1, m_C_AcctSchema_ID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
            {
            	m_C_Element_ID = rs.getInt(1);
            }
            rs.close();
            pstmt.close();
        }
        catch (SQLException exception)
        {
            log.log(Level.SEVERE, sql, exception);
        }
    }
	
	public Vector<String> getColumnNames()
	{
		//  Header Info
		Vector<String> columnNames = new Vector<String>(4);
		columnNames.add(Msg.getMsg(Env.getCtx(), "Select"));
		columnNames.add(Msg.translate(Env.getCtx(), "Package No."));
		columnNames.add(Msg.translate(Env.getCtx(), "Customer Name"));
		columnNames.add(Msg.getMsg(Env.getCtx(), "Sales Order No."));
		
		return columnNames;
	}
	
	public void setColumnClass(IMiniTable dataTable)
	{
		dataTable.setColumnClass(0, Boolean.class, false);      //  0-Selection
		dataTable.setColumnClass(1, String.class, true);        //  1-Package No.
		dataTable.setColumnClass(2, String.class, true);        //  2-Customer Name
		dataTable.setColumnClass(3, String.class, true);       //  3-Sales Order No.
		//  Table UI
		dataTable.autoSize();
	}
    
    public boolean addDeliveryPackage(Properties ctx,String packageNo,String trxName){
    	MMMPackage pack = MMMPackage.findPackageByNo(ctx,packageNo,trxName);
    	
    	if(pack == null || pack.isShipped())
    		return false;
    	
    	addData(pack);
    	
    	return true;
    }
    
    public void removeDeliveryPackage(List<String> removeList) {
		// TODO Auto-generated method stub
		Iterator rows = dataL.iterator();
	    int idx = 0;
	    
	    Vector<Vector<Object>> newList = new Vector<Vector<Object>>();
	    
	    while(rows.hasNext())
	    {
	    	Vector<Object> columns = (Vector<Object>)rows.next();
	    	KeyNamePair pp = (KeyNamePair)columns.get(1);
	    	if(!removeList.contains(pp.getName()))
	    		newList.add(columns);
	    }
	    dataL = null;
	    dataL = newList;
	}
    
    Properties ctx =null;
    
    public List<MShipper> getShippers(Properties ctx){
    	this.ctx = ctx;
    	return new Query(ctx, MShipper.Table_Name,"", this.toString()).list();
    }
    
    Vector<Vector<Object>> dataL = new Vector<Vector<Object>>();
    
    private void addData(MMMPackage pack){
    	DeliveryData data = convertToData(pack);
    	
    	if(data != null){
    		Vector<Object> line = new Vector<Object>(4);
			line.add(new Boolean(false));       //  0-Selection
			KeyNamePair pp = new KeyNamePair(data.getPackageId(), data.getPackageNo());
			line.add(pp);                       //  1-Value
			line.add(data.getCustomerName());          //  2-Name
			line.add(data.getSalesOrderNo());   //  3-Expense
			dataL.add(line);
    	}
    }
    
    public Vector<Vector<Object>> getData(){
    	return dataL;
    }
    
    
    private DeliveryData convertToData(MMMPackage pack){
    	DeliveryData result = null;
    	boolean isNewRecord = true;
    	
    	Iterator rows = dataL.iterator();
    	
    	while(rows.hasNext()){
    		Vector<Object> columns = (Vector<Object>)rows.next();
    		KeyNamePair pp = (KeyNamePair)columns.get(1);
    		if(pack.getMM_Package_ID() == pp.getKey()){
    			isNewRecord = false;
    			break;
    		}
    	}
    	
    	if(isNewRecord){
    		result = new DeliveryData();
    		result.setSelected(false);
    		result.setPackageNo(pack.getDocumentNo());
    		result.setCustomerName(pack.getC_Order().getC_BPartner().getName());
    		result.setSalesOrderNo(pack.getC_Order().getDocumentNo());
    		result.setPackageId(pack.getMM_Package_ID());
    	}
    	return result;
    }
    
    public Properties getCtx() {
		return ctx;
	}

	public boolean createDeliveryTrx(int shipperId){
    	//MShipper shipper = new MShipper(getCtx(),shipperId,this.toString());
    	
    	List<Integer> packageIds = new ArrayList<Integer>();
    	Iterator rows = dataL.iterator();
    	
    	while(rows.hasNext()){
    		Vector<Object> columns = (Vector<Object>)rows.next();
    		KeyNamePair pp = (KeyNamePair)columns.get(1);
    		packageIds.add(pp.getKey());
    	}
    	
    	delivery = new MSDDelivery(Env.getCtx(),0,null);
    	delivery.setM_Shipper_ID(shipperId);
    	
    	if(!delivery.save())
			throw new AdempiereException("CannotSaveDeliveryHeader");
		
		log.fine("Delivery Trx No.("+delivery.getDocumentNo()+") was created.");
    	
    	delivery.generateLines(packageIds);
    	
    	return true;
    }
	
	MSDDelivery delivery = null;
	
	public String getDeliveryNo(){
		return delivery.getDocumentNo();
	}
	
	public int getDeliveryTotalLines(){
		return delivery.getLines().size();
	}
	
	public void clearData(){
		dataL = null;
		dataL = new Vector<Vector<Object>>();
	}
}  
