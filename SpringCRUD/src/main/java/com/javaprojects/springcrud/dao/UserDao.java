package com.javaprojects.springcrud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.javaprojects.springcrud.bean.User;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/*public List<User> getUsers(){
		
		String sql = "SELECT * FROM USER";
	}*/
	
}