package com.javaprojects.springcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaprojects.springcrud.dao.UserDao;
import com.javaprojects.springcrud.bean.User;

@Service
public class UserService {
	
	@Autowired // Automatically instantiates UserDao methods below are called
	UserDao userDao;
	
	public List<User> listUsers(){
		return this.userDao.getUsers();
	}
	
	private static void validateUser(User user) {
		if (user.getFirstName().isEmpty() || user.getLastName().isEmpty()) {
			throw new RuntimeException("Invalid User");
		}
	}
	
	public int createUser(User user) {
		UserService.validateUser(user);
		return this.userDao.createUser(user);
	}
	
	public User getUserByID(Integer id) {
		return this.userDao.getUserByID(id);
	}

	public void deleteUserByID(Integer id) {
		this.userDao.deleteUserByID(id);
	}

	public void updateUser(User user) {
		this.userDao.updateUser(user);
	}
}