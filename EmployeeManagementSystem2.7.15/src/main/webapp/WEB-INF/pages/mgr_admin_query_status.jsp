<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mgr Admin Query status</title>
<style>
   #div1 {
	 width: fit-content;
	margin-left: auto;
	margin-right: auto;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
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
<h3 style="color:green; text-align:center;">Query Status</h3>
	<hr>
	<h3 style="color:green;text-align:center;"><blink>${message }</blink></h3>
	<c:choose>
		<c:when test="${!empty query_status}">
			<div class="container" id="div1">
				<table class="table table-striped">
					<tr>
					    <th>SIno</th>
						<th>Name</th>
						<th>Email</th>
						<th>Message</th>
						<th>Status</th>
					</tr>
                    <% int i=1; %>
					<c:forEach var="query" items="${query_status}">
						<tr>
						    <td><%=i++ %></td>
							<td>${query.empName }</td>
							<td>${query.email}</td>
							<td>${query.message}</td>
							<td>${query.status}</td>
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
