<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<style>
#div1 {
	width: fit-content;
	height: fit-content;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="<c:url value='/css/nav-bar.css'/>">
 
</head>
<body>
<div class="navbar">
    
    <div class="navbar-links">
        <a href="./emp_dashboard">Home</a>
        <a href="project_details">Project</a>
        <a href="leave_apply">LeaveApply</a>
        <a href="show_leave_status">ViewLeaveStatus</a>
        <a href="send_query">Help Desk</a>
        <a href="show_emp_query_status">Query Status</a>
        <a href="pay_slip">PaySlip</a>
    </div>
    <div class="navbar-right">
        <a href="show_emp_info"><span
							class="bi bi-person"></span>Employee</a>
        <a href="logout"><span
							class="bi bi-box-arrow-in-left"></span>Logout</a>
    </div>
</div>
	<h3 style="color: green; text-align: center;">Employee Details</h3>
	<hr>
	
	<c:choose>
		<c:when test="${!empty slip_info}">
			<div class="container" id="div1">
				<table  class="table table-bordered">
					<tr>
						<th>SI No</th>
						<th>EmpId</th>
						<th>FullName</th>
						<th>Email</th>
						<th>MobileNo</th>
						<th>PaySlip</th>
					</tr>
                   <%int i=1; %>
					<c:forEach var="slip" items="${slip_info}">
						<tr>
							<td><%=i++%></td>
							<td>${slip.empId }</td>
							<td>${slip.name}</td>
							<td>${slip.email}</td>
							<td>${slip.mobileNo}</td>
							<td><a href="download_emp_pay_slip?filePath=${slip.filePath}">Download</a></td>
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
</body>
</html>


