package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.Model.ResPackage.Result;


public abstract class baseContoller {

	public Result setTestResult() {
		
		Result _result = new Result();
		 
		_result.setissuccess(true);
		_result.setcode(200);
		_result.setmsg("ok");
		 
		return _result;
	}
}
