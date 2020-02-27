package com.example.demo.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Order;

/*
 * 
 * 資料表 order 是保留字
 * 
 * 查詢時要用 `order`
 * 
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{	
	

	@Query(value=
			  "select "
			+ "orderid,createuser,createtime,status,memo"
			+ " from `order`",nativeQuery = true)
	List<Order> findAll();
	
	@Query(value=
			  "select "
			+ "orderid,createuser,createtime,status,memo"
			+ " from `order` where orderid =?1" ,nativeQuery = true)
	Optional<Order> findByIdbyString(long orderId);	
}
