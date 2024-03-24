<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body>
	<h3 style="color: red; text-align: center;">Some Internal problem
		- inconvience is regratted</h3>
	<table align="center" border="1">
		<tr>
			<td>status</td>
			<td>${status}</td>
		</tr>
		<tr>
			<td>timestamp</td>
			<td>${timestamp}</td>
		</tr>
		<tr>
			<td>message</td>
			<td>${message}</td>
		</tr>
		<tr>
			<td>path</td>
			<td>${path}</td>
		</tr>
		<tr>
			<td>trace</td>
			<td>${trace}</td>
		</tr>
	</table>
	<div align="center">
		<img src="error.png" width="200px" height="200px"
			align="middle" alt="error" />
	</div>
</body>
</html>