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

import org.compiere.model.MTable;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;

/** Generated Model for C_Payment
 *  @author Adempiere (generated) 
 *  @version Release 3.6.0LTS - $Id$ */
public class X_C_Payment extends org.compiere.model.X_C_Payment implements org.pasta.model.I_C_Payment
{
	/** Standard Constructor */
    public X_C_Payment (Properties ctx, int C_Payment_ID, String trxName)
    {
      super (ctx, C_Payment_ID, trxName);
    }

    /** Load Constructor */
    public X_C_Payment (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

	public String getCheckName() {
		return (String)get_Value(COLUMNNAME_CheckName);
	}

	public void setCheckName(String CheckName) {
		set_Value (COLUMNNAME_CheckName, CheckName);
	}

	public BigDecimal getWithholdingAmt() {
		return (BigDecimal)get_Value(COLUMNNAME_WithholdingAmt);
	}

	public void setWithholdingAmt(BigDecimal WithholdingAmt) {
		set_Value (COLUMNNAME_WithholdingAmt, WithholdingAmt);
	}
}