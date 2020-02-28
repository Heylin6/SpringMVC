package com.example.demo.Model.ResPackage;

import java.util.Optional;

import com.example.demo.Model.User;

public class ResultUser extends Result {

	private Optional<User> User;
	
	public Optional<User> getUser() {
		return User;
	}
	
	public void setUser(Optional<User> User) {		
		this.User = User;
	}
}
