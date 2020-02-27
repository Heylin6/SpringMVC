package com.example.demo.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"order\"")
public class Order implements Serializable {

	public Order() {
		
	}
	
	@Id
	@Column(name = "orderid")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	//用MySQL 或 MariaDB 可註解掉 => MySQL中並沒有Sequence,MySQL可以裡直接設定ID的AI就能使用了
	private long OrderId;
	
	@Column(name="createuser")
	private String createUser;
	
	@Column(name="createtime")
	private String createTime;
	
	@Column(name="\"status\"")
	private String status;	
	
	@Column(name="memo")
	private String memo;
	
	public long getOrderId() {
		return OrderId;
	}
	
	public void setCOrderId(long OrderId) {
		this.OrderId = OrderId;
	}
	
	public String getCreateUser() {
		return createTime;
	}
	
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
	public String getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
		
	public String getMemo() {
		return memo;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}
}
