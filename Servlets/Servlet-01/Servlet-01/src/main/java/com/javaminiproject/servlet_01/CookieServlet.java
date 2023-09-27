package com.javaminiproject.servlet_01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String COOKIE_NAME = "user";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		
		// Using functional programming to iterate through the cookies
		String user = Arrays.stream(cookies)
						.filter(c -> COOKIE_NAME.equals(c.getName()))
						.map(Cookie::getValue)
						.findAny().orElse(null);
		
		// Get the value of 'remove'
		boolean remove = Boolean.valueOf(request.getParameter("remove"));
		
		// If remove = true, set the cookie value to null & add it to the response
		if (remove) {
			user = null;
			
			Cookie cookie = new Cookie(COOKIE_NAME, user);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		// This form submits a value with the name 'user'
		out.print("<h1>CookieServlet: doGet</h1>");
		out.print("<br>");
		out.print("<p>Cookie Value: " + user + " </p>");
		out.print("<br>");
        out.print("<a href='" + request.getContextPath() + "/CookieServlet?remove=true'>Remove Cookie</a>");
        out.print("<br>");
        out.print("<a href='" + request.getContextPath() + "/CookieServlet'>Refresh</a>");
		out.print("<form action='CookieServlet' method='post'>");
        out.print("<br>");
        out.print("Input User: <input type='text' name='user' required>");
        out.print("&nbsp;"); // Blank space
        out.print("<input type='submit' value='Create User Cookie'>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		// Get the parameters from the post request
		String user = request.getParameter("user"); 
		
		// Pass COOKIE_NAME and user as the key/value pair 
		Cookie cookie = new Cookie(COOKIE_NAME, user);
		
		// Add the cookie to the response
		response.addCookie(cookie);
		
		// Send a response back to the browser
		response.sendRedirect(request.getContextPath() + "/CookieServlet");
		
		
		// Display the data from the post request 
		out.print("<h1>CookieServlet: doPost</h1>");
		out.print("<p>User Cookie Value: " + cookie + "</p>");
		
		// request.getContextPath = 'http://localhost:8080/Servlet-01' //
		out.print("<a href='" + request.getContextPath() + "/CookieServlet'>Try Again</a>");
	}
}