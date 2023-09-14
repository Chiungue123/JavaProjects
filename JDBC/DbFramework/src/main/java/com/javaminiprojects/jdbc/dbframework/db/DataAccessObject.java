package com.javaminiprojects.jdbc.dbframework.db;

import java.sql.Connection;
import java.util.ArrayList;

import com.javaminiprojects.jdbc.dbframework.model.Customer;

public interface DataAccessObject {
	// CRUD Methods
	public void createConnection(Connection con, String url, String user, String pass);
	public void closeConnection(Connection con);
	
	// Customer Methods
	public void createCustomer(Customer customer);
	public void getCustomers(ArrayList<Customer> customer[]);
	public void getCustomer(int id);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(Customer customer);
}
