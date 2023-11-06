package com.javaprojects.springcrud.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jdbc.core.RowMapper;

import com.javaprojects.springcrud.bean.User;

public class UserMapper implements RowMapper<User> {

	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

		logger.debug("USER MAPPER: Map Row");
		
		User user = new User();
		
		user.setIdUser(rs.getInt("ID_USER"));
		user.setUsername(rs.getString("USERNAME"));
		user.setPassword(rs.getString("PASSWORD"));
		user.setFirstName(rs.getString("FIRST_NAME"));
		user.setLastName(rs.getString("LAST_NAME"));
		user.setBirth(rs.getDate("BIRTH"));
		user.setStatus(rs.getString("STATUS"));
		
		return user;
	}
}