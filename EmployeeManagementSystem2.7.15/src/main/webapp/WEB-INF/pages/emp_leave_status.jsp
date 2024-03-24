<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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

<h1 style="color: green; text-align: center;">leave Status</h1>
	<hr>
	<h3 style="color:green;text-align:center;"><blink>${message }</blink></h3>
	<c:choose>
		<c:when test="${!empty leaves}">
			<div class="container" id="div1">
				<table class="table table-striped">
					<tr>
					    <th>SIno</th>
						<th>emp Name</th>
						<th>From Date</th>
						<th>to Date</th>
						<th>Status</th>
					</tr>
                    <% int i=1; %>
					<c:forEach var="leave" items="${leaves}">
						<tr>
						    <td><%=i++ %></td>
							<td>${leave.empName }</td>
							<td>${leave.fromDate}</td>
							<td>${leave.toDate}</td>
							<td>${leave.status}</td>
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

