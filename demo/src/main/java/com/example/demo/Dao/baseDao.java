package com.example.demo.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class baseDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
}
