<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>manager Login</title>
</head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<style>
#div1 {
	width: fit-content;
	height: fit-content;
}
</style>
<body>
	<h1 style="color: green; text-align: center;">Manager Login</h1>
	<p style="color: red; text-align: center;">
		<blink>${message }</blink>
	</p>
	<br>
	<div class="container" id="div1">
		<table align="center" class="table table-striped table-bordered">
			<f:form modelAttribute="mgr">
				<tr>
					<td>Email:</td>
				</tr>
				<tr>
					<td><f:input path="email" placeholder="enter email" /></td>
				</tr>
				<tr>
					<td>Password:</td>
				</tr>
				<tr>
					<td><f:input type="password" path="password"
							placeholder="enter password" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="login" /></td>
				</tr>
				<tr>
					<td><input type="reset" value="cancel" /></td>
				</tr>
			</f:form>
		</table>
	</div>

</body>