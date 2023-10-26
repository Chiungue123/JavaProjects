package com.javaprojects.autowireddemo.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class User {

	String name;
	String email;
	
	Order order; // One to One relational mapping
	
	public User() {
		System.out.println("User Initialized: " + hashCode());
	}
	
	@Autowired
	public User(Order order) {
		this.order = order;
		System.out.println("CONSTRUCTOR INJECTED -> User Initialized: " + hashCode());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Order getOrder() {
		return order;
	}

	@Autowired
	public void setOrder(Order order) {
		System.out.println("SETTER INJECTED -> Order set for User: " + hashCode());
		this.order = order;
	}
}
