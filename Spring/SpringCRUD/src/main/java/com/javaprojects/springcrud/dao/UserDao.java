package com.javaprojects.springcrud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.javaprojects.springcrud.dao.mapper.UserMapper;
import com.javaprojects.springcrud.bean.User;

@Repository
public class UserDao {

	@Autowired // with the help of @Autowired
	JdbcTemplate jdbcTemplate; // Connects automatically to DB
	
	public int createUser(User user) {
	    
		String sql = "INSERT INTO USER (USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, BIRTH, STATUS) VALUES (?, ?, ?, ?, ?, ?)";
	    
		int rows = jdbcTemplate.update(sql, user.getUsername(), 
											user.getPassword(), 
											user.getFirstName(),
											user.getLastName(), 
											user.getBirth(), 
											"A");
	    return rows;
	}
	
	public List<User> getUsers(){
		
		String sql = "SELECT * FROM USER";
		
		return this.jdbcTemplate.query(sql, new UserMapper());
	}

	public User getUserByID(Integer id) {
		
		String sql = "SELECT * FROM USER WHERE ID_USER = ?";
	
		return DataAccessUtils.singleResult(this.jdbcTemplate.query(sql, new UserMapper(), id));

	}

	public void deleteUserByID(Integer id) {
	
		String sql = "DELETE FROM USER WHERE ID_USER = ?";
		
		jdbcTemplate.update(sql, id);
		
	}
	
	public void updateUser(User user) {
		
		String sql = "UPDATE USER SET USERNAME = ?, FIRST_NAME = ?, LAST_NAME = ?, BIRTH = ? WHERE ID_USER = ?";

        this.jdbcTemplate.update(sql, user.getUsername(), 
        							  user.getFirstName(), 
        							  user.getLastName(),
        							  user.getBirth(), 
        							  user.getIdUser());
	}
}