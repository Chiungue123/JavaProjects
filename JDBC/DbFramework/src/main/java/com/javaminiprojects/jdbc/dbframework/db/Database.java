package com.javaminiprojects.jdbc.dbframework.db;
import com.javaminiprojects.jdbc.dbframework.model.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Scanner;

public class Database implements DataAccessObject {
	// Declare Connection 
	private Connection con;
	
	// Constructor
	public Database () {}
	
	public void createConnection (String url, String user, String pass) {
		try(Connection con = DriverManager.getConnection(url, user, pass)) {
			System.out.println("Connected to Database");
		}
		catch (SQLException ex) {
			System.out.println("Error connecting to database: " + ex.getMessage());
			System.out.println("SQL state: " + ex.getSQLState());
		}
	}

	@Override
	public void closeConnection() {
		try {
			if (con != null) {
				con.close();
				System.out.println("Connection is closed");
			}
			//System.out.println("Connection is null, skipping closeConnection()");
		}
		catch (SQLException e) {
			System.out.println("Error closing connection: " + e.getMessage());
			System.out.println("SQL State: " + e.getSQLState());
		}
		
	}

	@Override
	public void createCustomer(Scanner sc) {
		try {
			// Create customer object & format date to "yyyy-MM-dd" for consistent parsing and formatting
			Customer customer = new Customer(); 
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			
			// Prompt the user for customer details
			System.out.println("Enter Customer Name: ");
			customer.setName(sc.nextLine());
			System.out.println("Enter Customer Email: ");
			customer.setEmail(sc.nextLine());
			System.out.println("Enter Customer Birthday (yyyy-MM-dd): ");
			customer.setBirthday(formatter.parse(sc.nextLine()));
			System.out.println("Enter Customer Age: ");
			customer.setAge(sc.nextInt());
			
			// Create statement and SQL query 
			Statement st = con.createStatement();
			String sql = "INSERT INTO CUSTOMERS (NAME, EMAIL, BIRTHDAY, AGE) VALUES";
			sql = sql + "('" + customer.getName() + "','" + customer.getEmail() + "','" + customer.getBirthday() + "','" + customer.getAge() + ")";
			System.out.println(sql);
			
			// Execute statement
			int rows = st.executeUpdate(sql);
			System.out.println("Customer has been successfully added");
			System.out.println("Number of rows affected: " + rows);
			
		} catch (ParseException | SQLException ex) {
			System.out.println("Error while creating customer: " + ex.getMessage());
			System.out.println("Stack Trace: " + ex.getStackTrace());
		}
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
