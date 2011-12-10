package org.pasta.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.X_I_BPartner;

public class MBPartner extends X_C_BPartner implements
		I_C_BPartner {

	public MBPartner(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MBPartner(Properties ctx, int C_BPartner_ID, String trxName) {
		super(ctx, C_BPartner_ID, trxName);
		// TODO Auto-generated constructor stub
	}

}
