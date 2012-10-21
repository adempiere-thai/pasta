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

/** Generated Model for TH_WithholdingSeq_Running
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS - $Id$ */
public class X_TH_WithholdingSeq_Running extends PO implements I_TH_WithholdingSeq_Running, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20120729L;

    /** Standard Constructor */
    public X_TH_WithholdingSeq_Running (Properties ctx, int TH_WithholdingSeq_Running_ID, String trxName)
    {
      super (ctx, TH_WithholdingSeq_Running_ID, trxName);
      /** if (TH_WithholdingSeq_Running_ID == 0)
        {
			setCurrentSeq (0);
			setTH_WithholdingSeq_ID (0);
			setTH_WithholdingSeq_Running_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TH_WithholdingSeq_Running (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_TH_WithholdingSeq_Running[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Budha Year.
		@param BudhaYear Budha Year	  */
	public void setBudhaYear (int BudhaYear)
	{
		set_Value (COLUMNNAME_BudhaYear, Integer.valueOf(BudhaYear));
	}

	/** Get Budha Year.
		@return Budha Year	  */
	public int getBudhaYear () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BudhaYear);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Current Sequence.
		@param CurrentSeq Current Sequence	  */
	public void setCurrentSeq (int CurrentSeq)
	{
		set_Value (COLUMNNAME_CurrentSeq, Integer.valueOf(CurrentSeq));
	}

	/** Get Current Sequence.
		@return Current Sequence	  */
	public int getCurrentSeq () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_CurrentSeq);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set No of Month.
		@param MonthMM 
		Month Show When Set Date Format Text Pattern as mm in Java
	  */
	public void setMonthMM (int MonthMM)
	{
		set_Value (COLUMNNAME_MonthMM, Integer.valueOf(MonthMM));
	}

	/** Get No of Month.
		@return Month Show When Set Date Format Text Pattern as mm in Java
	  */
	public int getMonthMM () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_MonthMM);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.pasta.model.I_TH_WithholdingSeq getTH_WithholdingSeq() throws RuntimeException
    {
		return (org.pasta.model.I_TH_WithholdingSeq)MTable.get(getCtx(), org.pasta.model.I_TH_WithholdingSeq.Table_Name)
			.getPO(getTH_WithholdingSeq_ID(), get_TrxName());	}

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

	/** Set Wihholding Tax Sequence.
		@param TH_WithholdingSeq_Running_ID 
		Wihholding Tax Sequence Track
	  */
	public void setTH_WithholdingSeq_Running_ID (int TH_WithholdingSeq_Running_ID)
	{
		if (TH_WithholdingSeq_Running_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TH_WithholdingSeq_Running_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TH_WithholdingSeq_Running_ID, Integer.valueOf(TH_WithholdingSeq_Running_ID));
	}

	/** Get Wihholding Tax Sequence.
		@return Wihholding Tax Sequence Track
	  */
	public int getTH_WithholdingSeq_Running_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TH_WithholdingSeq_Running_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}