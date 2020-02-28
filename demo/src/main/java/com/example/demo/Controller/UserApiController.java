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
import com.example.demo.Service.userService;
import com.google.gson.Gson;

/**
 * 	寫法 : 請求 HttpServletRequest 轉成json解析
 */

@RestController
@Controller
@RequestMapping("/UserApi")
public class UserApiController extends baseContoller {
	
	@Autowired
	UserRepository userRepository;
	
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
		if(_userL != null)
		{
			res = userS.setResultList(_userL,200,"ok");
			return res;
		}
		else
		{
			res = userS.setResultList(null,99,"no data");
			return res;
		}
	 }
	 
	 /** 
	  * 
	  * API : Search one user
	  * 
	  **/
	 @GetMapping("/{userId}")
	 public Result getUser(@PathVariable("userId") Long userId,HttpServletRequest req) {
		 	
		 	//init
		 	Result _result = new Result();
		 	Optional<User> _user = userRepository.findById(userId);
		 
			_result.setissuccess(true);
			_result.setcode(200);
			_result.setmsg("ok");		 	
		 	
			return _result;
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
