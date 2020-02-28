package com.example.demo.Model.ResPackage;

import java.util.List;

import com.example.demo.Model.User;

public class ResultUsers extends Result {
	
	private List<User> Users;	
	
	public List<User> getUsers() {
		return Users;
	}
	
	public void setUsers(List<User> Users) {		
		this.Users = Users;
	}	
}
