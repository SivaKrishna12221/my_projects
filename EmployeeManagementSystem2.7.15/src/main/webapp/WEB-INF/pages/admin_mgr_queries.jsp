<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Queries</title>
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
    <div class="navbar-left">
        <span class="navbar-title">Admin</span>
    </div>
    <div class="navbar-links">
        <a href="./admin_dashboard">Home</a>
        <a href="add_employee">Add Emp</a>
        <a href="view_employee">View Emp</a>
        <a href="view_manager">View Mgr</a>
        <a href="manager_assign">Manager Assign</a>
        <a href="view_queries">Queries</a>
        <a href="pay_slips">PaySlip</a>
    </div>
    <div class="navbar-right">
        <a href="show_admin_info">profile</a>
        <a href="logout">Logout</a>
    </div>
</div>
<h3 style="color: green; text-align: center;">Manager Queries</h3>
	<hr>
	<h3 style="color:green;text-align:center;"><blink>${message }</blink></h3>
	<c:choose>
		<c:when test="${!empty mgr_queries }">
			<div class="container" id="div1">
				<table class="table table-striped">
					<tr>
					    <th>SIno</th>
						<th>Emp Name</th>
						<th>Mobile No</th>
						<th>Email</th>
						<th>Message</th>
						<th>Status</th>
						<th>Action</th>
					</tr>
                    <% int i=1; %>
					<c:forEach var="query" items="${mgr_queries}">
						<tr>
						    <td><%=i++ %></td>
							<td>${query.empName }</td>
							<td>${query.mobileNo}</td>
							<td>${query.email}</td>
							<td>${query.message}</td>
							<td>${query.status }</td>
							<td><a href="send_response_to_mgr_query?helpId=${query.msgId }&mgrId=${query.empId}">Response</a>
							</tr>
					</c:forEach>
				</table>
			</div>
		</c:when>
		<c:otherwise>
			<h4 style="color:red; text-align: center;">
				<blink>Data Not found</blink>
			</h4>
		</c:otherwise>
	</c:choose>

</body>
</html>

