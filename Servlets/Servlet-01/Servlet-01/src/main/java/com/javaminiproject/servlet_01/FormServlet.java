package com.javaminiproject.servlet_01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Response type written in HTML
		response.setContentType("text/HTML");
		PrintWriter out = response.getWriter();
		
		// This form involkes doPost when submitted
		out.print("<h1>FormServlet: doGet</h1>");
		out.print("<form action='FormServlet' method='post'>");
		out.print("<br><br>");
		out.print("First Name: <input type = 'text' name = 'firstname' required>");
		out.print("<br><br>");
		out.print("Last Name: <input type = 'text' name = 'lastname' required>");
		out.print("<br><br>");
		out.print("Email: <input type = 'email' name = 'email' required>");
		out.print("<br><br>");
		out.print("Birthday: <input type = 'date' name = 'birthday' required>");
		out.print("<br><br>");
		out.print("<button type='submit' value='Submit'>Submit</button>");
		out.print("</form>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Response type written in HTML
		response.setContentType("text/HTML");
		PrintWriter out = response.getWriter();
		
		// Get the parameters from the post request input fields
		String firstname = request.getParameter("firstname"); 
		String lastname = request.getParameter("lastname"); 
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday"); 
		
		// Display the data from the post request 
		out.print("<h1>FormServlet: doPost</h1>");
		out.println("<p>First Name: " + firstname + "</p>");
		out.println("<p>Last Name: " + lastname + "</p>");
		out.println("<p>Email: " + email + "</p>");
		out.println("<p>Birthday: " + birthday + "</p>");
		
		// request.getContextPath = 'http://localhost:8080/Servlet-01' //
		out.println("<a href='" + request.getContextPath() + "/FormServlet'>Try Again</a>");
	}
}