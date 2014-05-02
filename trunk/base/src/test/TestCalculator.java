package test;

import java.math.BigDecimal;

public class TestCalculator {
	public static void main(String[] args){
		BigDecimal orderdQty = BigDecimal.valueOf(13d);
		BigDecimal packQty = BigDecimal.valueOf(6d);
		
		int no_of_pack = orderdQty.divide(packQty, 0, BigDecimal.ROUND_UP).intValue();
		
		System.out.println("no_of_pack : "+no_of_pack);
	}
}
