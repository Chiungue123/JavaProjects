package com.javaminiproject.servlet_01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HeaderServlet")
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/HTML");
		PrintWriter out = response.getWriter();
		String host = request.getHeader("host");
		
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>Header Info Servlet</h1>");
		out.print("<p>Host: " + host + "</p>");
		out.print("</body>");
		out.print("</html>");
		
		Iterator<String> ite = request.getHeaderNames().asIterator();
		while(ite.hasNext()){
			out.print(ite.next() + ":	" + request.getHeader(ite.next()) + "</h3>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
/*
- Cloned HelloServlet to create HeaderServlet in servlet_01 package
	- Implemented Iterator to get Header Names from HeaderServlet
	- Header names and corresponding values displayed on HeaderServlet html output
	- Implemented request.getHeader('host'); and out.print("<p>Host: " + host + "</p>"); to print host header
*/