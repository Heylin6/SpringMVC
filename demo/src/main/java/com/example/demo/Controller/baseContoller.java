package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.Model.Result;


public abstract class baseContoller {

	public Result setTestFeedback() {
		
		Result _result = new Result();
		Map _user = null;
		 
		_result.setdata(_user);
		_result.setcode(200);
		_result.setmsg("ok");
		 
		return _result;
	}
}
