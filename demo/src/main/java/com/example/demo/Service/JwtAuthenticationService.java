package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.MemberRepository;
import com.example.demo.Model.Member;

@Service
public class JwtAuthenticationService extends baseService { 

	@Autowired
    private MemberRepository _memberRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	public boolean hasThisuser(String username , String password) {
		
		Member _member = _memberRepository.findByAccountWithPassword(username,password);
		return _member == null ? false : true;
	}
	
	public void authenticate(String username, String password) throws Exception {
		
		try {
			authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} 
		catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} 
		catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
