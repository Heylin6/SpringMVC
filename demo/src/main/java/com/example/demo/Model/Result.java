package com.example.demo.Model;

import java.util.List;
import java.util.Map;



public class Result<T> {
	
	private Integer code;
	
	private String msg;
	
	private Map data;
	
	private T TRes;
	
	private List<T> TResList;	
	
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
	
	public Map getdata() {
		return data;
	}
	
	public void setdata(Map data) {
		this.data = data;
	}
	
	public void setdata(T TRes) {		
		this.TRes = TRes;
	}
	
	public void setdata(List<T> TList) {		
		this.TResList = TList;
	}	
	
}
