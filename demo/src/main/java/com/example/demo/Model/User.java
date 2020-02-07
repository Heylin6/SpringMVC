package com.example.demo.Model;

import javax.persistence.Id;

import org.springframework.stereotype.Component;


public class User implements java.io.Serializable { 
	
	@Id	
	private long userId;
	
	private String userName;
	
	private String createTime;
	
	private String userStatus;
	
	public User(long userId, String userName, String userStatus) {
		this.userId = userId;
		this.userName = userName;
		this.userStatus = userStatus;
	}
	
	
	
	public long getuserId() {
		return userId;
	}
	
	public void setuserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getuserName() {
		return userName;
	}
	
	public void setuserName(String userName) {
		this.userName = userName;
	}
	
	public String getcreateTime() {
		return createTime;
	}
	
	public void setcreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public String getuserStatus() {
		return userStatus;
	}
	
	public void setuserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
}
