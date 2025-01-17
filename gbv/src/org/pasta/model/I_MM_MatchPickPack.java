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

/** Generated Interface for MM_MatchPickPack
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS
 */
public interface I_MM_MatchPickPack 
{

    /** TableName=MM_MatchPickPack */
    public static final String Table_Name = "MM_MatchPickPack";

    /** AD_Table_ID=80014 */
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

    /** Column name M_PicklistLine_ID */
    public static final String COLUMNNAME_M_PicklistLine_ID = "M_PicklistLine_ID";

	/** Set Picklist Line	  */
	public void setM_PicklistLine_ID (int M_PicklistLine_ID);

	/** Get Picklist Line	  */
	public int getM_PicklistLine_ID();

	public org.pasta.model.I_M_PicklistLine getM_PicklistLine() throws RuntimeException;

    /** Column name MM_MatchPickPack_ID */
    public static final String COLUMNNAME_MM_MatchPickPack_ID = "MM_MatchPickPack_ID";

	/** Set Match Pick Pack	  */
	public void setMM_MatchPickPack_ID (int MM_MatchPickPack_ID);

	/** Get Match Pick Pack	  */
	public int getMM_MatchPickPack_ID();

    /** Column name MM_Package_ID */
    public static final String COLUMNNAME_MM_Package_ID = "MM_Package_ID";

	/** Set Package to Customer	  */
	public void setMM_Package_ID (int MM_Package_ID);

	/** Get Package to Customer	  */
	public int getMM_Package_ID();

	public org.pasta.model.I_MM_Package getMM_Package() throws RuntimeException;

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
