package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

import com.example.demo.Dao.UserRepository;
import com.example.demo.Model.User;
import com.example.demo.Model.ResPackage.Result;
import com.example.demo.Model.ResPackage.ResultUser;
import com.example.demo.Service.userService;
import com.google.gson.Gson;

/**
 * 	
 */

@RestController
@RequestMapping("/UserApi")
public class UserApiController extends baseContoller {

	@Autowired
	private userService userS;
	
	 /** 
	  * 
	  * API : test
	  * 
	  **/
	 @GetMapping("/test")	
	 public Result test() {
		 
		 return setTestResult();
	 }
	 
	 /** 
	  * 
	  * API : Search userlist
	  * 
	  **/
	 @RequestMapping(value={"/","/all"},
			 produces={"application/json;charset=UTF-8"}, 
			 method = RequestMethod.GET)
	 @ResponseBody
	 public Result getAllUserList() {		
	
		Result res = null;
		List<User> _userL = userS.getAllUserList();
		if(_userL.size()>0)
		{
			res = userS.setResultUserList(_userL,200,"ok",true);
			return res;
		}
		else
		{
			res = userS.setResultUserList(null,99,"no data",false);
			return res;
		}
	 }
	 
	 /** 
	  * 
	  * API : Search one user
	  * 
	  **/
	 @GetMapping("/{userId}")
	 public ResultUser getUser(@PathVariable("userId") Long userId,HttpServletRequest req) {
		 	
		 	//init
		 	ResultUser res = null;
		 	Optional<User> _user = userS.getUser(userId);
			if(_user != null)
			{
				res = userS.setResultUser(_user,200,"ok",true);
				return res;
			}
			else
			{
				res = userS.setResultUser(null,99,"no data",false);
				return res;
			}	
	 }
	 
	 /** 
	  * 
	  * API : insert user
	  * 
	  **/
	 @PostMapping("/")
	 public Result addUser(User _user){
		 	
		 Result res = null;
		 userS.save(_user);
		 
		 res = userS.setResult(null,200,"has save");
		 return res;
	 }
	 
	 /** 
	  * 
	  * API : modify user
	  * 
	  **/
	 @PutMapping("/{userId}")	 
	 public Result modifyUserPut(User _user) {
		 	
		 Result res = null;
		 userS.modify(_user);	
		 
		 res = userS.setResult(null,200,"has modify");
		 return res;
	 }
	 
	 /** 
	  * 
	  * API : modify user
	  * 
	  **/
	 @PatchMapping("/{userId}")
	 public Result modifyUserPatch(User _user) {
		 	
		 Result res = null;
		 userS.modify(_user);	
		 
		 res = userS.setResult(null,200,"has modify");
		 return res;
	 }
	 
	 /** 
	  * 
	  * API : delete user
	  * 
	  **/
	 @DeleteMapping("/{userId}")
	 public Result deleteUser(long userId) {
		
		 Result res = null;
		 userS.delete(userId);		 
		 
		 res = userS.setResult(null,200,"delete ok");
		 return res;
	 }
}
