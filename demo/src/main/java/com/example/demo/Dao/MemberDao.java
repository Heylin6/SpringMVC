package com.example.demo.Dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.Model.Member;
import com.example.demo.Utilitylib.Directionarylib;

public class MemberDao {

	JdbcTemplate jdbcTemplate;
	
	public void addMember(Member member) {	
		
		System.out.println("EXCUTE INSERT MEMBER");
		  jdbcTemplate.update("INSERT INTO member(account,password,createTime,modifyTime,createMid,modifyMid,status) "
		  		+ "VALUES (?,?,NOW(),?,?,?,?)",
		  		member.getaccount(), member.getpassword(),"","","","",Directionarylib.Status_nouse);
	  }
	
}
