package com.example.demo.Business;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.Common.UserInfo;
import com.example.demo.Service.baseService;
import com.example.demo.Service.userService;

/** 
 * 
 * out example: {data:{}, "code":1, msg:"abcd"}
 * 
 **/
public class userBusiness extends baseBusiness{ 
	
	private static userService userS = new userService();
	private static final String code = "user";
	
	public static Map BUSI_getUser(Map busi_m, UserInfo _u) {
		
		Map resMap = new HashMap();
		Map dataMap = new HashMap();
		
		if(_u == null) {			
			
			resMap.put("data",null);
			resMap = FUNC_setFinalStatus(resMap,code,99); 		
	 	}
		else {
			
			dataMap = userS.SEV_getUserList(busi_m);
			resMap.put("data",dataMap);
			
			resMap = FUNC_setFinalStatus(resMap,code,1);
		}	
		
		return resMap;
	}
	
	public static Map BUSI_getUser(Map busi_m, UserInfo _u, Integer userId) {
		
		Map resMap = new HashMap();
		Map dataMap = new HashMap();
		
		if(_u == null) {			
			
			resMap.put("data",null);
			resMap = FUNC_setFinalStatus(resMap,code,99); 		
	 	}
		else {
			
			dataMap = userS.SEV_getUserOne(busi_m);
			resMap.put("data",dataMap);
			
			resMap = FUNC_setFinalStatus(resMap,code,1);
		}	
		
		return resMap;
	}
	
	public static Map BUSI_addUser(Map busi_m, UserInfo _u) {

		Integer res =0;
		Map resMap = new HashMap();
		
		if(_u == null) {			
			
			resMap = FUNC_setFinalStatus(resMap,code,99); 		
	 	}
	 	else {
	 		
	 		//這邊放入相關判斷邏輯後放入map
	 		
		 	//新增建立時間
	 		busi_m.put("create_time", "");
	        //新增建立者id
	 		busi_m.put("create_name", _u.getuserName());	 		
			
	 		res = userS.SEV_addUser(busi_m);
	 		//寫入異動紀錄
	 		//
	 		
	 		resMap.put("data",null);
	 		resMap = FUNC_setFinalStatus(resMap,code,res);		
	 	}
        
		return resMap;
	}
	
	public static Map BUSI_modifyUser(Map busi_m, UserInfo _u) {

		Integer res =0;
		Map resMap = new HashMap();
		
		if(_u == null) {
			
			resMap = FUNC_setFinalStatus(resMap,code,99); 		
	 	}
	 	else {
	 		
	 		//這邊放入相關判斷邏輯後放入map
	 		
		 	//新增修改時間
	 		busi_m.put("modify_time", "");
	        //新增修改者id
	 		busi_m.put("modify_name", _u.getuserName());
	 		
	 		res = userS.SEV_modifyUser(busi_m);
	 		//寫入異動紀錄
	 		//
	 		
	 		resMap.put("data",null);
	 		resMap = FUNC_setFinalStatus(resMap,code,res);		
	 	}
        
		return resMap;
	}
	



	public static Map BUSI_deleteUser(Map busi_m,Integer userId,UserInfo _u) {		
		
		Integer res =0;
		Map resMap = new HashMap();
		
		if(_u == null) {
			
			resMap.put("data",null);
			resMap = FUNC_setFinalStatus(resMap,code,99); 		
	 	}
	 	else {
	 		
	 		res = userS.SEV_deleteUser(userId);
	 		//寫入異動紀錄
	 		//
	 		
	 		resMap.put("data",null);
	 		resMap = FUNC_setFinalStatus(resMap,code,res);		
	 	}
		
		return resMap;		
	}

	private static Map FUNC_setFinalStatus(Map resMap,String code,int resCode) {
		
		if(resCode==98){
			
	 		resMap.put("code", resCode);
	 		resMap.put("msg", "使用者不明,操作失敗");	 
		}
		else {
			
	 		resMap.put("code", resCode);
	 		resMap.put("msg", "操作完成");	
		}
		
		return resMap;
	}

	/** 
	 * 
	 * test function
	 * 
	 **/
	public Map test_setuser() {
		
		Map _user =new HashMap();
		
		 _user.put("userId",1);
		 _user.put("userName","Heylin");
		 _user.put("userStatus","1");
		
		return _user;
	}
}
