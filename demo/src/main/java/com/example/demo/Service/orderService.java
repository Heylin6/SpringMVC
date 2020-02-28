package com.example.demo.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.OrderRepository;
import com.example.demo.Model.Order;
import com.example.demo.Model.ResPackage.Result;
import com.example.demo.Model.ResPackage.ResultOrder;
import com.example.demo.Model.ResPackage.ResultLOrders;

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
	
	public ResultOrder setResultOrder(Optional<Order> _Order, 
			int statusCode, 
			String message,
			boolean issuccess) {
		
		 ResultOrder _result = new ResultOrder();
		 
			_result.setOrder(_Order);
			_result.setcode(statusCode);
			_result.setissuccess(issuccess);
			_result.setmsg(message);
			
		 return _result;
	}

	public ResultLOrders setResultOrderList(List<Order> _OrderL, 
			int statusCode, 
			String message,
			boolean issuccess) {
		
		 ResultLOrders _result = new ResultLOrders();
		 
			_result.setOrders(_OrderL);
			_result.setcode(statusCode);
			_result.setissuccess(issuccess);
			_result.setmsg(message);
			
		 return _result;
	}
}
