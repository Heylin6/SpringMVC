package com.example.demo.Model.ResPackage;

import java.util.List;

import com.example.demo.Model.User;

public class ResultLUsers extends ResultL {
	
	private List<User> Users;	
	
	public List<User> getUsers() {
		return Users;
	}
	
	public void setUsers(List<User> Users) {		
		this.Users = Users;
	}	
}
