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

/** Generated Model for C_InvoiceTax
 *  @author Adempiere (generated) 
 *  @version Release 3.6.0LTS - $Id$ */
public class X_C_InvoiceTax extends org.compiere.model.X_C_InvoiceTax implements org.pasta.model.I_C_InvoiceTax 
{

	private static final long serialVersionUID = 25540206L;

    /** Standard Constructor */
    public X_C_InvoiceTax (Properties ctx, int C_InvoiceTax_ID, String trxName)
    {
      super (ctx, C_InvoiceTax_ID, trxName);
      /** if (C_InvoiceTax_ID == 0)
        {
			setActualTaxAmt (Env.ZERO);
// 0
			setActualTaxBaseAmt (Env.ZERO);
// 0
			setC_Invoice_ID (0);
			setC_Tax_ID (0);
			setIsTaxIncluded (false);
			setProcessed (false);
			setTaxAmt (Env.ZERO);
			setTaxBaseAmt (Env.ZERO);
        } */
    }

    /** Load Constructor */
    public X_C_InvoiceTax (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 1 - Org 
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
      StringBuffer sb = new StringBuffer ("X_C_InvoiceTax[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Tax Address.
		@param ActualTaxAddress 
		Address For Tax Invoice
	  */
	public void setActualTaxAddress (String ActualTaxAddress)
	{
		set_Value (COLUMNNAME_ActualTaxAddress, ActualTaxAddress);
	}

	/** Get Tax Address.
		@return Address For Tax Invoice
	  */
	public String getActualTaxAddress () 
	{
		return (String)get_Value(COLUMNNAME_ActualTaxAddress);
	}

	/** Set Actual Tax Amount.
		@param ActualTaxAmt 
		Actual Tax Amount
	  */
	public void setActualTaxAmt (BigDecimal ActualTaxAmt)
	{
		set_Value (COLUMNNAME_ActualTaxAmt, ActualTaxAmt);
	}

	/** Get Actual Tax Amount.
		@return Actual Tax Amount
	  */
	public BigDecimal getActualTaxAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ActualTaxAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Tax Customer Name.
		@param ActualTaxBPartnerName 
		Tax Customer Name
	  */
	public void setActualTaxBPartnerName (String ActualTaxBPartnerName)
	{
		set_Value (COLUMNNAME_ActualTaxBPartnerName, ActualTaxBPartnerName);
	}

	/** Get Tax Customer Name.
		@return Tax Customer Name
	  */
	public String getActualTaxBPartnerName () 
	{
		return (String)get_Value(COLUMNNAME_ActualTaxBPartnerName);
	}

	/** Set Actual Tax Base Amount.
		@param ActualTaxBaseAmt Actual Tax Base Amount	  */
	public void setActualTaxBaseAmt (BigDecimal ActualTaxBaseAmt)
	{
		set_Value (COLUMNNAME_ActualTaxBaseAmt, ActualTaxBaseAmt);
	}

	/** Get Actual Tax Base Amount.
		@return Actual Tax Base Amount	  */
	public BigDecimal getActualTaxBaseAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ActualTaxBaseAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public I_C_Invoice getC_Invoice() throws RuntimeException
    {
		return (I_C_Invoice)MTable.get(getCtx(), I_C_Invoice.Table_Name)
			.getPO(getC_Invoice_ID(), get_TrxName());	}

	/** Set Tax Invoice No..
		@param TaxInvoiceNo Tax Invoice No.	  */
	public void setTaxInvoiceNo (String TaxInvoiceNo)
	{
		set_Value (COLUMNNAME_TaxInvoiceNo, TaxInvoiceNo);
	}

	/** Get Tax Invoice No..
		@return Tax Invoice No.	  */
	public String getTaxInvoiceNo () 
	{
		return (String)get_Value(COLUMNNAME_TaxInvoiceNo);
	}

	/** Get Date Tax Invoice.
	@return Date Tax Invoice	  */
	public Timestamp getDateTaxInvoice() {
		return (Timestamp)get_Value(COLUMNNAME_DateTaxInvoice);
	}

	/** Set Date Tax Invoice.
	@return Date Tax Invoice	  */
	public void setDateTaxInvoice(Timestamp DateTaxInvoice) {
		set_Value (COLUMNNAME_DateTaxInvoice, DateTaxInvoice);
	}
}