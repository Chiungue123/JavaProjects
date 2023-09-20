package com.javaminiprojects.jdbc.dbframework.controller;

import java.util.Scanner;

import com.javaminiprojects.jdbc.dbframework.db.Database;

public class DatabaseFramework {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/javaprojects";
		String user = "root";
		String pass = "pingpong35";
		
		Database db = new Database();
		Scanner sc = new Scanner(System.in);
		
		//Customer customer = new Customer();
		db.createConnection(url, user, pass);
		db.createCustomer(sc);
		db.closeConnection();
		
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
		- Null pointer excepitn
		
*/