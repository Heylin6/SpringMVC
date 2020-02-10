package com.example.demo.Controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dao.MemberRepository;
import com.example.demo.Model.Member;
import com.example.demo.Model.Result;

//重複了 之後要改其他TABLE

@RestController
@RequestMapping("/MemberApi")
public class MemberApiController extends baseContoller {
	
	@Autowired
	MemberRepository memberRepository;
	
	 /** 
	  * 
	  * API : test
	  * 
	  **/
	 @RequestMapping(value={"/test"})
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
	  * API : Search one order
	  * 
	  **/
	 @RequestMapping(value={"/{mid}"},produces={"application/json;charset=UTF-8"}, method = RequestMethod.GET)
	 @ResponseBody
	 public Optional<Member> getMember(@PathVariable long mid) {
		 	
		 return memberRepository.findById(mid);
	 }
}
