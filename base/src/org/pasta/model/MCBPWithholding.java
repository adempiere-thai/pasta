package org.pasta.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.util.DB;

public class MCBPWithholding extends org.pasta.model.X_C_BP_Withholding implements
		I_C_BP_Withholding {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3815386656697340498L;

	public MCBPWithholding(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MCBPWithholding(Properties ctx, int C_BPartner_ID, String trxName) {
		super(ctx, C_BPartner_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public static List<org.pasta.model.X_C_BP_Withholding> getPartnerWithholdingTax(Properties ctx, int C_BPartner_ID, String trxName) throws Exception{
		
		if(C_BPartner_ID ==0 )
			throw new AdempiereException("NO_PARTNER_ID");
		
		List<org.pasta.model.X_C_BP_Withholding> partnerTaxes = new ArrayList<org.pasta.model.X_C_BP_Withholding>(); 
		String whereClause = MCBPWithholding.COLUMNNAME_C_BPartner_ID+ " = ? ";
		String orderBy = MCWHTaxTransLine.COLUMNNAME_C_RevenueType_ID;
		
		String sql = "SELECT * FROM C_BP_Withholding WHERE "+whereClause+" ORDER BY "+orderBy;
		
		PreparedStatement ppstmt = DB.prepareStatement(sql,trxName);
		ppstmt.setInt(1, C_BPartner_ID);
		
		ResultSet rs = ppstmt.executeQuery();
		
		while(rs.next()){
			org.pasta.model.X_C_BP_Withholding partnerTax = new org.pasta.model.X_C_BP_Withholding(ctx,rs,trxName);
			partnerTaxes.add(partnerTax); 
		}
		
		return partnerTaxes;
	}
}
