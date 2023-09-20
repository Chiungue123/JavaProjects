package com.javaminiprojects.jdbc.dbframework.db;

import java.util.ArrayList;
import java.util.Scanner;

import com.javaminiprojects.jdbc.dbframework.model.Customer;

public interface DataAccessObject {
	// CRUD Methods
	public void createConnection(String url, String user, String pass);
	public void closeConnection();
	
	// Customer Methods
	public void createCustomer(Scanner scanner);
	public void getCustomers(ArrayList<Customer> customer[]);
	public void getCustomer(int id);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(Customer customer);
}
