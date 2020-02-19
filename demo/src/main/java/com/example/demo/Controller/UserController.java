package com.example.demo.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Result;
import com.example.demo.Model.User;
import com.example.demo.Service.userService;
import com.google.gson.Gson;

/**
 * 	寫法 : 請求 HttpServletRequest 轉成json解析
 */

@RestController
@RequestMapping("/User")
public class UserController extends baseContoller {

	Result result;	
	
	 /** 
	  * 
	  * API : test
	  * 
	  **/
	 @GetMapping("/test")	
	 public Result test() {
		 
		 Result _result = new Result();
		 Map _user = null;
		 
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
	 @GetMapping("/")
	 public Map getAllUserList(HttpServletRequest req) {
		 	
		 	//init
		 	Map resMap = new HashMap();
		 	Gson gs = new Gson();
		 	
		 	
			return resMap;
	 }
	 
	 /** 
	  * 
	  * API : Search one user
	  * 
	  **/
	 @GetMapping("/{userId}")
	 public Map getUser(@PathVariable("userId") Long userId,HttpServletRequest req) {
		 	
		 	//init
		 	Map resMap = new HashMap();
		 	Gson gs = new Gson();
		 	
	        
	        return resMap;
	 }
	 
	 /** 
	  * 
	  * API : insert user
	  * 
	  **/
	 @PostMapping("/")
	 public Map addUser(User _user){
		 	
		 	//init
		 	Map resMap = new HashMap();
		 	Gson gs = new Gson();


	        return resMap;
	 }
	 
	 /** 
	  * 
	  * API : modify user
	  * 
	  **/
	 @PutMapping("/{userId}")	 
	 public Map modifyUserPut(HttpServletRequest req) {
		 	
		 	//init
		 	Map resMap = new HashMap();
		 	Gson gs = new Gson();
		 	

	        return resMap;
	 }
	 
	 /** 
	  * 
	  * API : modify user
	  * 
	  **/
	 @PatchMapping("/{userId}")
	 public Map modifyUserPatch(HttpServletRequest req) {
		 	
		 	//init
		 	Map resMap = new HashMap();
		 	Gson gs = new Gson();
	        return resMap;
	 }
	 
	 /** 
	  * 
	  * API : delete user
	  * 
	  **/
	 @DeleteMapping("/{userId}")
	 public Map deleteUser(HttpServletRequest req) {
		
		 	//init
		 	Map resMap = new HashMap();
		 	Gson gs = new Gson();
		 	
	        
	        return resMap;
	 }
}
