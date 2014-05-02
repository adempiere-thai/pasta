package org.pasta.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MMMPackageLine extends X_MM_PackageLine {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2976053102460134889L;

	public MMMPackageLine(Properties ctx, int MM_PackageLine_ID, String trxName) {
		super(ctx, MM_PackageLine_ID, trxName);
	}

	public MMMPackageLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
	
	public MMMPackageLine(MMMPackage pack) {
		super(pack.getCtx(), 0, pack.get_TrxName());
		setMM_Package_ID(pack.getMM_Package_ID());
	}
}
