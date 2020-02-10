package com.example.demo.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Member;
import com.example.demo.Utilitylib.Directionarylib;

@Repository
public class MemberDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void addMember(Member member) {	
		
		System.out.println("EXCUTE INSERT MEMBER");
		  jdbcTemplate.update("INSERT INTO member(account,password,createTime,modifyTime,createMid,modifyMid,status) "
		  		+ "VALUES (?,?,NOW(),?,?,?,?)",
		  		member.getaccount(), member.getpassword(),"","","","",Directionarylib.Status_nouse);
	  }
	
}
