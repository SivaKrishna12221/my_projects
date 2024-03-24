<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Info</title>
</head>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<style>
   #div1 {
	 width: fit-content;
	margin-left: 0;
	margin-right: auto;
}
</style>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/nav-bar.css'/>">
 
</head>
<body>
<div class="navbar">
    
    <div class="navbar-links">
        <a href="./manager_dashboard">Home</a>
        <a href="emp_details">Employees</a>
        <a href="project_details">Project</a>
        <a href="show_employee_leaves">Employee Leaves</a>
        <a href="send_query">Help Desk</a>
        <a href="show_mgr_query_status">Query Status</a>
        <a href="show_mgr_pay_slip">PaySlip</a>
    </div>
    <div class="navbar-right">
        <a href="show_mgr_info"><span
							class="bi bi-person"></span>Manager</a>
        <a href="logout"><span
							class="bi bi-box-arrow-in-left"></span>Logout</a>
    </div>
</div>
<h1 style="color: green; text-align: center;">Employee Details</h1><hr>
<h5 style="color:green;text-aling:center;"> ${message}</h5>
<c:choose>
	<c:when test="${!empty empsList}">
		<div class="container" id="div1">
			<table align="center" class="table table-bordered">
				<tr>
					<th>SI No</th>
					<th>EmpName</th>
					<th>Role</th>
					<th>DOB</th>
					<th>MobileNo</th>
					<th>Email</th>
					<th>Address</th>
					<th>Action</th>
				</tr>
				<%int i = 1;%>
				<c:forEach var="emp" items="${empsList}">
					<tr>
						<td><%=i++%></td>
						<td>${emp.name}</td>
						<td>${emp.role }</td>
						<td>${emp.dob }</td>
						<td>${emp.mobileNo }</td>
						<td>${emp.email}</td>
						<td>${emp.address},${emp.city },${emp.state },${emp.pincode }</td>
						<td><a href="emp_details_to_assign_proj?empId=${emp.empId}">Assign Project</a></td>
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


