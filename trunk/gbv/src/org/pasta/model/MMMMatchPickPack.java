package org.pasta.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MMMMatchPickPack extends X_MM_MatchPickPack {

	public MMMMatchPickPack(Properties ctx, int MM_MatchPickPack_ID,
			String trxName) {
		super(ctx, MM_MatchPickPack_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MMMMatchPickPack(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public MMMMatchPickPack(MMPicklistLine pline , MMMPackage pack) {
		super(pack.getCtx(), 0, pack.get_TrxName());
		setM_PicklistLine_ID(pline.getM_PicklistLine_ID());
		setMM_Package_ID(pack.getMM_Package_ID());
	}

}
