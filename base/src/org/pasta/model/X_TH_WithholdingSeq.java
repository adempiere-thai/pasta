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

/** Generated Model for TH_WithholdingSeq
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS - $Id$ */
public class X_TH_WithholdingSeq extends PO implements I_TH_WithholdingSeq, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20120729L;

    /** Standard Constructor */
    public X_TH_WithholdingSeq (Properties ctx, int TH_WithholdingSeq_ID, String trxName)
    {
      super (ctx, TH_WithholdingSeq_ID, trxName);
      /** if (TH_WithholdingSeq_ID == 0)
        {
			setIsResetByYear (true);
// Y
			setIsUseDatePrefix (false);
// N
			setSequenceDigit (0);
// 3
			setTH_WithholdingSeq_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TH_WithholdingSeq (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TH_WithholdingSeq[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Column getAD_DateColumn() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Column)MTable.get(getCtx(), org.compiere.model.I_AD_Column.Table_Name)
			.getPO(getAD_DateColumn_ID(), get_TrxName());	}

	/** Set Date Column.
		@param AD_DateColumn_ID Date Column	  */
	public void setAD_DateColumn_ID (int AD_DateColumn_ID)
	{
		if (AD_DateColumn_ID < 1) 
			set_Value (COLUMNNAME_AD_DateColumn_ID, null);
		else 
			set_Value (COLUMNNAME_AD_DateColumn_ID, Integer.valueOf(AD_DateColumn_ID));
	}

	/** Get Date Column.
		@return Date Column	  */
	public int getAD_DateColumn_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_DateColumn_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Prefix Date Format.
		@param FormatDate Prefix Date Format	  */
	public void setFormatDate (String FormatDate)
	{
		set_Value (COLUMNNAME_FormatDate, FormatDate);
	}

	/** Get Prefix Date Format.
		@return Prefix Date Format	  */
	public String getFormatDate () 
	{
		return (String)get_Value(COLUMNNAME_FormatDate);
	}

	/** Set Reset By Month.
		@param IsResetByMonth Reset By Month	  */
	public void setIsResetByMonth (boolean IsResetByMonth)
	{
		set_Value (COLUMNNAME_IsResetByMonth, Boolean.valueOf(IsResetByMonth));
	}

	/** Get Reset By Month.
		@return Reset By Month	  */
	public boolean isResetByMonth () 
	{
		Object oo = get_Value(COLUMNNAME_IsResetByMonth);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Reset By Year.
		@param IsResetByYear Reset By Year	  */
	public void setIsResetByYear (boolean IsResetByYear)
	{
		set_Value (COLUMNNAME_IsResetByYear, Boolean.valueOf(IsResetByYear));
	}

	/** Get Reset By Year.
		@return Reset By Year	  */
	public boolean isResetByYear () 
	{
		Object oo = get_Value(COLUMNNAME_IsResetByYear);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Use Dynamic Date Prefic.
		@param IsUseDatePrefix 
		Use Dynamic Date Prefic
	  */
	public void setIsUseDatePrefix (boolean IsUseDatePrefix)
	{
		set_Value (COLUMNNAME_IsUseDatePrefix, Boolean.valueOf(IsUseDatePrefix));
	}

	/** Get Use Dynamic Date Prefic.
		@return Use Dynamic Date Prefic
	  */
	public boolean isUseDatePrefix () 
	{
		Object oo = get_Value(COLUMNNAME_IsUseDatePrefix);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Prefix.
		@param Prefix 
		Prefix before the sequence number
	  */
	public void setPrefix (String Prefix)
	{
		set_Value (COLUMNNAME_Prefix, Prefix);
	}

	/** Get Prefix.
		@return Prefix before the sequence number
	  */
	public String getPrefix () 
	{
		return (String)get_Value(COLUMNNAME_Prefix);
	}

	/** Set Sequence Digit.
		@param SequenceDigit Sequence Digit	  */
	public void setSequenceDigit (int SequenceDigit)
	{
		set_Value (COLUMNNAME_SequenceDigit, Integer.valueOf(SequenceDigit));
	}

	/** Get Sequence Digit.
		@return Sequence Digit	  */
	public int getSequenceDigit () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_SequenceDigit);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Withhodling Tax Cerificate Sequence Setup.
		@param TH_WithholdingSeq_ID Withhodling Tax Cerificate Sequence Setup	  */
	public void setTH_WithholdingSeq_ID (int TH_WithholdingSeq_ID)
	{
		if (TH_WithholdingSeq_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TH_WithholdingSeq_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TH_WithholdingSeq_ID, Integer.valueOf(TH_WithholdingSeq_ID));
	}

	/** Get Withhodling Tax Cerificate Sequence Setup.
		@return Withhodling Tax Cerificate Sequence Setup	  */
	public int getTH_WithholdingSeq_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TH_WithholdingSeq_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}