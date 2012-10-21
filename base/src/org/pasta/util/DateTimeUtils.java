package org.pasta.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils {
	public static Timestamp getFistDayOfMonth(Timestamp timestamp){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(timestamp.getTime());
		
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		
		Timestamp fistday = new Timestamp(calendar.getTimeInMillis());
		return fistday;
	}
	
	public static Timestamp getLastDayOfMonth(Timestamp timestamp){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(timestamp.getTime());
		
		int lastDate = calendar.getActualMaximum(Calendar.DATE);
		
		calendar.set(Calendar.DAY_OF_MONTH, lastDate);
		
		Timestamp lastday = new Timestamp(calendar.getTimeInMillis());
		return lastday;
	}
	
	public static void main(String[] args){
		Date today = new Date();
		Timestamp today_in_timestamp = new Timestamp(today.getTime());
		
		System.out.println("Today is "+today_in_timestamp);
		
		System.out.println("Fist of this month is "+getFistDayOfMonth(today_in_timestamp));
		System.out.println("Last of this month is "+getLastDayOfMonth(today_in_timestamp));
	}
}
