package com.example.demo.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import java.util.List;

@Entity
@Table(name = "member")
public class Member implements Serializable {

	public Member() {
		
	}
	
	@Id
	@Column(name = "mid")
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "member_seq")
	@SequenceGenerator(name = "member_seq", sequenceName = "member_seq", allocationSize = 1)
	private long mid;
	
	@Column(name="account")
	@NotNull
    @Size(min = 4, max = 50)
	private String account;
	
	@Column(name="password")
	@NotNull
    @Size(min = 10, max = 200)
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
	
	@Column(name="lastlogintime")
	private String lastlogintime;
	
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "authority",
//            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "mid")},
//            inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "aid")})
//    private List<Authority> authorities;

	public Member(String username, String password) {
	
		this.setaccount(username);
		this.setpassword(password);
	}

	
	
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
	
	public boolean getstatusforbool() {
		return status == "1" ? true:false;
	}
	
	public void setstatus(String status) {
		this.status = status;
	}	

//    public List<Authority> getAuthorities() {
//        return authorities;
//    }
//
//    public void setAuthorities(List authorities) {
//        this.authorities = authorities;
//    }
    
	public String getlastlogintime() {
		return lastlogintime;
	}
	
	public void setlastlogintime(String lastlogintime) {
		this.lastlogintime = lastlogintime;
	}
}
