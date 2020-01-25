package com.example.demo.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Business.userBusiness;
import com.example.demo.Common.UserInfo;
import com.example.demo.Model.Result;
import com.google.gson.Gson;

@RestController
@RequestMapping("/User")
public class userController extends baseContoller {

	Result result;
	userBusiness _userB = new userBusiness();
	
	 /** 
	  * 
	  * API : test
	  * 
	  **/
	 @RequestMapping(value={"/test"})
	 public Result test() {
		 
		 Result _result = new Result();
		 Map _user = _userB.test_setuser();
		 
		 _result.setdata(_user);
		 _result.setcode(200);
		 _result.setmsg("ok");
		 
	     return _result;
	 }
	 
	 /** 
	  * 
	  * API : Search userlist
	  * 
	  **/
	 @RequestMapping(value={"/"}, method = RequestMethod.GET)
	 @ResponseBody
	 public Map getUserList(HttpServletRequest req) {
		 	
		 	//init
		 	Map resMap = new HashMap();
		 	Gson gs = new Gson();
		 	
		 	//確認後台使用者資訊
		 	UserInfo _u = getuserInfo(req);
			String _jStr = req.getParameter("reqStr");
			Map ctr_m = gs.fromJson(_jStr, Map.class);
			
			resMap = _userB.BUSI_getUserList(ctr_m,_u);
			
			return resMap;
	 }
	 
	 /** 
	  * 
	  * API : Search one user
	  * 
	  **/
	 @RequestMapping(value={"/{userId}"}, method = RequestMethod.GET)
	 @ResponseBody
	 public Map getUser(HttpServletRequest req,Integer userId) {
		 	
		 	//init
		 	Map resMap = new HashMap();
		 	Gson gs = new Gson();
		 	
		 	//確認後台使用者資訊
		 	UserInfo _u = getuserInfo(req);
			String _jStr = req.getParameter("reqStr");
			Map ctr_m = gs.fromJson(_jStr, Map.class);
			
			resMap = _userB.BUSI_getUser(ctr_m,_u,userId);
	        
	        return resMap;
	 }
	 
	 /** 
	  * 
	  * API : insert user
	  * 
	  **/
	 @RequestMapping(value={"/"}, method = RequestMethod.POST)
	 @ResponseBody
	 public Map addUser(HttpServletRequest req){
		 	
		 	//init
		 	Map resMap = new HashMap();
		 	Gson gs = new Gson();
		 	
		 	//確認後台使用者資訊
		 	UserInfo _u = getuserInfo(req);		 	
			String _jStr = req.getParameter("reqStr");
			Map ctr_m = gs.fromJson(_jStr, Map.class);
		 	
		 	resMap = _userB.BUSI_addUser(ctr_m,_u);

	        return resMap;
	 }
	 
	 /** 
	  * 
	  * API : modify user
	  * 
	  **/
	 @RequestMapping(value={"/{userId}"}, method = RequestMethod.PUT)
	 @ResponseBody
	 public Map modifyUserPut(HttpServletRequest req){
		 	
		 	//init
		 	Map resMap = new HashMap();
		 	Gson gs = new Gson();
		 	
		 	//確認後台使用者資訊
		 	UserInfo _u = getuserInfo(req);		 	
			String jsonStr = req.getParameter("reqStr");
			Map ctr_m = gs.fromJson(jsonStr, Map.class);
		 	
		 	resMap = _userB.BUSI_modifyUser(ctr_m,_u);

	        return resMap;
	 }
	 
	 /** 
	  * 
	  * API : modify user
	  * 
	  **/
	 @RequestMapping(value={"/{userId}"}, method = RequestMethod.PATCH)
	 @ResponseBody
	 public Map modifyUserPatch(HttpServletRequest req){
		 	
		 	//init
		 	Map resMap = new HashMap();
		 	Gson gs = new Gson();
		 	
		 	//確認後台使用者資訊
		 	UserInfo _u = getuserInfo(req);		 	
			String _jStr = req.getParameter("reqStr");
			Map ctr_m = gs.fromJson(_jStr, Map.class);
		 	
		 	resMap = _userB.BUSI_modifyUser(ctr_m,_u);

	        return resMap;
	 }
	 
	 /** 
	  * 
	  * API : delete user
	  * 
	  **/
	 @RequestMapping(value={"/{userId}"}, method = RequestMethod.DELETE)
	 @ResponseBody
	 public Map deleteUser(HttpServletRequest req,Integer userId) {
		
		 	//init
		 	Map resMap = new HashMap();
		 	Gson gs = new Gson();
		 	
		 	//確認後台使用者資訊
		 	UserInfo _u = getuserInfo(req);
		 	String _jStr = req.getParameter("reqStr");
			Map ctr_m = gs.fromJson(_jStr, Map.class);
			
		 	resMap = _userB.BUSI_deleteUser(ctr_m,userId,_u);
	        
	        return resMap;
	 }
}
