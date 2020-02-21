package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Dao.MemberRepository;
import com.example.demo.Model.AuthenticationResponse;
import com.example.demo.Model.JwtUser;
import com.example.demo.Model.Member;
import com.example.demo.Service.JwtAuthenticationService;
import com.example.demo.Service.jwtuserdetailsService;
import com.example.demo.Service.memberService;
import com.example.demo.Setting.JwtTokenConfig;

@Controller
public class MemberController extends baseContoller {
	
	@Value("${jwt.header}")
    private String tokenHeader;

	@Autowired
	private AuthenticationManager authenticationManager;

	
	@Autowired
	private JwtTokenConfig _JwtTokenConfig;
	
	@Autowired
	private JwtAuthenticationService _JwtAuthenticationService;
	
	@Autowired
    private UserDetailsService jwtuserdetailsService;
	
	@Autowired
	MemberRepository memberRepository;
	
	//@Autowired
	//這個註解掉 Maven test就過了 我也不懂
	memberService _memberService;
	
	@GetMapping("/login")
    public String login(@ModelAttribute Member member){

        return "login";
    }	
	
	/*
	 * => 登入 
	 * 
	 * HttpServletResponse 放進 jwt
	 * session 存進 radis
	 * 
	 * */
	@PostMapping("/doLogin")
    public String doLogin(@ModelAttribute Member member,
    						HttpServletResponse res,
    						HttpSession session,
    						Model model)
    throws Exception {
		
		String _UsName = member.getaccount();
		String _Paword = member.getpassword();
		
		if(_JwtAuthenticationService.hasThisuser(_UsName,_Paword))
		{
			_JwtAuthenticationService.authenticate(_UsName,_Paword);
			
			final UserDetails userDetails = jwtuserdetailsService
					.loadUserByUsername(_UsName);
			final String jwt = _JwtTokenConfig.generateToken(userDetails);
			
			res.setHeader("Authorization", jwt);
			
			model.addAttribute("test_yourToken", jwt);
			
			return "welcome";
		}
		else{
			
			model.addAttribute("loginError", true);
			return "login";	        
		}
    }
	
	@GetMapping("/logout")
    public String Logout(HttpSession session){
		
		if(session.getAttribute("uid")!=null){
		  	session.removeAttribute("uid");
		}
		
        return "login";
    }
	
	//@PreAuthorize("hasRole('USER')")
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
