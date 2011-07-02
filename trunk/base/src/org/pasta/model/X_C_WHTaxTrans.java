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
import org.compiere.util.KeyNamePair;

/** Generated Model for C_WHTaxTrans
 *  @author Adempiere (generated) 
 *  @version Release 3.6.0LTS - $Id$ */
public class X_C_WHTaxTrans extends PO implements I_C_WHTaxTrans, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20110501L;

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
			setDocumentNo (null);
			setPNDType (null);
			setWHTaxType (null);
// 1
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

	public I_C_BPartner getC_BPartner() throws RuntimeException
    {
		return (I_C_BPartner)MTable.get(getCtx(), I_C_BPartner.Table_Name)
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

	public I_C_BPartner_Location getC_BPartner_Location() throws RuntimeException
    {
		return (I_C_BPartner_Location)MTable.get(getCtx(), I_C_BPartner_Location.Table_Name)
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
}