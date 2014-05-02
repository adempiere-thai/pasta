package org.pasta.model;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MShipper;

public class MSDDelivery extends X_SD_Delivery {

	public MSDDelivery(Properties ctx, int SD_Delivery_ID, String trxName) {
		super(ctx, SD_Delivery_ID, trxName);
		
		if(SD_Delivery_ID==0)
			setDateDelivered(new Timestamp(System.currentTimeMillis()));
	}

	public MSDDelivery(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	/*public static MSDDelivery generateDelivery(MShipper shipper) {
		
		MSDDelivery delivery = 
		delivery.setM_Shipper_ID(shipper.getM_Shipper_ID());
		
		
		
		return delivery;
	}*/

	public void generateLines(List<Integer> packageIds) {
		// TODO Auto-generated method stub
		for(int packageId:packageIds){
			MMMPackage pack = new MMMPackage(this.getCtx(),packageId,this.get_TrxName());
			
			MSDDeliveryLine line = new MSDDeliveryLine(this,packageId);
			line.setAD_Org_ID(pack.getAD_Org_ID());
			if(!line.save(this.get_TrxName()))
				throw new AdempiereException("CannotSaveDeliveryLine");
			
			lines.add(line);
			pack.shipped();
			if(!pack.save(this.get_TrxName()))
				throw new AdempiereException("CannotUpdatePackageShipped");
			
		}
		
		log.fine(lines.size()+" Delivery Line was created.");
	}
	
	List<MSDDeliveryLine> lines = new ArrayList<MSDDeliveryLine>();
	
	public List<MSDDeliveryLine> getLines(){
		return lines;
	} 
}
