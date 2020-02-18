package com.example.demo.Setting;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.Service.jwtuserdetailsService;
import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	
	@Autowired
	private jwtuserdetailsService jwtUserDetailsService;
	
	@Autowired
	private JwtTokenConfig jwtTokenConfig;
	
	@Override
	protected void doFilterInternal(
			HttpServletRequest request, HttpServletResponse response, FilterChain chain)
	throws ServletException, IOException {
		
		final String authorizationHeader = request.getHeader("Authorization");
		
		String username = null;
		String jwt = null;
		// JWT Token is in the form "heylin token". Remove Bearer word and get
		// only the Token
		// && authorizationHeader.startsWith("heylin ")
		//jwt = authorizationHeader.substring(7);
		if (authorizationHeader != null) {		
			
			try {
				
				jwt = authorizationHeader;
				username = jwtTokenConfig.extractUsername(jwt);
				
			} catch (IllegalArgumentException e) {
				
				System.out.println("Unable to get JWT Token");
			} catch (ExpiredJwtException e) {
				
				System.out.println("JWT Token has expired");
			}			
		} 
		else {
			
			logger.warn("JWT Token does not begin");
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			
			UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);

			if (jwtTokenConfig.validateToken(jwt, userDetails)) {
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken 
					= new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
							usernamePasswordAuthenticationToken
							.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
							
				SecurityContextHolder
					.getContext()
					.setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		chain.doFilter(request, response);
	}
}
