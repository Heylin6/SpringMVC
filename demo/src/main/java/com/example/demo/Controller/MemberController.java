package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Dao.MemberRepository;
import com.example.demo.Model.Member;
import com.example.demo.Service.memberService;

@Controller
public class MemberController extends baseContoller {
	
	@Autowired
	MemberRepository memberRepository;
	
	//@Autowired
	//這個註解掉 Maven test就過了 我也不懂
	memberService _memberService;
	
	@GetMapping("/login")
    public String login(@ModelAttribute Member member){

        return "login";
    }
	
	@PostMapping("/doLogin")
    public String doLogin(@ModelAttribute Member member,HttpSession session){
		
		String _account = member.getaccount();
		String _password = member.getpassword();
		
		List<Member> _memberlist = new ArrayList<Member>();
		_memberlist = memberRepository.findCheckMemberAccount(_account, _password);
		
		session.setAttribute("uid", member);
		
		Member _member = new  Member();
		_member.setpassword(_password);
		_member.setaccount(_account);

		if(_memberlist.size()==0){
			return "login";
		}
		else{
			session.setAttribute("uid", _member);
			System.out.println(session.getId());
	        return "welcome";
		}
    }
	
	@GetMapping("/logout")
    public String Logout(HttpSession session){
		
		if(session.getAttribute("uid")!=null){
		  	session.removeAttribute("uid");
		}
		
        return "login";
    }
	
	@GetMapping("/addMemberPage")
    public String addMemberPage(){
//    	memberAccount = new MemberAccount();
//    	memberService.addMember(memberAccount);

        return "addMemberPage";
    }
	
	 /** 
	  * 
	  * API : Search one order
	  * 
	  **/
	 @RequestMapping(value={"/Member/{mid}"},produces={"application/json;charset=UTF-8"}, method = RequestMethod.GET)
	 @ResponseBody
	 public Optional<Member> getMember(@PathVariable long mid) {
		 	
		 return memberRepository.findById(mid);
	 }
}
