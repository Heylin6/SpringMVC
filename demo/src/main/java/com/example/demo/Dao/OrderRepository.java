package com.example.demo.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
	List<Order> findAll();	
}
