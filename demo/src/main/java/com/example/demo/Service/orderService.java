package com.example.demo.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.OrderRepository;
import com.example.demo.Model.Order;
import com.example.demo.Model.Result;

@Service
public class orderService extends baseService { 
	
	@Autowired
	OrderRepository orderRepository;
	
	public Map test_setorder() {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Order order) {
		
		orderRepository.save(order);		
	}
	
	public void modify(Order order) {
		
		orderRepository.save(order);		
	}

	public List<Order> getAllOrderList() {
		
		return orderRepository.findAll();
	}
	
	public Optional<Order> getOrder(long orderId) {
		
		return orderRepository.findById(orderId);
	}

	public void delete(long orderId) {
		
		orderRepository.deleteById(orderId);		
	}


}
