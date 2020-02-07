package com.example.demo.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class Member implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long mid;
	
	@Column(name="account")
	private String account;
	
	@Column(name="password")
	private String password;
	
	@Column(name="createtime")
	private String createtime;
	
	@Column(name="modifytime")
	private String modifytime;
	
	@Column(name="createmid")
	private String createmid;
	
	@Column(name="modifymid")
	private String modifymid;
	
	@Column(name="status")
	private String status;
	
	public long getmid() {
		return mid;
	}
	
	public void setmid(long mid) {
		this.mid = mid;
	}
	
	public String getaccount() {
		return account;
	}
	
	public void setaccount(String account) {
		this.account = account;
	}
	
	public String getpassword() {
		return password;
	}
	
	public void setpassword(String password) {
		this.password = password;
	}
	
	public String getcreatetime() {
		return createtime;
	}
	
	public void setcreatetime(String createtime) {
		this.createtime = createtime;
	}
	
	public String getmodifyTime() {
		return modifytime;
	}
	
	public void setmodifyTime(String modifytime) {
		this.modifytime = modifytime;
	}
	
	public String getcreatemid() {
		return createmid;
	}
	
	public void setcreatemid(String createmid) {
		this.createmid = createmid;
	}	
	
	public String getmodifymid() {
		return modifymid;
	}
	
	public void setmodifymid(String modifymid) {
		this.modifymid = modifymid;
	}
	
	public String getstatus() {
		return status;
	}
	
	public void setstatus(String status) {
		this.status = status;
	}	
}
