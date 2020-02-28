package com.example.demo.Model.ResPackage;

import java.util.List;

import com.example.demo.Model.Order;

public class ResultLOrders extends ResultL {
	
	private List<Order> Orders;	
	
	public List<Order> getOrders() {
		return Orders;
	}
	
	public void setOrders(List<Order> Orders) {		
		this.Orders = Orders;
	}

}
