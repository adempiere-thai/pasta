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

/** Generated Interface for TH_WithholdingSeq
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS
 */
public interface I_TH_WithholdingSeq 
{

    /** TableName=TH_WithholdingSeq */
    public static final String Table_Name = "TH_WithholdingSeq";

    /** AD_Table_ID=80007 */
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

    /** Column name AD_DateColumn_ID */
    public static final String COLUMNNAME_AD_DateColumn_ID = "AD_DateColumn_ID";

	/** Set Date Column	  */
	public void setAD_DateColumn_ID (int AD_DateColumn_ID);

	/** Get Date Column	  */
	public int getAD_DateColumn_ID();

	public org.compiere.model.I_AD_Column getAD_DateColumn() throws RuntimeException;

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

    /** Column name FormatDate */
    public static final String COLUMNNAME_FormatDate = "FormatDate";

	/** Set Prefix Date Format	  */
	public void setFormatDate (String FormatDate);

	/** Get Prefix Date Format	  */
	public String getFormatDate();

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

    /** Column name IsResetByMonth */
    public static final String COLUMNNAME_IsResetByMonth = "IsResetByMonth";

	/** Set Reset By Month	  */
	public void setIsResetByMonth (boolean IsResetByMonth);

	/** Get Reset By Month	  */
	public boolean isResetByMonth();

    /** Column name IsResetByYear */
    public static final String COLUMNNAME_IsResetByYear = "IsResetByYear";

	/** Set Reset By Year	  */
	public void setIsResetByYear (boolean IsResetByYear);

	/** Get Reset By Year	  */
	public boolean isResetByYear();

    /** Column name IsUseDatePrefix */
    public static final String COLUMNNAME_IsUseDatePrefix = "IsUseDatePrefix";

	/** Set Use Dynamic Date Prefic.
	  * Use Dynamic Date Prefic
	  */
	public void setIsUseDatePrefix (boolean IsUseDatePrefix);

	/** Get Use Dynamic Date Prefic.
	  * Use Dynamic Date Prefic
	  */
	public boolean isUseDatePrefix();

    /** Column name Prefix */
    public static final String COLUMNNAME_Prefix = "Prefix";

	/** Set Prefix.
	  * Prefix before the sequence number
	  */
	public void setPrefix (String Prefix);

	/** Get Prefix.
	  * Prefix before the sequence number
	  */
	public String getPrefix();

    /** Column name SequenceDigit */
    public static final String COLUMNNAME_SequenceDigit = "SequenceDigit";

	/** Set Sequence Digit	  */
	public void setSequenceDigit (int SequenceDigit);

	/** Get Sequence Digit	  */
	public int getSequenceDigit();

    /** Column name TH_WithholdingSeq_ID */
    public static final String COLUMNNAME_TH_WithholdingSeq_ID = "TH_WithholdingSeq_ID";

	/** Set Withhodling Tax Cerificate Sequence Setup	  */
	public void setTH_WithholdingSeq_ID (int TH_WithholdingSeq_ID);

	/** Get Withhodling Tax Cerificate Sequence Setup	  */
	public int getTH_WithholdingSeq_ID();

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
}
