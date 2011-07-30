package org.pasta.model;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class CalloutJobsOrder extends CalloutEngine {
	public String soLine (Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value){
		if(value ==null){
			clearValue(mTab);
			return NO_ERROR;
		}
		
		int i_C_OrderLine_ID = (Integer)value;
		if(i_C_OrderLine_ID<=0){
			clearValue(mTab);
			return NO_ERROR;
		}
		
		BigDecimal remainQty = Env.ZERO;
		int i_C_UOM_ID = 0 ;
		int i_M_Product_ID = 0;
		
		
		String sql = "SELECT ol.m_Product_Id , ol.c_Uom_Id ,MAX(ol.qtyentered) - COALESCE(SUM(jol.Qty),0) as remainQty "
					+"FROM C_OrderLine ol "
					+"LEFT JOIN SO_JobsOrderLine jol ON jol.C_OrderLine_ID = ol.C_OrderLine_ID "
					+"WHERE ol.C_OrderLine_ID = ? "
					+"GROUP BY ol.m_Product_Id , ol.c_Uom_Id ";
		
		PreparedStatement ppstmt = DB.prepareStatement(sql,null);
		try{
			ppstmt.setInt(1, i_C_OrderLine_ID);
			ResultSet rs = ppstmt.executeQuery();
			if(rs.next()){
				i_M_Product_ID = rs.getInt(1);
				i_C_UOM_ID = rs.getInt(2);
				remainQty = rs.getBigDecimal(3);
			}
		}
		catch(Exception ex){
			log.saveError("Error", ex);
			return "Error!";
		}
		
		mTab.setValue(X_SO_JobsOrderLine.COLUMNNAME_Qty, remainQty);
		mTab.setValue(X_SO_JobsOrderLine.COLUMNNAME_C_UOM_ID , i_C_UOM_ID);
		mTab.setValue(X_SO_JobsOrderLine.COLUMNNAME_M_Product_ID , i_M_Product_ID);
		
		return NO_ERROR;
	}
	
	private void clearValue(GridTab mTab){
		mTab.setValue(X_SO_JobsOrderLine.COLUMNNAME_Qty, Env.ZERO);
		mTab.setValue(X_SO_JobsOrderLine.COLUMNNAME_C_UOM_ID , null);
		mTab.setValue(X_SO_JobsOrderLine.COLUMNNAME_M_Product_ID , null);
	}
}