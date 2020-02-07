package com.example.demo.Utilitylib;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateLib {
	
	
	/*
	 * Date To Timestamp(String)
	 * https://www.javatpoint.com/java-date-to-timestamp
	 * https://www.javatpoint.com/java-long-to-string
	 * 
	 */
    public static String DateToTimestampStr(){
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();  
        long lts = date.getTime()/1000;
		
		return String.valueOf(lts);

    }    
}
