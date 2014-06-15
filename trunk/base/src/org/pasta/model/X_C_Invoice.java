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

/** Generated Model for C_Invoice
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS - $Id$ */
public class X_C_Invoice extends org.compiere.model.X_C_Invoice implements org.pasta.model.I_C_Invoice
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20140531L;

    /** Standard Constructor */
    public X_C_Invoice (Properties ctx, int C_Invoice_ID, String trxName)
    {
      super (ctx, C_Invoice_ID, trxName);
      /** if (C_Invoice_ID == 0)
        {
			setIsCreditDebit (false);
// N
			setIsSent (false);
// N
        } */
    }

    /** Load Constructor */
    public X_C_Invoice (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

	/** Set Invoice Status Note.
		@param InvoiceStatusNote Invoice Status Note	  */
	public void setInvoiceStatusNote (String InvoiceStatusNote)
	{
		set_Value (COLUMNNAME_InvoiceStatusNote, InvoiceStatusNote);
	}

	/** Get Invoice Status Note.
		@return Invoice Status Note	  */
	public String getInvoiceStatusNote () 
	{
		return (String)get_Value(COLUMNNAME_InvoiceStatusNote);
	}

	/** Set Credit | Debit  Note?.
		@param IsCreditDebit Credit | Debit  Note?	  */
	public void setIsCreditDebit (boolean IsCreditDebit)
	{
		set_Value (COLUMNNAME_IsCreditDebit, Boolean.valueOf(IsCreditDebit));
	}

	/** Get Credit | Debit  Note?.
		@return Credit | Debit  Note?	  */
	public boolean isCreditDebit () 
	{
		Object oo = get_Value(COLUMNNAME_IsCreditDebit);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Generated.
		@param IsGenerated 
		This Line is generated
	  */
	public void setIsGenerated (boolean IsGenerated)
	{
		set_Value (COLUMNNAME_IsGenerated, Boolean.valueOf(IsGenerated));
	}

	/** Get Generated.
		@return This Line is generated
	  */
	public boolean isGenerated () 
	{
		Object oo = get_Value(COLUMNNAME_IsGenerated);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Is Sent.
		@param IsSent Is Sent	  */
	public void setIsSent (boolean IsSent)
	{
		set_Value (COLUMNNAME_IsSent, Boolean.valueOf(IsSent));
	}

	/** Get Is Sent.
		@return Is Sent	  */
	public boolean isSent () 
	{
		Object oo = get_Value(COLUMNNAME_IsSent);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Packing No.
		@param PackingNo Packing No	  */
	public void setPackingNo (String PackingNo)
	{
		set_Value (COLUMNNAME_PackingNo, PackingNo);
	}

	/** Get Packing No.
		@return Packing No	  */
	public String getPackingNo () 
	{
		return (String)get_Value(COLUMNNAME_PackingNo);
	}

	/** Set Reference Tax Invoice Amount.
		@param RefTaxInvoiceAmt 
		Credit/Debit Note Reference Tax Invoice Amount
	  */
	public void setRefTaxInvoiceAmt (BigDecimal RefTaxInvoiceAmt)
	{
		set_Value (COLUMNNAME_RefTaxInvoiceAmt, RefTaxInvoiceAmt);
	}

	/** Get Reference Tax Invoice Amount.
		@return Credit/Debit Note Reference Tax Invoice Amount
	  */
	public BigDecimal getRefTaxInvoiceAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_RefTaxInvoiceAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Reference Tax Invoice Date.
		@param RefTaxInvoiceDate 
		Credit/Debit Note Reference Tax Invoice Date
	  */
	public void setRefTaxInvoiceDate (Timestamp RefTaxInvoiceDate)
	{
		set_Value (COLUMNNAME_RefTaxInvoiceDate, RefTaxInvoiceDate);
	}

	/** Get Reference Tax Invoice Date.
		@return Credit/Debit Note Reference Tax Invoice Date
	  */
	public Timestamp getRefTaxInvoiceDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_RefTaxInvoiceDate);
	}

	/** Set Reference Tax Invoice No..
		@param RefTaxInvoiceNo 
		Credit/Debit Note Reference Tax Invoice No.
	  */
	public void setRefTaxInvoiceNo (String RefTaxInvoiceNo)
	{
		set_Value (COLUMNNAME_RefTaxInvoiceNo, RefTaxInvoiceNo);
	}

	/** Get Reference Tax Invoice No..
		@return Credit/Debit Note Reference Tax Invoice No.
	  */
	public String getRefTaxInvoiceNo () 
	{
		return (String)get_Value(COLUMNNAME_RefTaxInvoiceNo);
	}
}