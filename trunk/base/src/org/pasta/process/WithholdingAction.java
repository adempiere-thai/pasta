package org.pasta.process;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.process.SvrProcess;
import org.pasta.model.X_C_WHTaxTrans;

public class WithholdingAction extends SvrProcess {
	
	private static final String MSG_NO_ERROR = "";

	private static final String ERR_NO_RECORD_ID = "CANNOT_FOUND_WITHHOLDING_TAX";
	private static final String ERR_CANNOT_UPDATE_WHTAX_STATUS = "CANNOT_UPDATE_WHTAX_STATUS";

	protected String doIt() throws Exception {
		if(C_WHTaxTrans_ID == 0 )
			throw new AdempiereException(ERR_NO_RECORD_ID);
		
		X_C_WHTaxTrans whtax = new X_C_WHTaxTrans(getCtx(),C_WHTaxTrans_ID,get_TrxName());
		log.finer(whtax.getDocumentNo()+" Action => "+whtax.getWithholdingAction());
		 
		String action = whtax.getWithholdingAction();
		
		if(action.equals(X_C_WHTaxTrans.WITHHOLDINGACTION_Prepared)){
			whtax.setWHTCertifiedStatus(X_C_WHTaxTrans.WHTCERTIFIEDSTATUS_Prepared);
			whtax.setWithholdingAction(X_C_WHTaxTrans.WITHHOLDINGACTION_Draft);
			//whtax.setProcessed(true);
		}
		else if(action.equals(X_C_WHTaxTrans.WITHHOLDINGACTION_Draft)){
			whtax.setWHTCertifiedStatus(X_C_WHTaxTrans.WHTCERTIFIEDSTATUS_Draft);
			whtax.setWithholdingAction(X_C_WHTaxTrans.WITHHOLDINGACTION_Prepared);
			//whtax.setProcessed(false);
		}
		
		if(!whtax.save(get_TrxName()))
			throw new AdempiereException(ERR_CANNOT_UPDATE_WHTAX_STATUS);
		
		return MSG_NO_ERROR;
	}
	
	int C_WHTaxTrans_ID = 0;

	protected void prepare() {
		C_WHTaxTrans_ID = getRecord_ID();
	}

}
