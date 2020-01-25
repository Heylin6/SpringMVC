package com.example.demo.Service;

import java.util.List;
import java.util.Map;

public class baseService {
	
	public String setWhere(List<Map<String,String>> _condition) {
		
		String res ="";
		
		if(_condition.size()>0)
		{
			res +=" where ";
		}
		
		return null;
	}
	
	public Map getPagination() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map getPagination(List<Map<String,String>> _condition) {
		return null;
	}
	
	public Map getPagination(List<Map<String,String>> _condition,int _page) {		
		return null;
	}



}
