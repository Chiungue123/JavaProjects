package com.javaminiprojects.jdbc.dbframework.db;
import com.javaminiprojects.jdbc.dbframework.model.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
		} catch (SQLException ex) {
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
		} catch (SQLException e) {
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
		List <Customer> customers = new ArrayList<>();
		String sql = "SELECT * FROM CUSTOMERS";
		try (ResultSet rs = st.executeQuery(sql)){
			while (rs.next()) {
				Customer customer = new Customer();
				
				int id = rs.getInt("CID");
			    String name = rs.getString("NAME");
			    String email = rs.getString("EMAIL");
			    Date birth = rs.getDate("BIRTHDAY");
			    int age = rs.getInt("AGE");
			    
			    customer.setCid(id);
			    customer.setName(name);
			    customer.setEmail(email);
			    customer.setBirthday(birth);
			    customer.setAge(age);
			    
			    customers.add(customer);
			}
			
			System.out.println("Customers: ");
			customers.forEach(System.out::println);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer customer = new Customer();
		try (ResultSet rs = st.executeQuery("SELECT * FROM CUSTOMERS")){
			while(rs.next()) {
				if (rs.getInt("CID") == id) {
					customer.setCid(rs.getInt("CID"));
					customer.setName(rs.getString("NAME"));
					customer.setEmail(rs.getString("EMAIL"));
					customer.setBirthday(rs.getDate("BIRTHDAY"));
					customer.setAge(rs.getInt("AGE"));
					break;
				}
			}
			
			} catch (SQLException ex) {
				System.out.println("Error while getting customerIDs");
				System.out.println("Error Message: " + ex.getMessage() + "\nStackTrace: " + ex.getStackTrace());
			}
		return customer;
	}  
	
	@Override
	public ArrayList<Integer> getCustomerIDs() {
		ArrayList <Integer> IDs = new ArrayList<>();
		String sql = "SELECT CID FROM CUSTOMERS";
		// Create a statement object that is bidirectional to check if the result set is empty to inform the user
		try (Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		     ResultSet rs = st.executeQuery(sql)) {
			// Move the cursor from the initial position to the first row
			if (!rs.next()) {
			    System.out.println("No Customer IDs found");
			    return null;
			}
			rs.beforeFirst(); // Move the cursor back to the initial position
			System.out.println("Customer IDs");
			while(rs.next()) {
				Integer id = new Integer(rs.getInt("CID"));
				System.out.print(id + ", ");
				IDs.add(id);
			}
			
		} catch (SQLException ex) {
			System.out.println("Error while getting customerIDs");
			System.out.println("Error Message: " + ex.getMessage());
			System.out.println("SQL State: " + ex.getSQLState());
		}
		
	return IDs;
	}  

	@Override
	public void updateCustomer(Scanner scanner) {
		
		String sql = "UPDATE CUSTOMERS SET NAME = ?, EMAIL = ?, BIRTHDAY = ?, AGE = ? WHERE CID = ?"; // Predefining the sql query
		int input; // For capturing the id
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // Formats the date value in the sql statement
		List<Integer> customerIDs = new ArrayList<>(getCustomerIDs()); // Returns a list of customer IDs validate the user's input.
		System.out.println();
		
		do {
			  System.out.println("Enter user Id: ");
			  input = scanner.nextInt();
			  scanner.nextLine();

			  if (customerIDs.contains(input)) {
			    System.out.println("User id input validated");
			    break;
			  } else {
			    System.out.println("The id " + input + " doesn't exist");
			  }
			} while(true);

		
		// Set the placeholder values in prepared statement
		try (PreparedStatement prSt = con.prepareStatement(sql)) {
			
			/*
			 * Prompt the user for the updated customer values
			 */
			
			System.out.println();
	
			Customer customer = new Customer(); // Create an empty customer object
			customer = getCustomerById(input); // Get selected customer by id
			System.out.println("Customer: " + customer); // Show existing values for customer, providing a reference for the user to work with
			System.out.println("Enter Customer Name: ");
			customer.setName(scanner.nextLine());
			System.out.println("Enter Customer Email: ");
			customer.setEmail(scanner.nextLine());
			System.out.println("Enter Customer Birthday (yyyy-MM-dd): ");
			// The formatter.parse method transforms the String date input into java.util.Date type compatible with SQL storage
			customer.setBirthday(formatter.parse(scanner.nextLine()));
			System.out.println("Enter Customer Age: ");
			customer.setAge(scanner.nextInt());
			
			/*
			 * Insert the updated values into the prSt
			 */
			
			prSt.setString(1, customer.getName());
			prSt.setString(2, customer.getEmail());
			prSt.setDate(3, new java.sql.Date(customer.getBirthday().getTime()));
			prSt.setInt(4, customer.getAge());
			prSt.setInt(5, customer.getCid());
			
			/*
			 * Execute the prSt query
			 */
			
			int rows = prSt.executeUpdate();

	        if (rows > 0) {
	            System.out.println("Number of rows affected: " + rows);
	        }
	        else {
	            System.out.println("User not found, user ID: " + customer.getCid());
	        }
			
		} catch (SQLException ex) {
			System.out.println("Error while getting customerIDs");
			System.out.println("Error Message: " + ex.getMessage());
			System.out.println("SQL: " + ex);
		} catch (ParseException ex) {
			System.out.println("Error while getting customerIDs");
			System.out.println("Error Message: " + ex.getMessage());
			System.out.println("SQL State: " + ex.getStackTrace());
		}
	}

	@Override
	public void deleteCustomer(Scanner scanner) {
		
		// Retrieve Customer IDs 
		List<Integer> customerIDs = new ArrayList<>(getCustomerIDs());
		System.out.println();
		System.out.println("Customer IDs");
		customerIDs.forEach(c -> System.out.print(c + ", "));
		System.out.println();
		
        boolean valid = false; // Validates user's prompt
		int input; // Captures the desired CID to be deleted
		
		do {
			  System.out.println("Enter user Id: ");
			  input = scanner.nextInt();
			  scanner.nextLine();

			  if (customerIDs.contains(input)) {
			    valid = true;
			  } else {
			    System.out.println("The id " + input + " doesn't exist");
			  }
			} while(!valid);
		
		Customer customer = new Customer(getCustomerById(input)); // Get selected customer by id
		System.out.println();
		System.out.println("Customer: " + customer);
		System.out.println();
		
		do {
			String sql = "DELETE FROM CUSTOMERS WHERE CID = ?";
			System.out.println("Confirm to delete Customer ID: " + customer.getCid() + " (Y/N)");
			String response = scanner.nextLine();
			if (response.toUpperCase().equals("Y")) {
				try (PreparedStatement prSt = con.prepareStatement(sql)) {
					
					// Display the chosen ID and the Query statement to be executed
					System.out.println();
					System.out.println("Id: " + input);
					prSt.setInt(1, input);
					String query = ("DELETE FROM CUSTOMERS WHERE CID = " + input);
					System.out.println("Executing Query: " + query); 

						// Execute update, return the number of affected rows
			            int rows = prSt.executeUpdate();

			            if (rows > 0) {
			                System.out.println("Number of rows affected: " + rows);
			                System.out.println();
			            }
			            else {
			                System.out.println("User not found, user ID: " + input);
			                System.out.println();
			            }
			            break;
			            
				} catch (SQLException ex) {

		            System.err.println("Error while connecting!");
		            System.err.println("SQL: " + ex);
		            System.err.println("SQL State: " + ex.getSQLState());
		            System.err.println("Error Message: " + ex.getMessage());
					
		        }
			} else {
				System.out.println("Breaking out of deletion confirmation");
				break;
			}
		} while (true);
	}
}
