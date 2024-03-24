<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Send Response </title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<style>

#div1 {
	width: fit-content;
	height: fit-content;
}
</style>
 <link rel="stylesheet" type="text/css" href="<c:url value='/css/nav-bar.css'/>">
 
</head>
<body>
<div class="navbar">
    <div class="navbar-left">
        <span class="navbar-title">admin</span>
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
	<h1 style="color: green; text-align: center;">Leave apply</h1>
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
					<td>Email:</td>
				</tr>
				<tr>
					<td><f:input path="email" readOnly="true" /></td>
				</tr>
				<tr>
					<td>Response</td>
				</tr>

				<tr>
					<td><f:textarea path="status" cols="30" rows="3" />
				</tr>
               <f:hidden path="adminId"/>
                <f:hidden path="msgId"/>
                <f:hidden path="mgrId"/>
				<tr>
					<td><input type="submit" value="submit" />
					&nbsp;&nbsp;&nbsp;<input type="reset" value="reset" /></td>
				</tr>
			</f:form>
		</table>
	</div>
</body>
</html>


