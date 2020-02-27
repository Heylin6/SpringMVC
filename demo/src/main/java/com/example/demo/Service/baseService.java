package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.demo.Model.Result;

public class baseService {
	
	protected List errMsgList = new ArrayList();		
	protected static String UPLOADED_FOLDER = "D://Github//SpringMVC//demo//uploadfiles//";
		
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
	
	public <T> Result setResult(Optional<T> _T, int statusCode, String message) {
		
		 Result _result = new Result();
		 
			_result.setdata(_T);
			_result.setcode(statusCode);
			_result.setmsg(message);
			
		 return _result;
	}
	
	public <T> Result setResultList(List<T> _TL, int statusCode, String message) {
		
		 Result _result = new Result();
		 
			_result.setdata(_TL);
			_result.setcode(statusCode);
			_result.setmsg(message);
			
		 return _result;
	}
}
