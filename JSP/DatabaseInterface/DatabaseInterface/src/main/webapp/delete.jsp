<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Customer</title>
</head>
  <body>
  	<h2>Delete Customer Here</h2>
	<form action="ProcessServlet" method="POST">
		Enter Customer ID: <input type="text" name="id" required>
		<br>
		<input type="submit" name="action" value="Delete">
	</form>
  </body>
</html>