<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Apply leave</title>
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
	<h3 style="color: green; text-align: center;">Emp Query Form</h3>
	<div class="container" id="div1">
		<table align="center" class="table table-striped table-bordered">

			<f:form modelAttribute="help" name="frm">
				<f:hidden path="empId" />
				<tr>
					<td>Employee Name:</td>
				</tr>
				<tr>
					<td><f:input path="empName" readOnly="true" /></td>
				</tr>
				<tr>
					<td>Mobile No:</td>
				</tr>
				<tr>
					<td><f:input path="mobileNo" readOnly="true" /></td>
				</tr>
				<tr>
					<td>Email:</td>
				</tr>
				<tr>
					<td><f:input path="email" readOnly="true" /></td>
				</tr>
				<tr>
					<td>Message</td>
				</tr>

				<tr>
					<td><f:textarea path="message" cols="30" rows="3" />
				</tr>
                <f:hidden path="status"/>
                <f:hidden path="empId"/>
				<tr>
					<td><input type="submit" value="submit" />
					&nbsp;&nbsp;&nbsp;<input type="reset" value="reset" /></td>
				</tr>
			</f:form>
		</table>
	</div>
</body>
</html>


