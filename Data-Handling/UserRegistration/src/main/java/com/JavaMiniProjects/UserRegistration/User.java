package com.JavaMiniProjects.UserRegistration;

public class User {
	String name;
	String email;
	int age;
	
	User(String name, String email, int age){
		this.name = name;
		this.email = email;
		this.age = age;
	}
	
	//Getters
	public String getName(){
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public int getAge() {
		return this.age;
	}
}
