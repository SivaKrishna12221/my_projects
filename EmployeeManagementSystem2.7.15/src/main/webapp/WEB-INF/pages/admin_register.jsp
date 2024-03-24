<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<style>
#div1 {
	width: fit-content;
	height: fit-content;
}
</style>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/nav-bar.css'/>">

</head>
<body>
	<h1 style="color: green; text-align: center;">Admin Registration</h1>
	<p style="color: red; text-align: center;">${message }</p>
	<br>
	<div class="container" id="div1">
		<table align="center" class="table table-striped table-bordered">
			<f:form modelAttribute="admin">
				<tr>
					<td>Name:</td>
				</tr>
				<tr>
					<td><f:input path="name" /><br>
					<f:errors path="name" cssStyle="color:red" /></td>
				</tr>
				<tr>
					<td>username:</td>
				</tr>
				<tr>
					<td><f:input path="username" placeholder="enter username" /><br>
					<f:errors path="username" cssStyle="color:red" /></td>
				</tr>
				<tr>
					<td>Password:</td>
				</tr>
				<tr>
					<td><f:input type="password" path="password"
							placeholder="enter password" /><br>
					<f:errors path="password" cssStyle="color:red" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Register" /></td>
				</tr>
				<tr>
					<td><input type="reset" value="cancel" /></td>
				</tr>
			</f:form>
		</table>
	</div>
</body>
</html>

