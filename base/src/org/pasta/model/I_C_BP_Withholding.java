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

/** Generated Interface for C_BP_Withholding
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS
 */
public interface I_C_BP_Withholding 
{
    /** TableName=C_BP_Withholding */
    //public static final String Table_Name = "C_BP_Withholding";

    
    /** Column name C_RevenueType_ID */
    public static final String COLUMNNAME_C_RevenueType_ID = "C_RevenueType_ID";

	/** Set Revenue Type	  */
	public void setC_RevenueType_ID (int C_RevenueType_ID);

	/** Get Revenue Type	  */
	public int getC_RevenueType_ID();

	public org.pasta.model.I_C_RevenueType getC_RevenueType() throws RuntimeException;
}
