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
import org.compiere.util.KeyNamePair;

/** Generated Model for C_WHTaxTrans
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS - $Id$ */
public class X_C_WHTaxTrans extends PO implements I_C_WHTaxTrans, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20120729L;

    /** Standard Constructor */
    public X_C_WHTaxTrans (Properties ctx, int C_WHTaxTrans_ID, String trxName)
    {
      super (ctx, C_WHTaxTrans_ID, trxName);
      /** if (C_WHTaxTrans_ID == 0)
        {
			setC_BPartner_ID (0);
			setC_BPartner_Location_ID (0);
			setC_WHTaxTrans_ID (0);
			setDateDoc (new Timestamp( System.currentTimeMillis() ));
// @#Date@
			setIsPrinted (null);
// N
			setPNDType (null);
			setWHTaxType (null);
// 1
			setWithholdingAction (null);
// PR
        } */
    }

    /** Load Constructor */
    public X_C_WHTaxTrans (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_WHTaxTrans[")
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

	public org.compiere.model.I_AD_Table getAD_Table() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Table)MTable.get(getCtx(), org.compiere.model.I_AD_Table.Table_Name)
			.getPO(getAD_Table_ID(), get_TrxName());	}

	/** Set Table.
		@param AD_Table_ID 
		Database Table information
	  */
	public void setAD_Table_ID (int AD_Table_ID)
	{
		if (AD_Table_ID < 1) 
			set_Value (COLUMNNAME_AD_Table_ID, null);
		else 
			set_Value (COLUMNNAME_AD_Table_ID, Integer.valueOf(AD_Table_ID));
	}

	/** Get Table.
		@return Database Table information
	  */
	public int getAD_Table_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Table_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getC_BPartner_ID(), get_TrxName());	}

	/** Set Business Partner .
		@param C_BPartner_ID 
		Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1) 
			set_Value (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_Value (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner .
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_BPartner_Location getC_BPartner_Location() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner_Location)MTable.get(getCtx(), org.compiere.model.I_C_BPartner_Location.Table_Name)
			.getPO(getC_BPartner_Location_ID(), get_TrxName());	}

	/** Set Partner Location.
		@param C_BPartner_Location_ID 
		Identifies the (ship to) address for this Business Partner
	  */
	public void setC_BPartner_Location_ID (int C_BPartner_Location_ID)
	{
		if (C_BPartner_Location_ID < 1) 
			set_Value (COLUMNNAME_C_BPartner_Location_ID, null);
		else 
			set_Value (COLUMNNAME_C_BPartner_Location_ID, Integer.valueOf(C_BPartner_Location_ID));
	}

	/** Get Partner Location.
		@return Identifies the (ship to) address for this Business Partner
	  */
	public int getC_BPartner_Location_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_Location_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

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

	/** Set Citizen ID.
		@param CitizenID Citizen ID	  */
	public void setCitizenID (String CitizenID)
	{
		set_Value (COLUMNNAME_CitizenID, CitizenID);
	}

	/** Get Citizen ID.
		@return Citizen ID	  */
	public String getCitizenID () 
	{
		return (String)get_Value(COLUMNNAME_CitizenID);
	}

	/** Set Document Date.
		@param DateDoc 
		Date of the Document
	  */
	public void setDateDoc (Timestamp DateDoc)
	{
		set_Value (COLUMNNAME_DateDoc, DateDoc);
	}

	/** Get Document Date.
		@return Date of the Document
	  */
	public Timestamp getDateDoc () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateDoc);
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

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), getDocumentNo());
    }

	/** Set Printed.
		@param IsPrinted 
		Indicates if this document / line is printed
	  */
	public void setIsPrinted (String IsPrinted)
	{
		set_Value (COLUMNNAME_IsPrinted, IsPrinted);
	}

	/** Get Printed.
		@return Indicates if this document / line is printed
	  */
	public String getIsPrinted () 
	{
		return (String)get_Value(COLUMNNAME_IsPrinted);
	}

	/** Set Phor Ngor Dor Type.
		@param PNDType Phor Ngor Dor Type	  */
	public void setPNDType (String PNDType)
	{
		set_Value (COLUMNNAME_PNDType, PNDType);
	}

	/** Get Phor Ngor Dor Type.
		@return Phor Ngor Dor Type	  */
	public String getPNDType () 
	{
		return (String)get_Value(COLUMNNAME_PNDType);
	}

	/** Set Processed.
		@param Processed 
		The document has been processed
	  */
	public void setProcessed (boolean Processed)
	{
		set_ValueNoCheck (COLUMNNAME_Processed, Boolean.valueOf(Processed));
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

	/** Set Record ID.
		@param Record_ID 
		Direct internal record ID
	  */
	public void setRecord_ID (int Record_ID)
	{
		if (Record_ID < 0) 
			set_Value (COLUMNNAME_Record_ID, null);
		else 
			set_Value (COLUMNNAME_Record_ID, Integer.valueOf(Record_ID));
	}

	/** Get Record ID.
		@return Direct internal record ID
	  */
	public int getRecord_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Record_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Sequence.
		@param SeqNo 
		Method of ordering records; lowest number comes first
	  */
	public void setSeqNo (int SeqNo)
	{
		set_Value (COLUMNNAME_SeqNo, Integer.valueOf(SeqNo));
	}

	/** Get Sequence.
		@return Method of ordering records; lowest number comes first
	  */
	public int getSeqNo () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_SeqNo);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Tax ID.
		@param TaxID 
		Tax Identification
	  */
	public void setTaxID (String TaxID)
	{
		set_Value (COLUMNNAME_TaxID, TaxID);
	}

	/** Get Tax ID.
		@return Tax Identification
	  */
	public String getTaxID () 
	{
		return (String)get_Value(COLUMNNAME_TaxID);
	}

	/** Set Total Amount.
		@param TotalAmt 
		Total Amount
	  */
	public void setTotalAmt (BigDecimal TotalAmt)
	{
		throw new IllegalArgumentException ("TotalAmt is virtual column");	}

	/** Get Total Amount.
		@return Total Amount
	  */
	public BigDecimal getTotalAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_TotalAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Withholding Tax Type.
		@param WHTaxType Withholding Tax Type	  */
	public void setWHTaxType (String WHTaxType)
	{
		set_Value (COLUMNNAME_WHTaxType, WHTaxType);
	}

	/** Get Withholding Tax Type.
		@return Withholding Tax Type	  */
	public String getWHTaxType () 
	{
		return (String)get_Value(COLUMNNAME_WHTaxType);
	}

	/** Set Withholding Tax Type Other.
		@param WHTaxTypeOthers Withholding Tax Type Other	  */
	public void setWHTaxTypeOthers (String WHTaxTypeOthers)
	{
		set_Value (COLUMNNAME_WHTaxTypeOthers, WHTaxTypeOthers);
	}

	/** Get Withholding Tax Type Other.
		@return Withholding Tax Type Other	  */
	public String getWHTaxTypeOthers () 
	{
		return (String)get_Value(COLUMNNAME_WHTaxTypeOthers);
	}

	/** WHTCertifiedStatus AD_Reference_ID=80003 */
	public static final int WHTCERTIFIEDSTATUS_AD_Reference_ID=80003;
	/** Draft = DR */
	public static final String WHTCERTIFIEDSTATUS_Draft = "DR";
	/** Prepared = PR */
	public static final String WHTCERTIFIEDSTATUS_Prepared = "PR";
	/** Used = US */
	public static final String WHTCERTIFIEDSTATUS_Used = "US";
	/** Set Withholding Status.
		@param WHTCertifiedStatus Withholding Status	  */
	public void setWHTCertifiedStatus (String WHTCertifiedStatus)
	{

		set_Value (COLUMNNAME_WHTCertifiedStatus, WHTCertifiedStatus);
	}

	/** Get Withholding Status.
		@return Withholding Status	  */
	public String getWHTCertifiedStatus () 
	{
		return (String)get_Value(COLUMNNAME_WHTCertifiedStatus);
	}

	/** WithholdingAction AD_Reference_ID=80004 */
	public static final int WITHHOLDINGACTION_AD_Reference_ID=80004;
	/** Prepared = PR */
	public static final String WITHHOLDINGACTION_Prepared = "PR";
	/** Draft = DR */
	public static final String WITHHOLDINGACTION_Draft = "DR";
	/** Set Withholding Action.
		@param WithholdingAction Withholding Action	  */
	public void setWithholdingAction (String WithholdingAction)
	{

		set_Value (COLUMNNAME_WithholdingAction, WithholdingAction);
	}

	/** Get Withholding Action.
		@return Withholding Action	  */
	public String getWithholdingAction () 
	{
		return (String)get_Value(COLUMNNAME_WithholdingAction);
	}

	/** Set Witholding Amount.
		@param WithholdingAmt Witholding Amount	  */
	public void setWithholdingAmt (BigDecimal WithholdingAmt)
	{
		throw new IllegalArgumentException ("WithholdingAmt is virtual column");	}

	/** Get Witholding Amount.
		@return Witholding Amount	  */
	public BigDecimal getWithholdingAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_WithholdingAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
}