package com.example.demo.Model.ResPackage;

import java.util.List;

public class ResultData<T> extends Result {
	
	private T TRes;	
	
	private List<T> TResList;
	
	public void setdata(T TRes) {		
		this.TRes = TRes;
	}
	
	public void setdata(List<T> TList) {		
		this.TResList = TList;
	}
}
