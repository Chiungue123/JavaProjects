package com.javaminiprojects.jdbc.dbframework.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.javaminiprojects.jdbc.dbframework.db.Database;

public class DatabaseFramework {

	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/javaprojects";
		String user = "root";
		String pass = "pingpong35";
		
		Database db = new Database();
		Scanner sc = new Scanner(System.in);
		
		boolean active = true;
		boolean invalid;
		int input;
		
		db.createConnection(url, user, pass);
		
		while(active) {
			invalid = true;
			do {
				System.out.println("1: Create Customer\n2: View Customers\n3: Update Customer\n4: Delete Customer\n5: Exit");
				input = sc.nextInt();
				sc.nextLine();
				if (input < 1 || input > 5) {
					System.out.println("Invalid input, enter a number between 1 and 5");
				} else {
					invalid = false;
				}
			} while (invalid);
			
			switch (input) {
			case (1): 
				db.createCustomer(sc);
				break;
			case (2):
				db.viewCustomers();
				break;
			case (3):
				db.viewCustomers();
				db.updateCustomer(sc);
				break;
			case (4):
				db.deleteCustomer(sc);
				break;
			case (5):
				db.closeConnection();
				System.exit(0);
			
			}
		}
	}
}
/*

- Work in Progress
	- Method createConnection successfully works
	- Beginning closeConnection method
	- Created SQL table called 'customers'
	- Customer object attributes, getter and setter methods created
- Next Steps
	- Ready to build logic to insert a customer object to the database
	- Finish closeConnection() function

- Work in Progress
	- For jdbc.dbframework.db package:
		Connection object is globalized within the scope of database.java
		No longer need to pass connection as an argument in createConnection or closeConnection methods
		Connection object is defined in the try block, automatically closing the connection, result is less boilerplate code
	- For jdbc.dbframework.model package:	
		- Encountered type mismatch when setting customer's birthday. 
		- The issue arises from importing java.sql.Date in the Customer class while SimpleDateFormat.parse() returns java.util.Date. 
		- Aligned the Customer class to use java.util.Date to resolve the type incompatibility.
	- Next steps
		- Resolve Null pointer exception when using create statement
		
- Work in progress
	- Null Pointer Exception resolved
	- Solution: Used 'this.con' in the create connection method to make the connection object a class-level variable, allowing it to be reused across multiple methods in the class.
	
	- Customer is created and is sucessfully added to the db
	- Created a perpetual menu for CRUD operations
	Next steps
		- Implement remanining CRUD operations

- Work in Progress: Progress in CRUD methods 
	- Select operation works
	- Update operation underway
		- Populates the console with existing users to act as a reference
	- Implemented the following methods
		- getCustomerIDs() returns a list of customer IDs validate the user's input for updating a customer
		- getCustomerByID() returns the customer with the selected id, populating the console with the customer's information just before prompting the updated details
		- Error: getCustomerByID(input) displays Customer values are null despite initialization
		- Next Step: Investigate logic for Customer constructor and associated methods.
*/
	