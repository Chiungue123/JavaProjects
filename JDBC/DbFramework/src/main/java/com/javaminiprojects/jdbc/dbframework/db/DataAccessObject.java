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
	public void viewCustomers();
	public void getCustomer(Scanner scanner);
	public void updateCustomer(Scanner scanner);
	public void deleteCustomer(Scanner scanner);
}
