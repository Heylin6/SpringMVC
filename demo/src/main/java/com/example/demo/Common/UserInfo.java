package com.example.demo.Common;

import java.io.Serializable;

public class UserInfo implements Serializable {

	private Integer userId;
	
	private String userName;
	
	private String userStatus;
	
	
	
	public Integer getuserId() {
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
	
	public String getuserStatus() {
		return userStatus;
	}
	
	public void setuserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
}
