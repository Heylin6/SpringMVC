package com.example.demo.Model.ResPackage;

import java.util.Optional;

import com.example.demo.Model.Order;

public class ResultOrder extends Result {
	
	private Optional<Order> Order;
	
	public Optional<Order> getOrder() {
		return Order;
	}
	
	public void setOrder(Optional<Order> Order) {		
		this.Order = Order;
	}
}
