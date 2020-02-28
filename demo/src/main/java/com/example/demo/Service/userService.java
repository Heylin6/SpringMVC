package com.example.demo.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.UserRepository;
import com.example.demo.Model.User;
import com.example.demo.Model.ResPackage.ResultLUsers;
import com.example.demo.Model.ResPackage.ResultUser;

@Service
public class userService extends baseService {
	
	@Autowired
	UserRepository userRepository;	

	public void save(User user) {
		
		userRepository.save(user);		
	}
	
	public void modify(User user) {
		
		userRepository.save(user);		
	}

	public List<User> getAllUserList() {
		
		return userRepository.findAll();
	}
	
	public Optional<User> getUser(long userId) {
		
		return userRepository.findById(userId);
	}

	public void delete(long useerId) {
		
		userRepository.deleteById(useerId);		
	}
	
	public ResultUser setResultUser(Optional<User> _user,
			int statusCode,
			String message,
			boolean issuccess) {
		
		ResultUser _result = new ResultUser();
		 
		_result.setUser(_user);
		_result.setcode(statusCode);
		_result.setissuccess(issuccess);
		_result.setmsg(message);
			
		return _result;
	}

	public ResultLUsers setResultUserList(List<User> _userL,
			int statusCode,
			String message,
			boolean issuccess) {
		
		ResultLUsers _result = new ResultLUsers();
		 
		_result.setUsers(_userL);
		_result.setcode(statusCode);
		_result.setissuccess(issuccess);
		_result.setmsg(message);
		
		return _result;
	}
}
