 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
	<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
	
<style>

#div1 {
	width: fit-content;
	margin-left: 0;
	margin-right: auto;
}
</style>
 <link rel="stylesheet" href="<c:url value='/css/nav-bar.css'/>">
 
</head>

<body>
	<div class="navbar">
		<div class="navbar-left">
			<span class="navbar-title">Admin </span>
		</div>
		<div class="navbar-links">
			<a href="./admin_dashboard">Home</a> <a href="add_employee">Add
				Emp</a> <a href="view_employee">View Emp</a> <a href="view_manager">View
				Mgr</a> <a href="manager_assign">Manager Assign</a> <a
				href="view_queries">Queries</a> <a href="pay_slips">Payslip</a>
		</div>
		<div class="navbar-right">
			<a href="show_admin_info" class="bi bi-person-fill text-white">Profile</a> <a href="logout">Logout</a>
		</div>
	</div>
	<h1 style="color: green; text-align: center;">Employee Details</h1>
	<hr>
	<h3 style="color: green; text-align: center;">${message }</h3>
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
						<th>Address</th>
						<th>Action</th>
					</tr>
                      <% int i=1; %>
					<c:forEach var="emp" items="${empsList}">
						<tr>
							<td><%=i++%></td>
							<td>${emp.empId }</td>
							<td>${emp.name}</td>
							<td>${emp.role }</td>
							<td>${emp.dob }</td>
							<td>${emp.mobileNo }</td>
							<td>${emp.email}</td>
							<td>${emp.address},${emp.city },${emp.state },${emp.pincode }</td>
							<td><a href="edit_emp?empId=${emp.empId }"
								onclick="return confirm('Do you want to edit')">Edit</a>&nbsp;&nbsp;<a
								href="delete_emp?empId=${emp.empId }"
								onclick="return confirm('Do you want to Delete')">Delete
									</a></td>
						</tr>
						
					</c:forEach>
				</table>
			</div>
		</c:when>
		<c:otherwise>
			<h1 style="color: red; text-align: center;">
				<blink>data not found</blink>
			</h1>
		</c:otherwise>
	</c:choose>
	<h4 style="text-align: center">
		Download Employee Info <a href="download_emps_info?file=pdf">Pdf</a>
		or <a href="download_emps_info?file=excel">Excel Sheet</a>
	</h4>

</body>
</html>

