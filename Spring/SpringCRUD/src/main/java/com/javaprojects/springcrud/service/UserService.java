package com.javaprojects.springcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaprojects.springcrud.dao.UserDao;
import com.javaprojects.springcrud.bean.User;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public List<User> listUsers(){
		
		return this.userDao.getUsers();
	}
	
	public int createUser(User user) {
		
		return this.userDao.createUser(user);
	}
}