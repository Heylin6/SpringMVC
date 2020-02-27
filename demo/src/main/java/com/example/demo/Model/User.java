package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.sun.istack.NotNull;

@Entity
@Table(name = "user")
public class User implements java.io.Serializable { 
	
	public User() {
		
	}
	
	@Id
	@Column(name = "userid")
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "user_seq")
	private long userId;
	
	@Column(name="username")
	@NotNull
    @Size(min = 4, max = 20)
	private String userName;
	
	@Column(name="password")
	@NotNull
	@Size(min = 6, max = 300)
    private String password;
	
	@Column(name="createtime")
	private String createTime;
	
	@Column(name="status")
	private String userStatus;
	
	public User(long userId, String userName, String userStatus) {
		
		this.userId = userId;
		this.userName = userName;
		this.userStatus = userStatus;
	}
	
	public long getuserId() {
		return userId;
	}
	
	public void setuserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getuserName() {
		return userName;
	}
	
	public void setuserName(String userName) {
		this.userName = userName;
	}
	
	public String getpassword() {
		return password;
	}
	
	public void setpassword(String password) {
		this.password = password;
	}
	
	public String getcreateTime() {
		return createTime;
	}
	
	public void setcreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public String getuserStatus() {
		return userStatus;
	}
	
	public void setuserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
}
