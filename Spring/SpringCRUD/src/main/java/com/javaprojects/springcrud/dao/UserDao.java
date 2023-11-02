package com.javaprojects.springcrud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.javaprojects.springcrud.dao.mapper.UserMapper;
import com.javaprojects.springcrud.bean.User;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate; // Creates connection automatically with the help of @Autowired
	
	public List<User> getUsers(){
		
		String sql = "SELECT * FROM USER";
		
		return this.jdbcTemplate.query(sql, new UserMapper());
	}

	public int createUser(User user) {
	    String sql = "INSERT INTO USER (USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, BIRTH, STATUS) VALUES (?, ?, ?, ?, ?, ?)";
	    int rows = jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getFirstName(),
	                  						user.getLastName(), user.getBirth(), user.getStatus());
	    
	    return rows;
	}

}