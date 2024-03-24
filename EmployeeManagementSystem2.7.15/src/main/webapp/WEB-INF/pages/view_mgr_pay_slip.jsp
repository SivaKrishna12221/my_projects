<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<style>
   #div1 {
	width: fit-content;
	height: fit-content;
}
</style>
<link rel="stylesheet" href="<c:url value='/css/nav-bar.css'/>">

</head>
<body>
	<div class="navbar">
		<div class="navbar-left">
			<span class="navbar-title">Admin</span>
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
	
<h1 style="color: green; text-align: center;">Manager Details </h1><hr>
<h3 style="color:green;text-align:center;">${message }</h3>
<c:choose>
	<c:when test="${!empty mgrsList}">
		<div class="container" id="div1">
			<table align="center" class="table table-bordered">
				<tr>
					<th>SI No</th>
					<th>EmpId</th>
					<th>FullName</th>
					<th>DOB</th>
					<th>MobileNo</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			<%int i = 1;%>
				<c:forEach var="mgr" items="${mgrsList}">
					<tr>
						<td><%=i++%></td>
						<td>${mgr.mgrId }</td>
						<td>${mgr.name}</td>
						<td>${mgr.dob }</td>
						<td>${mgr.mobileNo }</td>
						<td>${mgr.email}</td>
						<td><a href="upload_mgr_pay_slip?mgrId=${mgr.mgrId}">upload</a>
							</tr>
				</c:forEach>
			</table>
		</div>
	</c:when>
	<c:otherwise>
		<h1 style="color:red;text-align:center;"><blink>data not found</blink></h1>
	</c:otherwise>
</c:choose>
</body>
</html>

