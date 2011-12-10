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

/** Generated Interface for C_WHTaxTrans
 *  @author Adempiere (generated) 
 *  @version Release 3.6.0LTS
 */
public interface I_C_WHTaxTrans 
{

    /** TableName=C_WHTaxTrans */
    public static final String Table_Name = "C_WHTaxTrans";

    /** AD_Table_ID=80000 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name AD_Table_ID */
    public static final String COLUMNNAME_AD_Table_ID = "AD_Table_ID";

	/** Set Table.
	  * Database Table information
	  */
	public void setAD_Table_ID (int AD_Table_ID);

	/** Get Table.
	  * Database Table information
	  */
	public int getAD_Table_ID();

	public I_AD_Table getAD_Table() throws RuntimeException;

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

    /** Column name C_BPartner_ID */
    public static final String COLUMNNAME_C_BPartner_ID = "C_BPartner_ID";

	/** Set Business Partner .
	  * Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID);

	/** Get Business Partner .
	  * Identifies a Business Partner
	  */
	public int getC_BPartner_ID();

	public I_C_BPartner getC_BPartner() throws RuntimeException;

    /** Column name C_BPartner_Location_ID */
    public static final String COLUMNNAME_C_BPartner_Location_ID = "C_BPartner_Location_ID";

	/** Set Partner Location.
	  * Identifies the (ship to) address for this Business Partner
	  */
	public void setC_BPartner_Location_ID (int C_BPartner_Location_ID);

	/** Get Partner Location.
	  * Identifies the (ship to) address for this Business Partner
	  */
	public int getC_BPartner_Location_ID();

	public I_C_BPartner_Location getC_BPartner_Location() throws RuntimeException;

    /** Column name C_WHTaxTrans_ID */
    public static final String COLUMNNAME_C_WHTaxTrans_ID = "C_WHTaxTrans_ID";

	/** Set Withholding Tax Transaction	  */
	public void setC_WHTaxTrans_ID (int C_WHTaxTrans_ID);

	/** Get Withholding Tax Transaction	  */
	public int getC_WHTaxTrans_ID();

    /** Column name CitizenID */
    public static final String COLUMNNAME_CitizenID = "CitizenID";

	/** Set Citizen ID	  */
	public void setCitizenID (String CitizenID);

	/** Get Citizen ID	  */
	public String getCitizenID();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name DateDoc */
    public static final String COLUMNNAME_DateDoc = "DateDoc";

	/** Set Document Date.
	  * Date of the Document
	  */
	public void setDateDoc (Timestamp DateDoc);

	/** Get Document Date.
	  * Date of the Document
	  */
	public Timestamp getDateDoc();

    /** Column name DocumentNo */
    public static final String COLUMNNAME_DocumentNo = "DocumentNo";

	/** Set Document No.
	  * Document sequence number of the document
	  */
	public void setDocumentNo (String DocumentNo);

	/** Get Document No.
	  * Document sequence number of the document
	  */
	public String getDocumentNo();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name PNDType */
    public static final String COLUMNNAME_PNDType = "PNDType";

	/** Set Phor Ngor Dor Type	  */
	public void setPNDType (String PNDType);

	/** Get Phor Ngor Dor Type	  */
	public String getPNDType();

    /** Column name Processed */
    public static final String COLUMNNAME_Processed = "Processed";

	/** Set Processed.
	  * The document has been processed
	  */
	public void setProcessed (boolean Processed);

	/** Get Processed.
	  * The document has been processed
	  */
	public boolean isProcessed();

    /** Column name Record_ID */
    public static final String COLUMNNAME_Record_ID = "Record_ID";

	/** Set Record ID.
	  * Direct internal record ID
	  */
	public void setRecord_ID (int Record_ID);

	/** Get Record ID.
	  * Direct internal record ID
	  */
	public int getRecord_ID();

    /** Column name SeqNo */
    public static final String COLUMNNAME_SeqNo = "SeqNo";

	/** Set Sequence.
	  * Method of ordering records;
 lowest number comes first
	  */
	public void setSeqNo (int SeqNo);

	/** Get Sequence.
	  * Method of ordering records;
 lowest number comes first
	  */
	public int getSeqNo();

    /** Column name TaxID */
    public static final String COLUMNNAME_TaxID = "TaxID";

	/** Set Tax ID.
	  * Tax Identification
	  */
	public void setTaxID (String TaxID);

	/** Get Tax ID.
	  * Tax Identification
	  */
	public String getTaxID();

    /** Column name TotalAmt */
    public static final String COLUMNNAME_TotalAmt = "TotalAmt";

	/** Set Total Amount.
	  * Total Amount
	  */
	public void setTotalAmt (BigDecimal TotalAmt);

	/** Get Total Amount.
	  * Total Amount
	  */
	public BigDecimal getTotalAmt();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();

    /** Column name WHTCertifiedStatus */
    public static final String COLUMNNAME_WHTCertifiedStatus = "WHTCertifiedStatus";

	/** Set Withholding Status	  */
	public void setWHTCertifiedStatus (String WHTCertifiedStatus);

	/** Get Withholding Status	  */
	public String getWHTCertifiedStatus();

    /** Column name WHTaxType */
    public static final String COLUMNNAME_WHTaxType = "WHTaxType";

	/** Set Withholding Tax Type	  */
	public void setWHTaxType (String WHTaxType);

	/** Get Withholding Tax Type	  */
	public String getWHTaxType();

    /** Column name WHTaxTypeOthers */
    public static final String COLUMNNAME_WHTaxTypeOthers = "WHTaxTypeOthers";

	/** Set Withholding Tax Type Other	  */
	public void setWHTaxTypeOthers (String WHTaxTypeOthers);

	/** Get Withholding Tax Type Other	  */
	public String getWHTaxTypeOthers();

    /** Column name WithholdingAction */
    public static final String COLUMNNAME_WithholdingAction = "WithholdingAction";

	/** Set Withholding Action	  */
	public void setWithholdingAction (String WithholdingAction);

	/** Get Withholding Action	  */
	public String getWithholdingAction();

    /** Column name WithholdingAmt */
    public static final String COLUMNNAME_WithholdingAmt = "WithholdingAmt";

	/** Set Witholding Amount	  */
	public void setWithholdingAmt (BigDecimal WithholdingAmt);

	/** Get Witholding Amount	  */
	public BigDecimal getWithholdingAmt();
}
