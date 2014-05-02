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
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for SD_DeliveryLine
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS - $Id$ */
public class X_SD_DeliveryLine extends PO implements I_SD_DeliveryLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20140501L;

    /** Standard Constructor */
    public X_SD_DeliveryLine (Properties ctx, int SD_DeliveryLine_ID, String trxName)
    {
      super (ctx, SD_DeliveryLine_ID, trxName);
      /** if (SD_DeliveryLine_ID == 0)
        {
			setSD_DeliveryLine_ID (0);
        } */
    }

    /** Load Constructor */
    public X_SD_DeliveryLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_SD_DeliveryLine[")
        .append(get_ID()).append("]");
      return sb.toString();
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

	public org.pasta.model.I_MM_Package getMM_Package() throws RuntimeException
    {
		return (org.pasta.model.I_MM_Package)MTable.get(getCtx(), org.pasta.model.I_MM_Package.Table_Name)
			.getPO(getMM_Package_ID(), get_TrxName());	}

	/** Set Package to Customer.
		@param MM_Package_ID Package to Customer	  */
	public void setMM_Package_ID (int MM_Package_ID)
	{
		if (MM_Package_ID < 1) 
			set_Value (COLUMNNAME_MM_Package_ID, null);
		else 
			set_Value (COLUMNNAME_MM_Package_ID, Integer.valueOf(MM_Package_ID));
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

	public org.pasta.model.I_SD_Delivery getSD_Delivery() throws RuntimeException
    {
		return (org.pasta.model.I_SD_Delivery)MTable.get(getCtx(), org.pasta.model.I_SD_Delivery.Table_Name)
			.getPO(getSD_Delivery_ID(), get_TrxName());	}

	/** Set Delivery Transaction.
		@param SD_Delivery_ID Delivery Transaction	  */
	public void setSD_Delivery_ID (int SD_Delivery_ID)
	{
		if (SD_Delivery_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_SD_Delivery_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_SD_Delivery_ID, Integer.valueOf(SD_Delivery_ID));
	}

	/** Get Delivery Transaction.
		@return Delivery Transaction	  */
	public int getSD_Delivery_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_SD_Delivery_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Delivery Line.
		@param SD_DeliveryLine_ID Delivery Line	  */
	public void setSD_DeliveryLine_ID (int SD_DeliveryLine_ID)
	{
		if (SD_DeliveryLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_SD_DeliveryLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_SD_DeliveryLine_ID, Integer.valueOf(SD_DeliveryLine_ID));
	}

	/** Get Delivery Line.
		@return Delivery Line	  */
	public int getSD_DeliveryLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_SD_DeliveryLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Status AD_Reference_ID=80005 */
	public static final int STATUS_AD_Reference_ID=80005;
	/** Shipped = S */
	public static final String STATUS_Shipped = "S";
	/** Returned = R */
	public static final String STATUS_Returned = "R";
	/** Set Status.
		@param Status 
		Status of the currently running check
	  */
	public void setStatus (String Status)
	{

		set_Value (COLUMNNAME_Status, Status);
	}

	/** Get Status.
		@return Status of the currently running check
	  */
	public String getStatus () 
	{
		return (String)get_Value(COLUMNNAME_Status);
	}
}