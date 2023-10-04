package com.javaminiprojects.database_interface.model;

import java.util.Date;

public class Customer {
	private Integer cid;
	private String name;
	private String email;
	private Date birthday;
	private Integer age;
	
	public Customer() {}
	
	public Customer(Customer customer) {
		this.cid = customer.cid;
		this.name = customer.name;
		this.email = customer.email;
		this.birthday = customer.birthday;
		this.age = customer.age;
	}
	
	public Customer (Integer cid, String name, String email, Date birthday, Integer age ) {
		this.cid = cid;
		this.name = name;
		this.email = email;
		this.birthday = birthday;
		this.age = age;
	}
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
	    // This method overrides the default toString method to provide a human-readable
	    // representation of the Customer object. This is useful for debugging and logging.
	    return String.format(
	            "[ID = %3s | Name = %-12s | Email = %-23s | Birthday = %-10s | Age = %3s ]", 
	            cid, name, email, birthday, age);
	}
	
}