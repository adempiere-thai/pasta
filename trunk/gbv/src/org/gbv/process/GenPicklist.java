package org.gbv.process;

import java.math.BigDecimal;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.webui.apps.AEnv;
import org.compiere.model.MOrder;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.pasta.model.MMPicklist;

public class GenPicklist extends SvrProcess {
	
	private int				p_AD_Org_ID ;
	private int				p_C_Order_ID;

	protected void prepare() {
		// TODO Auto-generated method stub
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++)
		{
			String name = para[i].getParameterName();
			if (para[i].getParameter() == null)
					;
			else if (name.equals("AD_Org_ID"))
				p_AD_Org_ID = ((BigDecimal)para[i].getParameter()).intValue();
			else if (name.equals("C_Order_ID"))
				p_C_Order_ID = ((BigDecimal)para[i].getParameter()).intValue();
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}
	}

	@Override
	protected String doIt() throws Exception {
		// TODO Auto-generated method stub
		MOrder order = new MOrder(getCtx(),p_C_Order_ID,get_TrxName());
		
		MMPicklist picklist = MMPicklist.getPicklistFromOrder(order);
		
		if(picklist != null){
			throw new AdempiereException(ERR_PICKLIST_WAS_GENERATED);
		}
		
		picklist = new MMPicklist(getCtx(),0,get_TrxName());
		picklist.setAD_Org_ID(p_AD_Org_ID);
		picklist.setC_Order_ID(order.getC_Order_ID());
		picklist.setDocumentNo(order.getDocumentNo());
		
		if(!picklist.save(get_TrxName()))
			throw new AdempiereException(ERR_CANNOT_SAVE_PICKLIST_HDR);
		
		picklist.pickItemsFromOrder(order,p_AD_Org_ID);
		
		return picklist.toString();
	}
	
	private static final String ERR_PICKLIST_WAS_GENERATED = "PICKLIST_WAS_GENERATED_FOR_ORDER";
	private static final String ERR_CANNOT_SAVE_PICKLIST_HDR = "CANNOT_SAVE_PICKLIST";

}
