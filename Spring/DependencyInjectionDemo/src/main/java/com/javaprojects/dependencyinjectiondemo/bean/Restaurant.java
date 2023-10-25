package com.javaprojects.dependencyinjectiondemo.bean;

import java.util.List;

public class Restaurant {

	String name;
	String phone;
	String operatingHours;
	float ratings;
	
	Address address; // Has-A relationship - One to One Relationship
	List<String> searchKeywords; // Has-A relationship - One to Many Relationship

	Restaurant(){
		System.out.println("Resturant Initialized");
	}
	
	// CONSTRUCTOR INJECTION
	Restaurant(Address address){
		System.out.println("CONSTRUCTOR INJECTION: Resturant Initialized with Address");
		this.address = address;
	}
	
	public List<String> getSearchKeywords() {
		return searchKeywords;
	}

	public void setSearchKeywords(List<String> searchKeywords) {
		System.out.println("Restaurant: setKeywords executed - SETTER INJECTION");
		this.searchKeywords = searchKeywords;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOperatingHours() {
		return operatingHours;
	}

	public void setOperatingHours(String operatingHours) {
		this.operatingHours = operatingHours;
	}

	public float getRatings() {
		return ratings;
	}

	public void setRatings(float ratings) {
		this.ratings = ratings;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		System.out.println("Restaurant: setAddress executed - SETTER INJECTION");
		this.address = address;
	}

	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", phone=" + phone + ", operatingHours=" + operatingHours + ", ratings=" + ratings + ", address=" + address + "]";
	}
	
}