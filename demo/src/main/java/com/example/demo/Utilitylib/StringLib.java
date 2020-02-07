package com.example.demo.Utilitylib;

import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringLib {

	/*
	 * getExtension(String)
	 * https://codertw.com/%E7%A8%8B%E5%BC%8F%E8%AA%9E%E8%A8%80/312297/
	 * 
	 */
    public static String getExtension(String filename){
    	
    	try {
    		return filename.substring(filename.lastIndexOf("."),filename.length()); 
    	}
    	catch(Exception e) {
    		return "";
    	}
    }    
}
