package org.pasta.model;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

import org.compiere.model.MOrder;
import org.compiere.model.MOrg;
import org.compiere.model.MSequence;
import org.compiere.model.MShipper;
import org.compiere.model.Query;
import org.compiere.util.Env;

public class MMMPackage extends X_MM_Package {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8996784958039365574L;

	public MMMPackage(Properties ctx, int MM_Package_ID, String trxName) {
		super(ctx, MM_Package_ID, trxName);
		if(MM_Package_ID ==0)
			setDefaultValue(ctx);
	}

	public MMMPackage(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		//setDefaultValue(ctx);
	}

	public MMMPackage(MOrder order,int running) {
		// TODO Auto-generated constructor stub
		this(order.getCtx(),0,order.get_TrxName());
		setC_Order_ID(order.getC_Order_ID());
		setDefaultValue(order.getCtx());
		this.running = running;
		MOrg org = MOrg.get(order.getCtx(), order.getAD_Org_ID());
		this.prefixDoc = org.getDescription().substring(0, 1) ; 
	}
	
	private int running = 0; 
	private String prefixDoc = "";
	
	private void setDefaultValue(Properties ctx){
		setPackBy(Env.getAD_User_ID(ctx));
		setPackDate(new Timestamp(System.currentTimeMillis()));
		setPackStatus("PA");
		setPackSize("6");
	}
	
	protected boolean beforeSave(boolean newRecord) {
		if(newRecord){
			setDocumentNo(prefixDoc+"PA"+getC_Order().getDocumentNo()+"-"+running);
		}
		
		return true;
	}
	
	public static MMMPackage findPackageByNo(Properties ctx, String packageNo,String trxName){
		String whereClause = MMMPackage.COLUMNNAME_DocumentNo+"= ? ";
		MMMPackage pack =  new Query(ctx, MMMPackage.Table_Name,whereClause, trxName).setParameters(packageNo).first();
		return pack;
	}
	
	public boolean isShipped(){
		return PACKSTATUS_Shipped.equals(this.getPackStatus());
	}
	
	public void shipped(){
		this.setPackStatus(PACKSTATUS_Shipped);
	}
}
