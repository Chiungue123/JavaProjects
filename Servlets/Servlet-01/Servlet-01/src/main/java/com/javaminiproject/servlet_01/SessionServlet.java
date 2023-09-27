package com.javaminiproject.servlet_01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String USERNAME = "username";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		// getSession returns a session or creates a new one if you don't have a session
		String username = (String)request.getSession().getAttribute(USERNAME);
		
		// Captures the error status of the request
		boolean error = Boolean.valueOf(request.getParameter("error"));
		
		// Check if the user was logged in or not
		boolean logout = Boolean.valueOf(request.getParameter("logout"));
		
		// Invalidate the session if the logout parameter is set to true
		if (logout) {
			request.getSession(false).invalidate();
		}
		
		// If the username is null, prompt the user to login
		if (username == null) {
            out.print("<html>");
            out.print("<body>");
            out.print("<h1>Session HttpServlet Class Example</h1>");
            out.print("<br>");
            if (error) {
                out.print("<h3 style='color:red'>Invalid Password!</h3>");
            }
            out.print("<h2>Input your Login Info:</h2>");
            out.print("<br>");
            out.print("<form action='SessionServlet' method='post'>");
            out.print("Username: <input type='text' name='username' required>");
            out.print("<br><br>");
            out.print("Password: <input type='password' name='password' required>");
            out.print("<br><br>");
            out.print("<input type='submit' value='Submit'>");
            out.print("</form>");
        }
        else {
            out.print("<html>");
            out.print("<body>");
            out.print("<h1>Session HttpServlet Class Example</h1>");
            out.print("<br>");
            out.print("<h2>Welcome " + username + "</h2>");
            out.print("<br>");
            out.print("<a href='" + request.getContextPath() + "/SessionServlet?logout=true'>Logout</a>");
            out.print("&nbsp&nbsp");
            out.print("<a href='" + request.getContextPath() + "/SessionServlet'>Refresh</a>");
            out.print("</body>");
            out.print("</html>");
        }

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get the parameters sent from the post form
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        boolean error = false;

        if ("123".equals(password)) {

            request.getSession().setAttribute(USERNAME, username);
        }
        else {
            error = true;
        }
        
        // If the password is incorrect, redirect the user back to the login page
        response.sendRedirect(request.getContextPath() + "/SessionServlet?error=" + error);
	}
}