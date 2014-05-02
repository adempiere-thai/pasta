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

/** Generated Model for MM_Package
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS - $Id$ */
public class X_MM_Package extends PO implements I_MM_Package, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20140124L;

    /** Standard Constructor */
    public X_MM_Package (Properties ctx, int MM_Package_ID, String trxName)
    {
      super (ctx, MM_Package_ID, trxName);
      /** if (MM_Package_ID == 0)
        {
			setC_Order_ID (0);
			setDocumentNo (null);
			setMM_Package_ID (0);
			setPackBy (0);
			setPackDate (new Timestamp( System.currentTimeMillis() ));
// @#Date@
			setPackStatus (null);
// PA
			setProcessed (false);
        } */
    }

    /** Load Constructor */
    public X_MM_Package (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_MM_Package[")
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

	/** Set Package to Customer.
		@param MM_Package_ID Package to Customer	  */
	public void setMM_Package_ID (int MM_Package_ID)
	{
		if (MM_Package_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_MM_Package_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_MM_Package_ID, Integer.valueOf(MM_Package_ID));
	}

	/** Get Package to Customer.
		@return Package to Customer	  */
	public int getMM_Package_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_MM_Package_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_User getPac() throws RuntimeException
    {
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_Name)
			.getPO(getPackBy(), get_TrxName());	}

	/** Set PackBy.
		@param PackBy PackBy	  */
	public void setPackBy (int PackBy)
	{
		set_Value (COLUMNNAME_PackBy, Integer.valueOf(PackBy));
	}

	/** Get PackBy.
		@return PackBy	  */
	public int getPackBy () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_PackBy);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set PackDate.
		@param PackDate PackDate	  */
	public void setPackDate (Timestamp PackDate)
	{
		set_Value (COLUMNNAME_PackDate, PackDate);
	}

	/** Get PackDate.
		@return PackDate	  */
	public Timestamp getPackDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_PackDate);
	}

	/** PackSize AD_Reference_ID=80008 */
	public static final int PACKSIZE_AD_Reference_ID=80008;
	/** 6 ขวด = 6 */
	public static final String PACKSIZE_6ขวด = "6";
	/** Set PackSize.
		@param PackSize PackSize	  */
	public void setPackSize (String PackSize)
	{

		set_Value (COLUMNNAME_PackSize, PackSize);
	}

	/** Get PackSize.
		@return PackSize	  */
	public String getPackSize () 
	{
		return (String)get_Value(COLUMNNAME_PackSize);
	}

	/** PackStatus AD_Reference_ID=80007 */
	public static final int PACKSTATUS_AD_Reference_ID=80007;
	/** Packed = PA */
	public static final String PACKSTATUS_Packed = "PA";
	/** Shipped = SH */
	public static final String PACKSTATUS_Shipped = "SH";
	/** Returned = RE */
	public static final String PACKSTATUS_Returned = "RE";
	/** Set PackStatus.
		@param PackStatus PackStatus	  */
	public void setPackStatus (String PackStatus)
	{

		set_Value (COLUMNNAME_PackStatus, PackStatus);
	}

	/** Get PackStatus.
		@return PackStatus	  */
	public String getPackStatus () 
	{
		return (String)get_Value(COLUMNNAME_PackStatus);
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