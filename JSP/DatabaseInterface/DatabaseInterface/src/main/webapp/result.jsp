<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList, com.javaminiprojects.database_interface.model.Customer" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRUD Result</title>
</head>
  <body>
	<% 	 
		String action = (String)request.getAttribute("action");
		if ("create".equals(action)) { 
	%>
		<h2>Customer Successfully Created</h2>
		<p>Customer <%= request.getParameter("txtName") %> has been created! </p>
		<p>Email: <%= request.getParameter("txtEmail") %> </p>
		<p>Birthday: <%= request.getParameter("txtBirth") %>
		<p>Age: <%= request.getParameter("txtAge") %> </p>
		<br>
		
		<a href="index.jsp">Try Again</a>
	<% 
		}
		else if ("show".equals(action)) {
		@SuppressWarnings("unchecked")
		List<Customer> customers = (List<Customer>)request.getAttribute("customers");
	%>
		<h2>Displaying Customers</h2>
		<table border="1">
		    <tr>
		        <th>Name</th>
		        <th>Email</th>
		        <th>Birthday</th>
		        <th>Age</th>
		    </tr>
		    <% 
		    for (Customer customer : customers) {
		    %>
		    <tr>
		        <td><%= customer.getName() %></td>
		        <td><%= customer.getEmail() %></td>
		        <td><%= customer.getBirthday() %></td>
		        <td><%= customer.getAge() %></td>
		    </tr>
		    <% 
		    }
		    %>
		</table>
	<%
		}
		else if ("delete".equals(action)){
	%>	
		<h2>Customer Successfully Deleted</h2>
		<br>
		<a href="index.jsp">Try Again</a>
	<%	
		}
		else {
	%>
		<h2>Action: <%= action %> </h2>
		<a href="index.jsp">Try Again</a>
	<%
		}
	%>
  </body>
</html>