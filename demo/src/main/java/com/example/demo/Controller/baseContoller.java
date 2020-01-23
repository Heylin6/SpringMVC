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
}
