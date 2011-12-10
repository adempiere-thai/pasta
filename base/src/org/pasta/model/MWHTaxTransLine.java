package org.pasta.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MWHTaxTransLine extends X_C_WHTaxTransLine {

	public MWHTaxTransLine(Properties ctx, int C_WHTaxTransLine_ID,
			String trxName) {
		super(ctx, C_WHTaxTransLine_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MWHTaxTransLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
}
