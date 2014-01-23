package org.pasta.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MMPicklistLine extends X_M_PicklistLine {

	public MMPicklistLine(Properties ctx, int M_PicklistLine_ID, String trxName) {
		super(ctx, M_PicklistLine_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MMPicklistLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public MMPicklistLine(MMPicklist pickHdr){
		this(pickHdr.getCtx(),0,pickHdr.get_TrxName());
		this.setM_Picklist_ID(pickHdr.getM_Picklist_ID());
	}
}
