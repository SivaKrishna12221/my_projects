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
/* li {
	list-style: none;
}

.container {
	border: 2px solid;
	width: 450px;
	height: 300px;
	margin: auto;
	background-color: #e0c99f;
	color: #fff;
	position: relative;
	top: -34px;
}

#form {
	position: relative;
	top: 209px;
	left: 72px;
}

h2 {
	width: 449px;
	height: 31px;
	background-color: green;
	position: relative;
	left: 279px;
	top: -13px;
} */
</style>
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"> -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/nav-bar.css'/>">

</head>
<body>
	<div class="navbar">

		<div class="navbar-links">
			<a href="./manager_dashboard">Home</a> <a href="emp_details">Employees</a>
			<a href="project_details">Project</a> <a href="show_employee_leaves">Employee
				Leaves</a> <a href="send_query">Help Desk</a> <a
				href="show_mgr_query_status">Query Status</a> <a
				href="show_mgr_pay_slip">PaySlip</a>
		</div>
		<div class="navbar-right">
			<a href="show_mgr_info"><span class="bi bi-person"></span>Manager</a>
			<a href="logout"><span class="bi bi-box-arrow-in-left"></span>Logout</a>
		</div>
	</div>
	<h1 align="center" color="green">Project Status</h1>
	<h3 align="center">Employee:${emp_info.name}</h3>
	<div class="container" id="div1">
		<table align="center" class="table table-striped table-bordered">

			<tr>
				<td>
					<div class="" id="div1" align="left">
						<c:choose>
							<c:when test="${!empty proj_status}">
								<ul>
									<c:forEach var="status_info" items="${proj_status}">
										<li>${status_info.message}</li>
									</c:forEach>
								</ul>
							</c:when>

						</c:choose>
					</div>
				</td>
				<td>
				<td>
					<div class="" id="div1" align="right">
						<c:choose>
							<c:when test="${!empty proj_status}">
								<ul>
									<c:forEach var="status_info" items="${proj_status}">
										<li>${status_info.respone}</li>
									</c:forEach>
								</ul>
							</c:when>

						</c:choose>
					</div>
				</td>
			</tr>

			<tr>

			        <f:form modelAttribute="status"
						action="send_project_status_response">
						<td><f:input path="response" width="70%" placeholder="enter response"
							id="form" /></td>
						<f:hidden path="empId" value="${emp_info.empId }" />
						<f:hidden path="mgrId" value="${emp_info.manager.mgrId}" />
				<td><input type="submit" value="send" width="30%" id="form" /></td>
				</f:form>
				
				
			</tr>
		</table>
	</div>
</body>
</html>