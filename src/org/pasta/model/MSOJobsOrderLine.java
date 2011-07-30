package org.pasta.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MProduct;

public class MSOJobsOrderLine extends X_SO_JobsOrderLine {

	public MSOJobsOrderLine(Properties ctx, int SO_JobsOrderLine_ID,String trxName) {
		super(ctx, SO_JobsOrderLine_ID, trxName);
	}

	public MSOJobsOrderLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	MProduct product = null ;
	
	public MProduct getProduct(){
		if(getM_Product_ID() > 0 && product == null)
			product = new MProduct(getCtx(),getM_Product_ID(),get_TrxName());
		
		return product;
	}
}
