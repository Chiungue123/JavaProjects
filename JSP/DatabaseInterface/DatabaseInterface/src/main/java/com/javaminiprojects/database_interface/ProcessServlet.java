package com.javaminiprojects.database_interface;

import com.javaminiprojects.database_interface.model.Customer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaminiprojects.database_interface.db.Database;

@WebServlet("/ProcessServlet")
public class ProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String attribute;
		String action = request.getParameter("action");
		
		if ("Show".equals(action)) {
			
			System.out.println("Action: " + action);
		    // Create Database Connection
			Database db = new Database();
			List<Customer> customers = new ArrayList<>(db.getCustomers());
			attribute = "show";
			
			// Set attribute as show, send customers to jsp
			request.setAttribute("action", attribute);
			request.setAttribute("customers", customers);
			
			// Forward to JSP
			request.getRequestDispatcher("result.jsp").forward(request, response);
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String attribute;
		String action = request.getParameter("action");

		if ("Create".equals(action)) {
			
			// Get Parameters
			String name = request.getParameter("txtName");
			String email = request.getParameter("txtEmail");
			String birth = request.getParameter("txtBirth");
			int age = Integer.parseInt(request.getParameter("txtAge"));
			
			// Create database connection
			Database db = new Database();
			db.createCustomer(name, email, birth, age);
			System.out.println("Servlet: createCustomer method executed");
			
			// Set attribute as create
			attribute = "create";
			request.setAttribute("action", attribute);
			
			// Forward to JSP
			request.getRequestDispatcher("result.jsp").forward(request, response);
			
		} else if ("Update".equals(action)) {
			
			System.out.println("Action: " + action);
			  
			// Create Database Connection
			Database db = new Database();
			//db.updateCustomer();
			
			// Set attribute as show
			attribute = "update";
			request.setAttribute("action", attribute);
			
			// Forward to JSP
			request.getRequestDispatcher("result.jsp").forward(request, response);
			
		} else if ("Delete".equals(action)) {
			
			System.out.println("Action: " + action);
		    // Perform delete operation
			
		} else {
			System.out.println("Action: " + action);
			request.setAttribute("action", action);
			request.getRequestDispatcher("result.jsp").forward(request, response);
			
		}
	}

}
