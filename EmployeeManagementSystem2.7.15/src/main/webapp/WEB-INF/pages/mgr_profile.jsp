<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager Details</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">

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
        <a href="show_mgr_info"><span
							class="bi bi-person"></span>Manager</a>
        <a href="logout"><span
							class="bi bi-box-arrow-in-left"></span>Logout</a>
    </div>
</div>
<h1 style="color: green; text-align: center;">Manager Info</h1>
	<div class="container" id="div1">
		<table  class="table table-striped table-bordered">

			<tr>
				<td>MgrId</td>

				<td>${mgrInfo.mgrId }</td>
			</tr>
			<tr>
				<td>Name:</td>

				<td>${mgrInfo.name }</td>
			</tr>
			<tr>
				<td>email:</td>

				<td>${mgrInfo.email }</td>
			</tr>
			<tr>
				<td>address:</td>

				<td>${mgrInfo.address }</td>
			</tr>
			
			<tr>
				<td>Mobile:</td>

				<td>${mgrInfo.mobileNo }</td>
			</tr>
			<tr>
				<td>dob:</td>

				<td>${mgrInfo.dob }</td>
			</tr>
		</table>
	</div>
</body>
</html>