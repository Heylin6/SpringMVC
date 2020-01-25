package com.example.demo.Controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.example.demo.Common.UserInfo;

public abstract class baseContoller {
	
	//基本控制器都用的到的地方都放這
	
	//後台使用者資訊
	protected UserInfo getuserInfo(HttpServletRequest req){
		
		return req != null ? 
				(UserInfo)req.getSession() : null;
	}
	
	public String getIpAddr(HttpServletRequest request) {
		
        String ip = request.getHeader("x-forwarded-for"); 
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("Proxy-Client-IP"); 
        } 
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("WL-Proxy-Client-IP"); 
        } 
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getRemoteAddr(); 
        } 
        if("0:0:0:0:0:0:0:1".equals(ip)){
        	ip = "127.0.0.1";
        }
        return ip; 
    } 
}
