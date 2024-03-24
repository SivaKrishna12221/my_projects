<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>emp profile</title>

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
	<h1 style="color: green; text-align: center;">Emp Info</h1>
	<div class="container" id="div1">
		<table align="center" class="table table-striped table-bordered">

			<tr>
				<td>EmpId</td>

				<td>${empInfo.empId }</td>
			</tr>
			<tr>
				<td>Name:</td>

				<td>${empInfo.name }</td>
			</tr>
			<tr>
				<td>email:</td>

				<td>${empInfo.email }</td>
			</tr>
			<tr>
				<td>address:</td>

				<td>${empInfo.address }</td>
			</tr>
			<tr>
				<td>Manager:</td>

				<td>${empInfo.manager.name}</td>
			</tr>
			<tr>
				<td>Mobile:</td>

				<td>${empInfo.mobileNo }</td>
			</tr>
			<tr>
				<td>dob:</td>

				<td>${empInfo.dob }</td>
			</tr>
		</table>
	</div>
</body>
</html>