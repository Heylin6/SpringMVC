package com.example.demo.Model.ResPackage;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.demo.Model.Order;
import com.example.demo.Model.User;



public class ResultL extends Result {
	
	private Integer pagination;
		
	public Integer getPagination() {
		
		return pagination;
	}

	public void setPagination(Integer pagination) {
		
		this.pagination= pagination;
	}

}
