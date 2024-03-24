<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Profile</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">

<style>
#div1 {
	width: fit-content;
	height: fit-content;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">

	 <link rel="stylesheet"  href="<c:url value='/css/nav-bar.css'/>">
 
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
	<h1 style="color: green; text-align: center;">Admin Info</h1>
	<div class="container" id="div1">
		<table align="center" class="table table-striped table-bordered">

			<tr>
				<td>AdminId</td>

				<td>${adminInfo.adminId }</td>
			</tr>
			<tr>
				<td>Name:</td>

				<td>${adminInfo.name }</td>
			</tr>
			<tr>
				<td>username:</td>

				<td>${adminInfo.username }</td>
			</tr>

		</table>
	</div>
</body>
</html>