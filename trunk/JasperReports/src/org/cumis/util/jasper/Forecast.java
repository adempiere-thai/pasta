package org.cumis.util.jasper;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.sf.jasperreports.engine.JRDefaultScriptlet;

public class Forecast extends JRDefaultScriptlet {
	private static BigDecimal getSumSalsQtyFromPreviousMonths(Connection conn,int productId,int no_of_months) throws Exception {
		StringBuffer sql =  new StringBuffer("SELECT COALESCE(SUM(s.Sales_Qty),0) as Total_Qty \n") ;
							sql.append("FROM sales_fact s \n")
							   .append("INNER JOIN time_dim t ON s.time_id = t.time_id \n")
							   .append("WHERE to_timestamp (t.Year||'-'||t.Month_name||'-01','YYYY-Mon-DD') > ADD_MONTHS(to_timestamp ( TO_CHAR(CURRENT_TIMESTAMP, 'yyyy-Mon')||'-01','YYYY-Mon-DD' ),?) \n")
							   .append("AND s.Product_Id = ? ");

		PreparedStatement ppstmt = conn.prepareStatement(sql.toString());
		ppstmt.setInt(1, no_of_months);
		ppstmt.setInt(2, productId);
		ResultSet rset = ppstmt.executeQuery();
		
		if(rset.next()){
			BigDecimal totalQty = rset.getBigDecimal("Total_Qty");
			return totalQty;
		}
		
		return BigDecimal.ZERO;
	}
	
	public static BigDecimal getForecastSalesQty(Connection conn,int productId,int no_of_months) throws Exception {
		
		BigDecimal totalQty = getSumSalsQtyFromPreviousMonths(conn,productId,no_of_months-4) ;
			
		if(no_of_months ==1) {
			BigDecimal forCastQty0 = getForecastSalesQty(conn,productId,0);
			totalQty = totalQty.add(forCastQty0);
		}
		if(no_of_months ==2) {
			BigDecimal forCastQty0 = getForecastSalesQty(conn,productId,0);
			BigDecimal forCastQty1 = getForecastSalesQty(conn,productId,1);
			totalQty = totalQty.add(forCastQty1).add(forCastQty0);
		}
		else if(no_of_months ==3) {
			BigDecimal forCastQty1 = getForecastSalesQty(conn,productId,1);
			BigDecimal forCastQty2 = getForecastSalesQty(conn,productId,2);
			
			totalQty = totalQty.add(forCastQty1).add(forCastQty2);
		}
			
		return totalQty.divide(new BigDecimal(3d), 2, 2);
	}
	
	
	public static void main(String[] args){
		try{
			Class.forName("org.postgresql.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gbv","gbv", "gbv");
			
			System.out.println("Sample get Forcast 1st Month "+getForecastSalesQty(conn,1000453,2));
		}
		catch(Exception ex){
			ex.printStackTrace(System.err);
		}
	}
}
