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

/** Generated Interface for C_InvoiceTax
 *  @author Adempiere (generated) 
 *  @version Release 3.6.0LTS
 */
public interface I_C_InvoiceTax 
{
    /** Column name ActualTaxAddress */
    public static final String COLUMNNAME_ActualTaxAddress = "ActualTaxAddress";

	/** Set Tax Address.
	  * Address For Tax Invoice
	  */
	public void setActualTaxAddress (String ActualTaxAddress);

	/** Get Tax Address.
	  * Address For Tax Invoice
	  */
	public String getActualTaxAddress();

    /** Column name ActualTaxAmt */
    public static final String COLUMNNAME_ActualTaxAmt = "ActualTaxAmt";

	/** Set Actual Tax Amount.
	  * Actual Tax Amount
	  */
	public void setActualTaxAmt (BigDecimal ActualTaxAmt);

	/** Get Actual Tax Amount.
	  * Actual Tax Amount
	  */
	public BigDecimal getActualTaxAmt();

    /** Column name ActualTaxBPartnerName */
    public static final String COLUMNNAME_ActualTaxBPartnerName = "ActualTaxBPartnerName";

	/** Set Tax Customer Name.
	  * Tax Customer Name
	  */
	public void setActualTaxBPartnerName (String ActualTaxBPartnerName);

	/** Get Tax Customer Name.
	  * Tax Customer Name
	  */
	public String getActualTaxBPartnerName();

    /** Column name ActualTaxBaseAmt */
    public static final String COLUMNNAME_ActualTaxBaseAmt = "ActualTaxBaseAmt";

	/** Set Actual Tax Base Amount	  */
	public void setActualTaxBaseAmt (BigDecimal ActualTaxBaseAmt);

	/** Get Actual Tax Base Amount	  */
	public BigDecimal getActualTaxBaseAmt();

    /** Column name TaxInvoiceNo */
    public static final String COLUMNNAME_TaxInvoiceNo = "TaxInvoiceNo";

	/** Set Tax Invoice No.	  */
	public void setTaxInvoiceNo (String TaxInvoiceNo);

	/** Get Tax Invoice No.	  */
	public String getTaxInvoiceNo();
	
	/** Column name DateTaxInvoice */
    public static final String COLUMNNAME_DateTaxInvoice = "DateTaxInvoice";

	/** Set Account Date.
	  * Accounting Date
	  */
	public void setDateTaxInvoice (Timestamp DateTaxInvoice);

	/** Get Account Date.
	  * Accounting Date
	  */
	public Timestamp getDateTaxInvoice();
}
