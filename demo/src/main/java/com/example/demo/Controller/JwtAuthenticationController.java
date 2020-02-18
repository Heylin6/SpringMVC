package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dao.MemberRepository;
import com.example.demo.Model.AuthenticationResponse;
import com.example.demo.Model.JwtUser;
import com.example.demo.Model.Member;
import com.example.demo.Model.Result;
import com.example.demo.Service.JwtAuthenticationService;
import com.example.demo.Service.jwtuserdetailsService;
import com.example.demo.Setting.JwtTokenConfig;


@RestController
@CrossOrigin
public class JwtAuthenticationController extends baseContoller {
	
	@Autowired
	private JwtTokenConfig _JwtTokenConfig;
	
	@Autowired
	private JwtAuthenticationService _JwtAuthenticationBusiness;

	@Autowired
    private UserDetailsService jwtuserdetailsService;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtUser authenticationRequest) 
	throws Exception {
		
		String _UsName = authenticationRequest.getUsername();
		String _Paword = authenticationRequest.getPassword();
		
		if(_JwtAuthenticationBusiness.hasThisuser(_UsName,_Paword))
		{
			_JwtAuthenticationBusiness.authenticate(_UsName,_Paword);
			
			final UserDetails userDetails = jwtuserdetailsService
					.loadUserByUsername(_UsName);
			final String jwt = _JwtTokenConfig.generateToken(userDetails);
			
			return ResponseEntity.ok(new AuthenticationResponse(jwt));
		}
		else
		{
			return (ResponseEntity<?>) ResponseEntity.notFound();
		}
	}
	



}
