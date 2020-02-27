package com.example.demo.Dao;

import org.springframework.stereotype.Repository;

import com.example.demo.Model.User;
import com.example.demo.Utilitylib.Directionarylib;

@Repository
public class UserDao extends baseDao{
	
	public void addUser(User user) {	
		
		System.out.println("EXCUTE INSERT user");
		  jdbcTemplate.update("INSERT INTO user(username,password,createtime,status) "
		  		+ "VALUES (?,?,NOW(),?)",
		  		user.getuserName(), user.getpassword(),Directionarylib.Status_nouse);
	}	
}
