package com.JavaMiniProjects.CustomerServiceSimulation;

abstract class Customer {
	String name;
	String serviceRequest;
	
	Customer(String name, String serviceRequest){
		this.name = name;
		this.serviceRequest = serviceRequest;
	}
}
