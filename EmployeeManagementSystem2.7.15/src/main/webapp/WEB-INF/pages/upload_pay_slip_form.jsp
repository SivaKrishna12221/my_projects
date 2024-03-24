<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>upload pay slip</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="<c:url value='/css/nav-bar.css'/>">
	
<style>
#div1 {
	width: fit-content;
	height: fit-content;
}
</style>

</head>
<body>
	<div class="navbar">
		<div class="navbar-left">
			<span class="navbar-title">Admin</span>
		</div>
		<div class="navbar-links">
			<a href="./admin_dashboard">Home</a> <a href="add_employee">Add
				Emp</a> <a href="view_employee">View Emp</a> <a href="view_manager">View
				Mgr</a> <a href="manager_assign">Manager Assign</a> <a
				href="view_queries">Queries</a> <a href="pay_slips">PaySlip</a>
		</div>
		<div class="navbar-right">
			<a href="show_admin_info">Profile</a> <a href="logout">Logout</a>
		</div>
	</div>
	
	<h1 style="color: green; text-align: center;">Upload PaySlip</h1>
	<div class="container" id="div1">
		<table align="center" class="table table-striped table-bordered">

			<f:form modelAttribute="pay_slip" name="frm"
				enctype="multipart/form-data">
				<f:hidden path="empId" />
				<tr>
					<td>Employee Name:</td>
				</tr>
				<tr>
					<td><f:input path="name" readOnly="true" /></td>
				</tr>
				<tr>
					<td>Date:</td>
				</tr>
				<tr>
					<td><f:input type="date" path="ld" /></td>
				</tr>

				<tr>
					<td>Pay Slip:</td>
				</tr>

				<tr>
					<td><f:input type="file" path="file" />
				</tr>
				<f:hidden path="id" />
				<tr>
					<td><input type="submit" value="submit" /> &nbsp;&nbsp;&nbsp;<input
						type="reset" value="reset" /></td>
				</tr>
			</f:form>
		</table>
	</div>
</body>
</html>


