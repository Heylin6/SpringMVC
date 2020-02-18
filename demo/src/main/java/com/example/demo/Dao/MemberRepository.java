package com.example.demo.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
	
	List<Member> findAll();	
	
	@Query(value="select mid,account,password,createtime,modifytime"
			+ ",createmid,modifymid,status,lastlogintime"
			+ " from member where account = ?1" ,nativeQuery = true)
	Member findByAccount(String account);
	
	@Query(value="select mid,account,password,createtime,modifytime"
			+ ",createmid,modifymid,status,lastlogintime"
			+ " from member where account = ?1 and password = ?2 " ,nativeQuery = true)
	Member findByAccountWithPassword(String account,String password);
	
	@Query(value="select mid,account,password,createtime,modifytime"
			+ ",createmid,modifymid,status,lastlogintime"
			+ " from member where account = ?1 and password = ?2 " ,nativeQuery = true)
	List<Member> findCheckMemberAccount(String account,String password);


}
