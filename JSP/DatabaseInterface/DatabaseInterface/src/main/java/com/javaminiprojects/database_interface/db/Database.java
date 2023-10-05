package com.javaminiprojects.database_interface.db;

import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.*;
import com.javaminiprojects.database_interface.model.Customer;


//For simplicity sake: Connection and Prepared Statements are now method level varibles rather than class level

// Exception: No suitable driver found for jdbc:mysql://localhost:3306/javaprojects
// Action Taken: Explicitly loaded the driver class which removed the exception

// Exception: Customer birthday field was null, triggering a null pointer exception
// Action: Discovered that the birthday input tag had incorrect name,  changed txtName to txtBirth

// Completed createCustomer method

public class Database {
	
	private String url = "jdbc:mysql://localhost:3306/javaprojects";
	private String user = "root";
	private String pass = "pingpong35";
	
	public Database() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error explicitly loading driver class!");
			e.printStackTrace();
		}
	}
	
	public void createCustomer(String name, String email, String birth, Integer age) {
		
		// System.out.println("Database: Create Customer involked");
		// System.out.println("Parameters: Name: " + name + ", email: " + email + ", birth: " + birth + ", age: " + age);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Customer customer = new Customer();
		String sql = "INSERT INTO CUSTOMERS (NAME, EMAIL, BIRTHDAY, AGE) " 
				   + "VALUES(?,?,?,?)";
		
		try (Connection con = DriverManager.getConnection(url, user, pass);
			 PreparedStatement prst = con.prepareStatement(sql)) {
			
			Date birthday = formatter.parse(birth);
			
			customer.setName(name);
			customer.setEmail(email);
			customer.setBirthday(new java.sql.Date(birthday.getTime()));
			customer.setAge(age);
		
			prst.setString(1, customer.getName());
			prst.setString(2, customer.getEmail());
			prst.setDate(3, new java.sql.Date(customer.getBirthday().getTime()));
			prst.setInt(4, customer.getAge());
			
			int rows = prst.executeUpdate();
			System.out.println("Number of rows affected: " + rows);
		}
		
		catch (SQLException ex) {
			System.out.println("Error Creating Customer");
			System.out.println("Error: " + ex);
		}
		
		catch (ParseException ex) {
			System.out.println("Parse Error While Converting Birthday Datatype");
			System.out.println("Error: " + ex);
		}
		
		catch (NullPointerException ex) {
			System.out.println("Null Pointer Exception while creating Customer");
			System.out.println("Error: " + ex);
		}
	}
	
	public List<Customer> getCustomers() {
		
		String sql = "SELECT * FROM CUSTOMERS";
		List<Customer> customers = new ArrayList<>();
		
		try(Connection con = DriverManager.getConnection(url, user, pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);) {
			
			while (rs.next()) {
				
				Integer cid = rs.getInt("cid");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date birthday = rs.getDate("birthday");
				Integer age = rs.getInt("age");
				
				Customer customer = new Customer(cid, name, email, birthday, age);
				
				customers.add(customer);
			}
			
		}
		catch(SQLException ex) {
			System.out.println("Error getting customers");
			System.out.println("Error: " + ex);
			System.out.println("Stack Trace: " + ex.getStackTrace());
		}
		
		return customers;
		
	}
}













