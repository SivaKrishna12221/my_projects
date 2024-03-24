<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Project</title>
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
   <h2 style="color: green; text-align: center;">Assign Project</h2><br>
	<div class="container" id="div1">
		<table align="center" class="table table-striped table-bordered">

			<f:form modelAttribute="proj">
				<f:hidden path="empId" />
				<f:hidden path="mgrId"/>
				<tr>
					<td>Employee Name:</td>
				</tr>
				<tr>
					<td><f:input path="empName" readOnly="true" /></td>
				</tr>
				<tr>
					<td>Email:</td>
				</tr>
				<tr>
					<td><f:input path="email" readOnly="true"/></td>
				</tr>
				<tr>
					<td>Project:</td>
				</tr>
				<tr>
					<td><f:input path="projectName" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="submit" />
				 &nbsp;&nbsp;	<input type="reset" value="reset" /></td>
				</tr>
			</f:form>
		</table>
	</div>
</body>
</html>




