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
package org.pasta.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for C_Invoice
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS
 */
public interface I_C_Invoice extends org.compiere.model.I_C_Invoice 
{


    /** Column name InvoiceStatusNote */
    public static final String COLUMNNAME_InvoiceStatusNote = "InvoiceStatusNote";

	/** Set Invoice Status Note	  */
	public void setInvoiceStatusNote (String InvoiceStatusNote);

	/** Get Invoice Status Note	  */
	public String getInvoiceStatusNote();

    /** Column name IsCreditDebit */
    public static final String COLUMNNAME_IsCreditDebit = "IsCreditDebit";

	/** Set Credit | Debit  Note?	  */
	public void setIsCreditDebit (boolean IsCreditDebit);

	/** Get Credit | Debit  Note?	  */
	public boolean isCreditDebit();

    /** Column name IsGenerated */
    public static final String COLUMNNAME_IsGenerated = "IsGenerated";

	/** Set Generated.
	  * This Line is generated
	  */
	public void setIsGenerated (boolean IsGenerated);

	/** Get Generated.
	  * This Line is generated
	  */
	public boolean isGenerated();

    /** Column name IsSent */
    public static final String COLUMNNAME_IsSent = "IsSent";

	/** Set Is Sent	  */
	public void setIsSent (boolean IsSent);

	/** Get Is Sent	  */
	public boolean isSent();

    /** Column name PackingNo */
    public static final String COLUMNNAME_PackingNo = "PackingNo";

	/** Set Packing No	  */
	public void setPackingNo (String PackingNo);

	/** Get Packing No	  */
	public String getPackingNo();

    /** Column name RefTaxInvoiceAmt */
    public static final String COLUMNNAME_RefTaxInvoiceAmt = "RefTaxInvoiceAmt";

	/** Set Reference Tax Invoice Amount.
	  * Credit/Debit Note Reference Tax Invoice Amount
	  */
	public void setRefTaxInvoiceAmt (BigDecimal RefTaxInvoiceAmt);

	/** Get Reference Tax Invoice Amount.
	  * Credit/Debit Note Reference Tax Invoice Amount
	  */
	public BigDecimal getRefTaxInvoiceAmt();

    /** Column name RefTaxInvoiceDate */
    public static final String COLUMNNAME_RefTaxInvoiceDate = "RefTaxInvoiceDate";

	/** Set Reference Tax Invoice Date.
	  * Credit/Debit Note Reference Tax Invoice Date
	  */
	public void setRefTaxInvoiceDate (Timestamp RefTaxInvoiceDate);

	/** Get Reference Tax Invoice Date.
	  * Credit/Debit Note Reference Tax Invoice Date
	  */
	public Timestamp getRefTaxInvoiceDate();

    /** Column name RefTaxInvoiceNo */
    public static final String COLUMNNAME_RefTaxInvoiceNo = "RefTaxInvoiceNo";

	/** Set Reference Tax Invoice No..
	  * Credit/Debit Note Reference Tax Invoice No.
	  */
	public void setRefTaxInvoiceNo (String RefTaxInvoiceNo);

	/** Get Reference Tax Invoice No..
	  * Credit/Debit Note Reference Tax Invoice No.
	  */
	public String getRefTaxInvoiceNo();
}
