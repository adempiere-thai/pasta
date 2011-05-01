package org.pasta.model;

import java.util.Properties;

import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MDocType;

public class CalloutInvoice extends CalloutEngine {
	public String docType (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value){
		if(value ==null)
			return "";
		
		int C_DocType_ID = (Integer)value;
		MDocType docType = null;
		if(C_DocType_ID > 0 )
			docType = MDocType.get(ctx, C_DocType_ID);
		
		String docBaseType = String.valueOf(docType.getDocBaseType().charAt(2));
		if("C".equals(docBaseType) || "D".equals(docBaseType))
			mTab.setValue("IsCreditDebit", true);
		else
			mTab.setValue("IsCreditDebit", false);
		
		return "";
	}
}
