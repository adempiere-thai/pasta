package org.pasta.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.Query;

public class MWHTaxTrans extends X_C_WHTaxTrans {

	public MWHTaxTrans(Properties ctx, int C_WHTaxTrans_ID, String trxName) {
		super(ctx, C_WHTaxTrans_ID, trxName);
	}

	public MWHTaxTrans(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
	
	public static List<X_C_WHTaxTransLine> getLines(Properties ctx,int id,String trxName){
		if(id ==0 )
			throw new AdempiereException("NO_WHTAX_HEADER_ID");
		
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		
		String whereClause = MWHTaxTransLine.COLUMNNAME_C_WHTaxTrans_ID + " = ? ";
		String orderBy = MWHTaxTransLine.COLUMNNAME_C_RevenueType_ID;
		
		return new Query(ctx,X_C_WHTaxTransLine.Table_Name,whereClause.toString(),trxName)
					.setOrderBy(orderBy)
					.setParameters(params)
					.list();
	}
}
