package com.javaminiprojects.jdbc.dbframework.db;
import com.javaminiprojects.jdbc.dbframework.model.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Scanner;

public class Database implements DataAccessObject {
	// Declare Connection 
	private Connection con;
	private Statement st;
	
	// Constructor
	public Database () {}
	
	public void createConnection (String url, String user, String pass) {
		try {
			// Use 'this.con' to make the connection object a class-level variable, allowing it to be reused across multiple methods in the class.
			this.con = DriverManager.getConnection(url, user, pass); // Create connection
			this.st = con.createStatement(); // Create statement
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
			// The formatter.parse method transforms the String date input into java.util.Date type compatible with SQL storage
			customer.setBirthday(formatter.parse(sc.nextLine()));
			System.out.println("Enter Customer Age: ");
			customer.setAge(sc.nextInt());
			
			// Create SQL query  
			String sql = "INSERT INTO CUSTOMERS (NAME, EMAIL, BIRTHDAY, AGE) VALUES";
			sql = sql + "('" + customer.getName() + "','" + customer.getEmail() + "','" + new java.sql.Date(customer.getBirthday().getTime()) + "','" + customer.getAge() + "')";
			System.out.println("Query: " + sql);
			
			// Execute statement
			int rows = st.executeUpdate(sql);
			System.out.println("Customer has been successfully added");
			System.out.println("Number of rows affected: " + rows);
			
		} catch (ParseException | SQLException ex) {
			System.out.println("Error while creating customer: " + ex.getMessage());
		}
	}

	@Override
	public void viewCustomers() {
		String sql = "SELECT * FROM CUSTOMERS";
		try (ResultSet rs = st.executeQuery(sql)){
			while (rs.next()) {
				/*System.out.print("ID: "+rs.getInt("ID"));
			    System.out.print("Name: "+rs.getString("First_Name"));
			    System.out.print("Age: "+rs.getString("Last_Name"));
			    System.out.print("Salary: "+rs.getDate("Date_Of_Birth"));*/
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void getCustomer(Scanner scanner) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void updateCustomer(Scanner scanner) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void deleteCustomer(Scanner scanner) {
		// TODO Auto-generated method stub	
	}
}
