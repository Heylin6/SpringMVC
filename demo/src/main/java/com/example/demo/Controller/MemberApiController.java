package com.example.demo.Controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Dao.MemberRepository;
import com.example.demo.Model.Member;
import com.example.demo.Model.Result;

@Controller
public class MemberApiController extends baseContoller {
	
	 @Autowired
	 MemberRepository memberRepository;
	
	 @RequestMapping(value={"/MemberApi/{mid}"},
			 produces={"application/json;charset=UTF-8"}, 
			 method = RequestMethod.GET)
	 @ResponseBody
	 public Optional<Member> getMember(@PathVariable long mid) {
		 	
		 return memberRepository.findById(mid);
	 }
	 
	 @PostMapping("/MemberApi/editMember")
	 public Result addMemberPage(Member member){

		 Result _result = new Result();

		 _result.setcode(200);
		 _result.setmsg("ok");
		 
	     return _result;
	 }
}
