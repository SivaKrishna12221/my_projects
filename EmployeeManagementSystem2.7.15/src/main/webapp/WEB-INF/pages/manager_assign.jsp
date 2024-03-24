<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Manager</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0<%-- <link rel="stylesheet" href="<c:url value='/css/nav-bar.css'/>">
 --%>-beta.2/css/bootstrap.min.css">
<style>
#div1 {
	width: fit-content;
	height: fit-content;
}
</style>
<link rel="stylesheet" href="<c:url value='/css/nav-bar.css'/>">



</head>
<body>
<body>
	<div class="navbar">
		<div class="navbar-left">
			<span class="navbar-title">Admin </span>
		</div>
		<div class="navbar-links">
			<a href="./admin_dashboard">Home</a> <a href="add_employee">Add
				Emp</a> <a href="view_employee">View Emp</a> <a href="view_manager">View
				Mgr</a> <a href="manager_assign">Manager Assign</a> <a
				href="view_queries">Queries</a> <a href="pay_slips">PaySlip</a>
		</div>
		<div class="navbar-right">
			<a href="show_admin_info">Profile</a> <a href="logout">Logout</a>
		</div>
	</div>
	<h1 style="color: green; text-align: center;">Manager Assign</h1>
	<hr>
	<h3 style="color: green; text-align: center;">
		<blink>${message }</blink>
	</h3>
	<c:choose>
		<c:when test="${!empty empsList}">
			<div class="container" id="div1">
				<table align="center" class="table table-bordered">
					<tr>
						<th>SI No</th>
						<th>EmpId</th>
						<th>FullName</th>
						<th>Role</th>
						<th>DOB</th>
						<th>MobileNo</th>
						<th>Email</th>
						<th>manager</th>
						<th>Action</th>
					</tr>
					<%
					int i = 1;
					%>
					<c:forEach var="emp" items="${empsList}">
						<tr>
							<td><%=i++%></td>
							<td>${emp.empId }</td>
							<td>${emp.name}</td>
							<td>${emp.role }</td>
							<td>${emp.dob }</td>
							<td>${emp.mobileNo }</td>
							<td>${emp.email}</td>
							<td>${emp.managerAssign }</td>
							<td><a href="assign_manager?empId=${emp.empId}">${emp.managerAssignAction}</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</c:when>
		<c:otherwise>
			<h3 style="color: red; text-align: center;">Data Not Found</h3>
		</c:otherwise>
	</c:choose>
</body>
</body>
</html>




