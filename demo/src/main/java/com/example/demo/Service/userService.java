package com.example.demo.Service;

import java.util.List;
import java.util.Map;

import com.example.demo.Model.User;
import com.example.demo.Pagination.userPagination;

public class userService extends baseService{	

	public Integer SEV_addUser(Map sev_m) {
		
		try {
			
			//寫入新增邏輯
			
			return 1;
		}
		catch(Exception ex) {
			
	 		//寫入錯誤紀錄
	 		//
			
			return 99;
		}
	}
	
	public Integer SEV_modifyUser(Map sev_m) {
		
		try {
			
			//寫入更改邏輯
			
			return 1;
		}
		catch(Exception ex) {
			
	 		//寫入錯誤紀錄
	 		//
			
			return 99;
		}
	}

	public static Integer SEV_deleteUser(Map sev_m) {
		
		try {
			
			//寫入刪除邏輯
			
			return 1;
		}
		catch(Exception ex) {
			
	 		//寫入錯誤紀錄
	 		//
			
			return 99;
		}
	}

	public Map SEV_getUserList(Map busi_m) {
		
		try {
			Map res = null;
			
			//寫入撈取邏輯
			
			return res;
		}
		catch(Exception ex) {
			
	 		//寫入錯誤紀錄
	 		//
			
			return null;
		}
	}

	public Map SEV_getUserOne(Map busi_m) {
		
		try {
			Map res = null;
			
			//寫入撈取邏輯
			
			return res;
		}
		catch(Exception ex) {
			
	 		//寫入錯誤紀錄
	 		//
			
			return null;
		}
	}

	public List<User> getAllUserList() {
		// TODO Auto-generated method stub
		return null;
	}
}
