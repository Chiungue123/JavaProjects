package com.javaminiprojects.jdbc.dbframework.controller;

import java.sql.Connection;

import com.javaminiprojects.jdbc.dbframework.db.Database;
import com.javaminiprojects.jdbc.dbframework.model.Customer;

public class DatabaseFramework {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/javaprojects";
		String user = "root";
		String pass = "pingpong35";
		
		Database db = new Database();
		Connection con = null;
		
		//Customer customer = new Customer();
		db.createConnection(con, url, user, pass);
		db.closeConnection(con);
		
	}

}
/*

- Work in Progress
	- Method createConnection successfully works
	- Beginning closeConnection method
	- Created SQL table called 'customers' 
	- Customer object attributes, getter and setter methods created
- Next Steps
	- Ready to write functionality to insert a customer object to the db
	- Finish closeConnection() function

*/