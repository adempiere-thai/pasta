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
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;

/** Generated Model for C_WHTaxTransLine
 *  @author Adempiere (generated) 
 *  @version Release 3.6.0LTS - $Id$ */
public class X_C_WHTaxTransLine extends PO implements I_C_WHTaxTransLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20110501L;

    /** Standard Constructor */
    public X_C_WHTaxTransLine (Properties ctx, int C_WHTaxTransLine_ID, String trxName)
    {
      super (ctx, C_WHTaxTransLine_ID, trxName);
      /** if (C_WHTaxTransLine_ID == 0)
        {
			setC_RevenueType_ID (0);
			setC_WHTaxTransLine_ID (0);
			setC_WHTaxTrans_ID (0);
			setTaxAmt (Env.ZERO);
// 0
			setTaxBaseAmt (Env.ZERO);
        } */
    }

    /** Load Constructor */
    public X_C_WHTaxTransLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_WHTaxTransLine[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.pasta.model.I_C_RevenueType getC_RevenueType() throws RuntimeException
    {
		return (org.pasta.model.I_C_RevenueType)MTable.get(getCtx(), org.pasta.model.I_C_RevenueType.Table_Name)
			.getPO(getC_RevenueType_ID(), get_TrxName());	}

	/** Set Revenue Type.
		@param C_RevenueType_ID Revenue Type	  */
	public void setC_RevenueType_ID (int C_RevenueType_ID)
	{
		if (C_RevenueType_ID < 1) 
			set_Value (COLUMNNAME_C_RevenueType_ID, null);
		else 
			set_Value (COLUMNNAME_C_RevenueType_ID, Integer.valueOf(C_RevenueType_ID));
	}

	/** Get Revenue Type.
		@return Revenue Type	  */
	public int getC_RevenueType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_RevenueType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Withholding Tax Transaction Line.
		@param C_WHTaxTransLine_ID Withholding Tax Transaction Line	  */
	public void setC_WHTaxTransLine_ID (int C_WHTaxTransLine_ID)
	{
		if (C_WHTaxTransLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_WHTaxTransLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_WHTaxTransLine_ID, Integer.valueOf(C_WHTaxTransLine_ID));
	}

	/** Get Withholding Tax Transaction Line.
		@return Withholding Tax Transaction Line	  */
	public int getC_WHTaxTransLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_WHTaxTransLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pasta.model.I_C_WHTaxTrans getC_WHTaxTrans() throws RuntimeException
    {
		return (org.pasta.model.I_C_WHTaxTrans)MTable.get(getCtx(), org.pasta.model.I_C_WHTaxTrans.Table_Name)
			.getPO(getC_WHTaxTrans_ID(), get_TrxName());	}

	/** Set Withholding Tax Transaction.
		@param C_WHTaxTrans_ID Withholding Tax Transaction	  */
	public void setC_WHTaxTrans_ID (int C_WHTaxTrans_ID)
	{
		if (C_WHTaxTrans_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_WHTaxTrans_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_WHTaxTrans_ID, Integer.valueOf(C_WHTaxTrans_ID));
	}

	/** Get Withholding Tax Transaction.
		@return Withholding Tax Transaction	  */
	public int getC_WHTaxTrans_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_WHTaxTrans_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_C_Withholding getC_Withholding() throws RuntimeException
    {
		return (I_C_Withholding)MTable.get(getCtx(), I_C_Withholding.Table_Name)
			.getPO(getC_Withholding_ID(), get_TrxName());	}

	/** Set Withholding.
		@param C_Withholding_ID 
		Withholding type defined
	  */
	public void setC_Withholding_ID (int C_Withholding_ID)
	{
		if (C_Withholding_ID < 1) 
			set_Value (COLUMNNAME_C_Withholding_ID, null);
		else 
			set_Value (COLUMNNAME_C_Withholding_ID, Integer.valueOf(C_Withholding_ID));
	}

	/** Get Withholding.
		@return Withholding type defined
	  */
	public int getC_Withholding_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Withholding_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Transaction Date.
		@param DateTrx 
		Transaction Date
	  */
	public void setDateTrx (Timestamp DateTrx)
	{
		set_Value (COLUMNNAME_DateTrx, DateTrx);
	}

	/** Get Transaction Date.
		@return Transaction Date
	  */
	public Timestamp getDateTrx () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateTrx);
	}

	/** Set Remark.
		@param Remarks Remark	  */
	public void setRemarks (String Remarks)
	{
		set_Value (COLUMNNAME_Remarks, Remarks);
	}

	/** Get Remark.
		@return Remark	  */
	public String getRemarks () 
	{
		return (String)get_Value(COLUMNNAME_Remarks);
	}

	/** Set Tax Amount.
		@param TaxAmt 
		Tax Amount for a document
	  */
	public void setTaxAmt (BigDecimal TaxAmt)
	{
		set_Value (COLUMNNAME_TaxAmt, TaxAmt);
	}

	/** Get Tax Amount.
		@return Tax Amount for a document
	  */
	public BigDecimal getTaxAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_TaxAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Tax base Amount.
		@param TaxBaseAmt 
		Base for calculating the tax amount
	  */
	public void setTaxBaseAmt (BigDecimal TaxBaseAmt)
	{
		set_Value (COLUMNNAME_TaxBaseAmt, TaxBaseAmt);
	}

	/** Get Tax base Amount.
		@return Base for calculating the tax amount
	  */
	public BigDecimal getTaxBaseAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_TaxBaseAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
}