<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Create a Customer</title>
</head>
  <body>
	<h2>Enter Customer Details Below</h2>
	<form action="ProcessServlet" method="POST">
		<p>Customer Name:</p> <input type="text" name="txtName" required>
		<br>
		<p>Customer Email:</p> <input type="text" name="txtEmail" required>
		<br>
		<p>Customer Birthday (yyyy-MM-dd):</p> <input type="text" name="txtBirth" required>
		<br>
		<p>Customer Age:</p> <input type="text" name="txtAge" required>
		<br><br>
		<input type="submit" name="action" value="Create">
	</form>
  </body>
</html>