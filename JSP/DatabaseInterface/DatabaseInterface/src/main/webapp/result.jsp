<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRUD Result</title>
</head>
  <body>
	<h2>Result.jsp</h2>
	<br><br>
	
	<% 	 
		String action = (String) request.getAttribute("action");
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
	%>
  </body>
</html>