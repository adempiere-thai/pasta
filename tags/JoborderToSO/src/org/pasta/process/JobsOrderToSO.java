package org.pasta.process;

import java.math.BigDecimal;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;

import org.compiere.apps.AEnv;
import org.compiere.model.MDocType;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.MProduct;
import org.compiere.model.MProductBOM;
import org.compiere.model.MUOM;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.Msg;
import org.eevolution.model.MPPProductBOM;
import org.eevolution.model.MPPProductBOMLine;

import org.pasta.model.MSOJobsOrder;
import org.pasta.model.MSOJobsOrderLine;

public class JobsOrderToSO extends SvrProcess {

	protected String doIt() throws Exception {
		if(i_SO_JobsOrder_ID <= 0 ){
			throw new AdempiereException(Msg.translate(getCtx(), "NoSelectedJobsOrder")+"["+i_SO_JobsOrder_ID+"]");
		}
		
		MSOJobsOrder jobs = new MSOJobsOrder(getCtx(),i_SO_JobsOrder_ID,get_TrxName());
		if(!MSOJobsOrder.DOCSTATUS_Completed.equals(jobs.getDocStatus()))
			throw new AdempiereException(Msg.translate(getCtx(), "JobsOrderIsNotCompleted"));
		
		if(jobs.getSalesOrder_ID() >0 && !MOrder.DOCSTATUS_Voided.equals(jobs.getSalesOrder().getDocStatus()))
			throw new AdempiereException(Msg.translate(getCtx(), "JobsOrderWasGeneratedToSO")+"[SO."+jobs.getSalesOrder().getDocumentNo()+"]");
		
		
		MOrder so = new MOrder(getCtx(),0,get_TrxName());
		so.setBPartner(jobs.getPartner());
		so.setIsSOTrx(true);
		so.setC_DocTypeTarget_ID(MDocType.DOCSUBTYPESO_StandardOrder);
		so.setM_PriceList_ID(i_M_PriceList_ID);
		if(!so.save(get_TrxName()))
			throw new AdempiereException(Msg.translate(getCtx(), "CannotSaveSO"));
		
		MSOJobsOrderLine[] lines = jobs.getLines();
		for(MSOJobsOrderLine line: lines){
			if(line.getM_Product_ID() >0 && !line.getM_Product().isBOM())
				throw new AdempiereException(Msg.translate(getCtx(), "ProductIsNotBOM"));
			
			MProduct product = line.getProduct();
			MPPProductBOM bom = MPPProductBOM.getDefault(product, get_TrxName());
			MPPProductBOMLine[] bomLines = bom.getLines();
			for(MPPProductBOMLine bomLine : bomLines){
				MProduct productDetail = bomLine.getProduct();
				MUOM uom = (MUOM)bomLine.getC_UOM();
				BigDecimal bomQty = bomLine.getQty();
				BigDecimal orderQty = line.getQty().multiply(bomQty);
				
				/// Create New Sales Order Line
				MOrderLine soLine = new MOrderLine(so);
				soLine.setProduct(productDetail);
				soLine.setQty(orderQty);
				
				if(!soLine.save(get_TrxName()))
					throw new AdempiereException(Msg.translate(getCtx(), "CannotSaveSOLine"));
			}
		}
		
		jobs.setSalesOrder_ID(so.getC_Order_ID());
		if(!jobs.save(get_TrxName()))
			throw new AdempiereException(Msg.translate(getCtx(), "CannotSaveJobsOrder"));
		
		// Reload Sales Order To Print Document Info
		so.load(get_TrxName());
		
		addLog(so.getC_Order_ID(), so.getDateOrdered(), so.getTotalLines(), so.getDocumentNo());
		AEnv.zoom(so.Table_ID, so.getC_Order_ID());
		
		return Msg.translate(getCtx(), "sales.order")+"["+so.getDocumentInfo()+"]";
	}

	int i_SO_JobsOrder_ID = 0 ;
	
	int i_M_PriceList_ID = 0;
	
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++)
		{
			String name = para[i].getParameterName();
			if (para[i].getParameter() == null)
				;
			else if (name.equals("M_PriceList_ID"))
				i_M_PriceList_ID = para[i].getParameterAsInt();
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}
		
		i_SO_JobsOrder_ID = getRecord_ID();
	}

}
