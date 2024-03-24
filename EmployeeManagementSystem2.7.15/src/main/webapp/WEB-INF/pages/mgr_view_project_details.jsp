<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view project Details</title>
<link rel="stylesheet" 	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<style>
#div1 {
	 width: fit-content;
	margin-left: auto;
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
        <a href="show_emp_info"><span
							class="bi bi-person"></span>Employee</a>
        <a href="logout"><span
							class="bi bi-box-arrow-in-left"></span>Logout</a>
    </div>
</div>
<h3 style="color:green;text-align:center;">Project Details</h3>
 <c:choose>
 <c:when test="${!empty project_info}">
   <div class="container" id="div1">
			<table align="center" class="table table-bordered">
				<tr>
					<th>SI No</th>
					<th>MgrId</th>
					<th>managerName</th>
					<th>EmployeeName</th>
					<th>empId</th>
					<th>ProjectName</th>
					<th>status</th>
				</tr>
				 <%int i=1 ;%>
				 <c:forEach var="project" items="${project_info}">
					<tr>
					   
						<td><%=i++%></td>
						<td>${project.mgrId}</td>
						<td>${project.manager}</td>
						<td>${project.empName}</td>
						<td>${project.empId }</td>
						<td>${project.projectName }</td>
						<td><a href="check_project_status?empId=${project.empId}">status</a>
					</tr>
				</c:forEach>
			</table>
		</div>
 </c:when>
 </c:choose>
   
</body>
</html>

 