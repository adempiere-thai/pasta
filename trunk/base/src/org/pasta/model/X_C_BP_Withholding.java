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
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Model for C_BP_Withholding
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS - $Id$ */
public class X_C_BP_Withholding extends org.compiere.model.X_C_BP_Withholding implements org.pasta.model.I_C_BP_Withholding, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20120722L;

    /** Standard Constructor */
    public X_C_BP_Withholding (Properties ctx, int C_BP_Withholding_ID, String trxName)
    {
      super (ctx, C_BP_Withholding_ID, trxName);
      /** if (C_BP_Withholding_ID == 0)
        {
			setC_BPartner_ID (0);
			setC_RevenueType_ID (0);
			setC_Withholding_ID (0);
			setIsMandatoryWithholding (false);
			setIsTemporaryExempt (false);
        } */
    }

    /** Load Constructor */
    public X_C_BP_Withholding (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }
    
	public org.pasta.model.I_C_RevenueType getC_RevenueType() throws RuntimeException
    {
		return (org.pasta.model.I_C_RevenueType)MTable.get(getCtx(), org.pasta.model.I_C_RevenueType.Table_Name)
			.getPO(getC_RevenueType_ID(), get_TrxName());	}

	/** Set Revenue Type.
		@param C_RevenueType_ID Revenue Type	  */
	public void setC_RevenueType_ID (int C_RevenueType_ID)
	{
		if (C_RevenueType_ID < 1) 
			set_Value (COLUMNNAME_C_RevenueType_ID, null);
		else 
			set_Value (COLUMNNAME_C_RevenueType_ID, Integer.valueOf(C_RevenueType_ID));
	}

	/** Get Revenue Type.
		@return Revenue Type	  */
	public int getC_RevenueType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_RevenueType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}