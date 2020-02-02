package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	//用MySQL 或 MariaDB 可註解掉 => MySQL中並沒有Sequence,MySQL可以裡直接設定ID的AI就能使用了
	private long OrderId;
	
	private String createMember;
	
	private String createTime;
	
	private String status;
	
	public Order() {
	}
}
