package com.example.demo.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query(value=
			  "select "
			+ "userid,username,createtime,status"
			+ " from user" ,nativeQuery = true)	
	List<User> findAll();
}
