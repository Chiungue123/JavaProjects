<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Customers</title>
</head>
  <body>
	<h2>Enter Customer ID Below</h2>
	<form action="ProcessServlet" method="POST">
	  <p>Customer ID: </p><input type="text" name="txtCid" required>
	  <br><br>
	  <input type="submit" name="action" value="Show">
	</form>
  </body>
</html>