<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Leave Requests</title>
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
   <h3 style="color: green; text-align: center;">Employee Leave
		Details</h3>
		
	 <h3 style="color:orange;text-align:center"><blink>${message }</blink></h3>
	<div class="container" id="div1">
		<c:choose>
			<c:when test="${!empty listOfLeaveRequest}">
				<table class="table table-striped " border="1">
					<tr>
						<th>SI no</th>
						<th>Emp name:</th>
						<th>Email</th>
						<th>From Date</th>
						<th>To date</th>
						<th>leaveDescription</th>
						<th>LeaveSatus</th>
						<td>action</td>
					</tr>
					<%int i = 1;%>
					<c:forEach var="leave" items="${listOfLeaveRequest}">
						<tr>
							<td><%=i++%></td>
							<td>${leave.empName}</td>
							<td>${leave.email }</td>
							<td>${leave.fromDate }</td>
							<td>${leave.toDate }</td>
							<td>${leave.reason}</td>
							<td>${leave.status }
							<td><a
								href="update_emp_leave_request?response=confirmed&empId=${leave.empId }">accept</a>&nbsp;<a
								href="update_emp_leave_request?response=Rejected&empId=${leave.empId }">reject</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
		</c:choose>
	</div>
   

</body></html>