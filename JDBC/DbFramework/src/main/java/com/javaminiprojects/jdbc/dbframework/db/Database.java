package com.javaminiprojects.jdbc.dbframework.db;

import java.util.ArrayList;
import com.javaminiprojects.jdbc.dbframework.model.Customer;
import java.sql.*;

public class Database implements DataAccessObject {
	// Constructor
	public Database () {}

	@SuppressWarnings("null")
	
	public void createConnection (String url, String user, String pass) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			System.out.println("Attempting database connection");
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("Connection Successful");
		}
		catch (SQLException ex) {
			System.out.println("Error connecting to database: " + ex.getMessage());
			System.out.println("SQL state: " + ex.getSQLState());
			try {
				con.close();
			}
			catch (SQLException e) {
				System.out.println("Error closing connection: " + e.getMessage());
				System.out.println("SQL State: " + e.getSQLState());
			}
		}
	}

	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getCustomers(ArrayList<Customer>[] customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getCustomer(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}
	
	
}
