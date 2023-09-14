package com.javaminiprojects.jdbc.dbframework.model;

import java.sql.Date;

public class Customer {
	private Integer cid;
	private String name;
	private String email;
	private Date birthday;
	private Integer age;
	
	public Customer() {};
	
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
}
