package com.example.demo.Setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.example.demo.Service.jwtuserdetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	@Autowired
	private jwtuserdetailsService jwtUserDetailsService;
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	
		// configure AuthenticationManager so that it knows from where to load
		// user for matching credentials
		// Use BCryptPasswordEncoder
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
	
		return super.authenticationManagerBean();
	}
	
    /**
     *_ 靜態資源訪問設定
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
	       .ignoring().antMatchers("/vendor/**")
	       .and()
           .ignoring().antMatchers("/css/**")
           .and()
           .ignoring().antMatchers("/js/**")
           .and()
           .ignoring().antMatchers("/images/**")
           .and()
           .ignoring().antMatchers("/favicon.ico");
    }
	
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity
		.authorizeRequests()
		//允許所有使用者訪問以下
		.antMatchers("/authenticate","/login","/doLogin","/logout","/login-error","/Chat","/Order/test")
		.permitAll()
		//其他請求需登入才可訪問。     
        .anyRequest().authenticated()    
        .and()
        .csrf().disable().sessionManagement() // 停用防跨域攻擊(測試階段停用，不推薦)
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		httpSecurity
		.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
//	public PasswordEncoder passwordEncoder() {
//		
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}
//	

	@SuppressWarnings("deprecation")
	public PasswordEncoder passwordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
	}
}
