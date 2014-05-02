package org.pasta.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;

public class MSDDeliveryLine extends X_SD_DeliveryLine {

	public MSDDeliveryLine(Properties ctx, int SD_DeliveryLine_ID,
			String trxName) {
		super(ctx, SD_DeliveryLine_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MSDDeliveryLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public MSDDeliveryLine(MSDDelivery delivery,int packageId){
		this(delivery.getCtx(), 0, delivery.get_TrxName());
		setMM_Package_ID(packageId);
		setSD_Delivery_ID(delivery.getSD_Delivery_ID());
		setStatus(STATUS_Shipped);
	}

	protected boolean afterSave(boolean newRecord, boolean success) {
		// TODO Auto-generated method stub
		
		if(isReturned()){
			MMMPackage pack = new MMMPackage(this.getCtx(),this.getMM_Package_ID(),this.get_TrxName());
			pack.setPackStatus(MMMPackage.PACKSTATUS_Returned);
			if(!pack.save(this.get_TrxName()))
				throw new AdempiereException("CANNOT_UPDATE_PACKAGE_STATUS_TO_RETURN");
		}
		
		return true;
	}
	
	public boolean isReturned(){
		return STATUS_Returned.equals(getStatus()) ;
	}
}
