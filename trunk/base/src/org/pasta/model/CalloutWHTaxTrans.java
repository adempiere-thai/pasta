package org.pasta.model;

import java.util.Properties;
import java.math.BigDecimal;

import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MWithholding;
import org.compiere.util.Env;

import org.pasta.model.I_C_WHTaxTrans;

import org.pasta.model.X_C_WHTaxTransLine;

public class CalloutWHTaxTrans extends CalloutEngine {
	public String bPartner (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value){
		int i_C_BPartner_ID = 0;
		if(value==null){
			// Clear Value
			mTab.setValue(I_C_WHTaxTrans.COLUMNNAME_CitizenID, null);
			mTab.setValue(I_C_WHTaxTrans.COLUMNNAME_TaxID, null);
			mTab.setValue(I_C_WHTaxTrans.COLUMNNAME_C_BPartner_Location_ID, null);
			return "";
		}
		
		// Default Value
		i_C_BPartner_ID = (Integer)value;
		if(i_C_BPartner_ID <= 0){
			mTab.setValue(I_C_WHTaxTrans.COLUMNNAME_CitizenID, null);
			mTab.setValue(I_C_WHTaxTrans.COLUMNNAME_TaxID, null);
			mTab.setValue(I_C_WHTaxTrans.COLUMNNAME_C_BPartner_Location_ID, null);
			return "";
		}
		
		X_C_BPartner partner = new X_C_BPartner(ctx,i_C_BPartner_ID,null);
		mTab.setValue(I_C_WHTaxTrans.COLUMNNAME_CitizenID, partner.getCitizenID());
		mTab.setValue(I_C_WHTaxTrans.COLUMNNAME_TaxID, partner.getTaxID());
		
		MBPartnerLocation[] bpLocs = MBPartnerLocation.getForBPartner(ctx, partner.getC_BPartner_ID());
		if(bpLocs.length <=0 )
			return "";
		
		
		// Find Default ID for Partner Location
		int i_C_BPartnerLocation = 0 ;
		for(MBPartnerLocation bpLoc : bpLocs){
			if(i_C_BPartnerLocation == 0 || bpLoc.isBillTo()){
				i_C_BPartnerLocation = bpLoc.get_ID();
				
				if(bpLoc.isBillTo()){
					mTab.setValue(I_C_WHTaxTrans.COLUMNNAME_C_BPartner_Location_ID, i_C_BPartnerLocation);
					return "";
				}
			}
		}
		
		mTab.setValue(I_C_WHTaxTrans.COLUMNNAME_C_BPartner_Location_ID, i_C_BPartnerLocation);
		return "";
	}
	
	public String calculateTaxAmt (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value){
		int C_Withholding_ID = 0;
		BigDecimal baseAmt = (BigDecimal)mTab.getValue(X_C_WHTaxTransLine.COLUMNNAME_TaxBaseAmt); 
		
		if(mTab.getValue(X_C_WHTaxTransLine.COLUMNNAME_C_Withholding_ID) != null)
			C_Withholding_ID = (Integer)mTab.getValue(X_C_WHTaxTransLine.COLUMNNAME_C_Withholding_ID);
		
		if(C_Withholding_ID==0 || baseAmt.signum()<=0){
			mTab.setValue(X_C_WHTaxTransLine.COLUMNNAME_TaxAmt, BigDecimal.ZERO);
			return "";
		}
		
		String retMsg = "";
		MWithholding rate = new MWithholding(Env.getCtx(),C_Withholding_ID,null);
		BigDecimal taxAmt = BigDecimal.ZERO;
		if(rate.isPercentWithholding()){
			taxAmt = calculateAmt(rate,baseAmt);
		}
		else{
			taxAmt = rate.getFixAmt();
		}
		
		mTab.setValue(X_C_WHTaxTransLine.COLUMNNAME_TaxAmt, taxAmt);
			
		return retMsg;
	}
	
	int i_scale = 2; // FIXED scale

	private BigDecimal calculateAmt(MWithholding rate , BigDecimal baseAmt){
		if(rate.getPercent().signum() <= 0)
			return BigDecimal.ZERO;
		
		return baseAmt.multiply(rate.getPercent()).divide(Env.ONEHUNDRED ,i_scale, BigDecimal.ROUND_HALF_UP);
	}
}
