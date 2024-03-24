
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Employee leaves</title>
<style>
#div1 {
	width: fit-content;
	height: fit-content;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
</head>
<body>
<h1 style="color: green; text-align: center;">leave Status</h1>
	<hr>
	<h3 style="color:green;text-align:center;"><blink>${message }</blink></h3>
	<c:choose>
		<c:when test="${!empty listOfLeaves}">
			<div class="container" id="div1">
				<table class="table table-striped">
					<tr>
					    <th>SIno</th>
						<th>EmpId</th>
						<th>name</th>
						<th>message</th>
						<th>Status</th>
						<td>Action</td>
					</tr>
                    <% int i=1; %>
					<c:forEach var="queries" items="${listOfLeaves}">
						<tr>
						    <td><%=i++ %></td>
							<td>${queries.empId }</td>
							<td>${queries.name }</td>
							<td>${queries.helpMessage }</td>
							<td>${queries.helpStatus}</td>
							<td><a href="update_emp_query?empId=${queries.empId }">update</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</c:when>
		<c:otherwise>
			<h3 style="color: green; text-align: center;">
				<blink>${message }</blink>
			</h3>
		</c:otherwise>
	</c:choose>

</body>
</html>

