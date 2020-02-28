package com.example.demo.Model.ResPackage;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.demo.Model.Order;
import com.example.demo.Model.User;



public class Result {
	
	private Integer code;
	
	private String msg;
	
	private Boolean issuccess;
	
	public Integer getcode() {
		return code;
	}
	
	public void setcode(Integer code) {
		this.code = code;
	}
	
	public String getmsg() {
		return msg;
	}
	
	public void setmsg(String msg) {
		this.msg = msg;
	}
	
	public Boolean getissuccess() {
		return issuccess;
	}
	
	public void setissuccess(Boolean issuccess) {
		this.issuccess = issuccess;
	}
	

}
