<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Status</title>
<style>

</style>
		 <link rel="stylesheet" type="text/css" href="<c:url value='/css/nav-bar.css'/>">
 
</head>
<body>
<div class="navbar">
    <div class="navbar-left">
        <span class="navbar-title">Employee </span>
    </div>
    <div class="navbar-links">
        <a href="./admin_dashboard">Home</a>
        <a href="add_employee">Add Emp</a>
        <a href="view_employee">View Emp</a>
        <a href="view_manager">View Mgr</a>
        <a href="manager_assign">Manager Assign</a>
        <a href="view_queries">Queries</a>
        <a href="pay_slips">paySlip</a>
    </div>
    <div class="navbar-right">
        <a href="show_emp_info">Employee</a>
        <a href="logout">Logout</a>
    </div>
</div>
	<h1 align="center" color="green">Project Status</h1>
	<h2 align="center">Manager:${manager.name}</h2>
	<div class="container" id="div1">
		<table align="center" class="table table-striped table-bordered">
			
			<tr>
				<td>
					<div class="" id="div1" width="100" height="100" align="left">
						<c:choose>
							<c:when test="${!empty messages }">
								<ul>
									<c:forEach var="msg" items="${messages }">
										<li>${msg.respone}</li>
									</c:forEach>
								</ul>
							</c:when>

						</c:choose>
					</div>
				</td>
				<td>
			
				<td> 
					<div class="" id="div1" width="100" height="100",align="right">
						<c:choose>
							<c:when test="${!empty messages }">
								<ul>
									<c:forEach var="msg" items="${messages }">
										<li>${msg.message}</li>
									</c:forEach>
								</ul>
							</c:when>

						</c:choose>
					</div>
				</td>
			</tr>

			
		</table>
		<table align="center">
			<tr>
				<td><f:form modelAttribute="status" action="send_project_status" >
						<f:input path="message" width="70%" placeholder="enter message" id="form" />
						<f:hidden path="empId" value="${empId }"/>
						<f:hidden path="mgrId" value="${manager.mgrId }"/>
						</td>
				<td><input type="submit" value="send" width="30%" id="form" /></td>
				</f:form>
			</tr>
			</table>
	</div>
</body>
</html>
