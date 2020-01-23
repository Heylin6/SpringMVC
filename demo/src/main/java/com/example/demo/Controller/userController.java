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

import com.example.demo.Business.userBusiness;
import com.example.demo.Common.UserInfo;
import com.google.gson.Gson;

@Controller
@RequestMapping("/User")
public class userController extends baseContoller {

	userBusiness _userB = new userBusiness();	
	
	 /** 
	  * 
	  * API : test
	  * 
	  **/
	 @RequestMapping("/")
	 public String test(@RequestParam(value="title", required=false, defaultValue="Heylin") String title, Model model) {
		 	        
	        return "testing ,Page: User";
	 }
	 
	 /** 
	  * 
	  * API : Search userlist
	  * 
	  **/
	 @RequestMapping(value={"/search"}, method = RequestMethod.GET)
	 @ResponseBody
	 public Map getUserList(HttpServletRequest req) {
		 	
		 	//init
		 	Map resMap = new HashMap();
		 	Gson gs = new Gson();
		 	
		 	//確認後台使用者資訊
		 	UserInfo _u = getuserInfo(req);
			String _jStr = req.getParameter("reqStr");
			Map ctr_m = gs.fromJson(_jStr, Map.class);
			
			resMap = _userB.BUSI_getUser(ctr_m,_u);
			
			return resMap;
	 }
	 
	 /** 
	  * 
	  * API : Search one user
	  * 
	  **/
	 @RequestMapping(value={"/search"}, method = RequestMethod.GET)
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
	 @RequestMapping(value={"/add"}, method = RequestMethod.POST)
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
	 @RequestMapping(value={"/modify"}, method = RequestMethod.PUT)
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
	 @RequestMapping(value={"/modify"}, method = RequestMethod.PATCH)
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
	 @RequestMapping(value={"/delete"}, method = RequestMethod.DELETE)
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
