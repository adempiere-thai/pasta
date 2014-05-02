/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2007 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package org.pasta.model;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for M_Picklist
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS - $Id$ */
public class X_M_Picklist extends PO implements I_M_Picklist, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20140123L;

    /** Standard Constructor */
    public X_M_Picklist (Properties ctx, int M_Picklist_ID, String trxName)
    {
      super (ctx, M_Picklist_ID, trxName);
      /** if (M_Picklist_ID == 0)
        {
			setC_Order_ID (0);
			setDocumentNo (null);
			setM_Picklist_ID (0);
			setPickBy (0);
			setPickDate (new Timestamp( System.currentTimeMillis() ));
			setPrintBarcode (null);
// N
			setPrintIt (null);
// N
			setProcessed (false);
// N
        } */
    }

    /** Load Constructor */
    public X_M_Picklist (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuffer sb = new StringBuffer ("X_M_Picklist[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_Order getC_Order() throws RuntimeException
    {
		return (org.compiere.model.I_C_Order)MTable.get(getCtx(), org.compiere.model.I_C_Order.Table_Name)
			.getPO(getC_Order_ID(), get_TrxName());	}

	/** Set Order.
		@param C_Order_ID 
		Order
	  */
	public void setC_Order_ID (int C_Order_ID)
	{
		if (C_Order_ID < 1) 
			set_Value (COLUMNNAME_C_Order_ID, null);
		else 
			set_Value (COLUMNNAME_C_Order_ID, Integer.valueOf(C_Order_ID));
	}

	/** Get Order.
		@return Order
	  */
	public int getC_Order_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Order_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set Document No.
		@param DocumentNo 
		Document sequence number of the document
	  */
	public void setDocumentNo (String DocumentNo)
	{
		set_Value (COLUMNNAME_DocumentNo, DocumentNo);
	}

	/** Get Document No.
		@return Document sequence number of the document
	  */
	public String getDocumentNo () 
	{
		return (String)get_Value(COLUMNNAME_DocumentNo);
	}

	/** Set Picklist.
		@param M_Picklist_ID Picklist	  */
	public void setM_Picklist_ID (int M_Picklist_ID)
	{
		if (M_Picklist_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_M_Picklist_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_Picklist_ID, Integer.valueOf(M_Picklist_ID));
	}

	/** Get Picklist.
		@return Picklist	  */
	public int getM_Picklist_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Picklist_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_User getPic() throws RuntimeException
    {
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_Name)
			.getPO(getPickBy(), get_TrxName());	}

	/** Set PickBy.
		@param PickBy PickBy	  */
	public void setPickBy (int PickBy)
	{
		set_Value (COLUMNNAME_PickBy, Integer.valueOf(PickBy));
	}

	/** Get PickBy.
		@return PickBy	  */
	public int getPickBy () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_PickBy);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Pick Date.
		@param PickDate 
		Date/Time when picked for Shipment
	  */
	public void setPickDate (Timestamp PickDate)
	{
		set_Value (COLUMNNAME_PickDate, PickDate);
	}

	/** Get Pick Date.
		@return Date/Time when picked for Shipment
	  */
	public Timestamp getPickDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_PickDate);
	}

	/** Set Print Barcode.
		@param PrintBarcode Print Barcode	  */
	public void setPrintBarcode (String PrintBarcode)
	{
		set_Value (COLUMNNAME_PrintBarcode, PrintBarcode);
	}

	/** Get Print Barcode.
		@return Print Barcode	  */
	public String getPrintBarcode () 
	{
		return (String)get_Value(COLUMNNAME_PrintBarcode);
	}

	/** Set Print It.
		@param PrintIt Print It	  */
	public void setPrintIt (String PrintIt)
	{
		set_Value (COLUMNNAME_PrintIt, PrintIt);
	}

	/** Get Print It.
		@return Print It	  */
	public String getPrintIt () 
	{
		return (String)get_Value(COLUMNNAME_PrintIt);
	}

	/** Set Processed.
		@param Processed 
		The document has been processed
	  */
	public void setProcessed (boolean Processed)
	{
		set_Value (COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/** Get Processed.
		@return The document has been processed
	  */
	public boolean isProcessed () 
	{
		Object oo = get_Value(COLUMNNAME_Processed);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
}