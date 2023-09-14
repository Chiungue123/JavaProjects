package com.javaminiprojects.jdbc.dbframework.controller;

import com.javaminiprojects.jdbc.dbframework.db.Database;
import com.javaminiprojects.jdbc.dbframework.model.Customer;

public class DatabaseFramework {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/javaprojects";
		String user = "root";
		String pass = "pingpong35";
		
		Database db = new Database();
		
		
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		db.createConnection(url, user, pass);
		
	}

}
