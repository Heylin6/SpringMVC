package com.example.demo.Model;

import java.sql.Date;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JwtUser {//implements UserDetails {
	
    private final String username;
    private final String password;

    public JwtUser(String username,String password) {
    	
		this.username = username;
    	this.password = password;
    }
    
//    @JsonIgnore
//    public Long getId() {
//        return id;
//    }

//    @Override
    public String getUsername() {
        return username;
    }
//
//    @JsonIgnore
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @JsonIgnore
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @JsonIgnore
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @JsonIgnore
//    @Override
    public String getPassword() {
        return password;
    }
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return false;
//	}


//    @JsonIgnore
//    public String getLastPasswordResetDate() {
//        return lastPasswordResetDate;
//    }
	
}
