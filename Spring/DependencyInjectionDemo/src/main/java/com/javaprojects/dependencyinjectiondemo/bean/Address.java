package com.javaprojects.dependencyinjectiondemo.bean;

public class Address {

	String street;
	String city;
	String province;
	String postalCode;
	
	public Address() {
		System.out.println("Address Initialized");
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", province=" + province + ", postalCode=" + postalCode + "]";
	}
	
}
