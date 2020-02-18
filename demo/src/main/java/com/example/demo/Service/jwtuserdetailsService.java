package com.example.demo.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.MemberRepository;
import com.example.demo.Model.Member;

@Service
public class jwtuserdetailsService implements UserDetailsService {
	
	@Autowired
    private MemberRepository _memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Member _member = _memberRepository.findByAccount(username);
        if (_member == null) {
        	
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
        	
            return new User(_member.getaccount(),
            				_member.getpassword(),
            				new ArrayList<>());
        }
    }
	
	//@Override
	//public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	//		
	//		return new User("Heylin","790409",new ArrayList<>());
	//}

}
