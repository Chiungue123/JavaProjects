package com.javaminiprojects.reservationmanager.model;

public class Customer {
	private String name;
	private int age;
	
	Customer (String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String getName(Customer customer) {
		return customer.name;
	}
	
	public int getAge(Customer customer) {
		return customer.age;
	}
}
