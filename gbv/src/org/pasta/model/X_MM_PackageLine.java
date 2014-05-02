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

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;

/** Generated Model for MM_PackageLine
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS - $Id$ */
public class X_MM_PackageLine extends PO implements I_MM_PackageLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20140124L;

    /** Standard Constructor */
    public X_MM_PackageLine (Properties ctx, int MM_PackageLine_ID, String trxName)
    {
      super (ctx, MM_PackageLine_ID, trxName);
      /** if (MM_PackageLine_ID == 0)
        {
			setC_OrderLine_ID (0);
			setM_PicklistLine_ID (0);
			setM_Product_ID (0);
			setMM_Package_ID (0);
			setMM_PackageLine_ID (0);
			setPackQty (Env.ZERO);
        } */
    }

    /** Load Constructor */
    public X_MM_PackageLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_MM_PackageLine[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_OrderLine getC_OrderLine() throws RuntimeException
    {
		return (org.compiere.model.I_C_OrderLine)MTable.get(getCtx(), org.compiere.model.I_C_OrderLine.Table_Name)
			.getPO(getC_OrderLine_ID(), get_TrxName());	}

	/** Set Sales Order Line.
		@param C_OrderLine_ID 
		Sales Order Line
	  */
	public void setC_OrderLine_ID (int C_OrderLine_ID)
	{
		if (C_OrderLine_ID < 1) 
			set_Value (COLUMNNAME_C_OrderLine_ID, null);
		else 
			set_Value (COLUMNNAME_C_OrderLine_ID, Integer.valueOf(C_OrderLine_ID));
	}

	/** Get Sales Order Line.
		@return Sales Order Line
	  */
	public int getC_OrderLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_OrderLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pasta.model.I_M_PicklistLine getM_PicklistLine() throws RuntimeException
    {
		return (org.pasta.model.I_M_PicklistLine)MTable.get(getCtx(), org.pasta.model.I_M_PicklistLine.Table_Name)
			.getPO(getM_PicklistLine_ID(), get_TrxName());	}

	/** Set Picklist Line.
		@param M_PicklistLine_ID Picklist Line	  */
	public void setM_PicklistLine_ID (int M_PicklistLine_ID)
	{
		if (M_PicklistLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_M_PicklistLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_PicklistLine_ID, Integer.valueOf(M_PicklistLine_ID));
	}

	/** Get Picklist Line.
		@return Picklist Line	  */
	public int getM_PicklistLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_PicklistLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getM_Product_ID(), get_TrxName());	}

	/** Set Product.
		@param M_Product_ID 
		Product, Service, Item
	  */
	public void setM_Product_ID (int M_Product_ID)
	{
		if (M_Product_ID < 1) 
			set_Value (COLUMNNAME_M_Product_ID, null);
		else 
			set_Value (COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
	}

	/** Get Product.
		@return Product, Service, Item
	  */
	public int getM_Product_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set PackageLine.
		@param MM_PackageLine_ID PackageLine	  */
	public void setMM_PackageLine_ID (int MM_PackageLine_ID)
	{
		if (MM_PackageLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_MM_PackageLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_MM_PackageLine_ID, Integer.valueOf(MM_PackageLine_ID));
	}

	/** Get PackageLine.
		@return PackageLine	  */
	public int getMM_PackageLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_MM_PackageLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set PackQty.
		@param PackQty PackQty	  */
	public void setPackQty (BigDecimal PackQty)
	{
		set_Value (COLUMNNAME_PackQty, PackQty);
	}

	/** Get PackQty.
		@return PackQty	  */
	public BigDecimal getPackQty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PackQty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
}