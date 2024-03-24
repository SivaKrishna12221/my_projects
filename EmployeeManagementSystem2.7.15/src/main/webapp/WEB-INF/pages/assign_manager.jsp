<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
	<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
	
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
        <span class="navbar-title">Admin </span>
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
        <a href="show_admin_info" class="bi bi-person-fill">profile</a>
        <a href="logout">Logout</a>
    </div>
</div>

	<script language="JavaScript">
		function managerConfirmation(){
			frm.assignAction.value="Assigned";
		}
	</script>
	<h1 style="color: green; text-align: center;">Assign manager</h1>
	<div class="container" id="div1">
		<table align="center" class="table table-striped table-bordered">

			<f:form modelAttribute="mgr" name="frm" onsubmit="managerConfirmation(this)">
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
					<td><f:input path="empMail" readOnly="true" /></td>
				</tr>
				<tr>
					<td>Manager:</td>
				</tr>
				<tr>
				 <f:hidden path="assignAction"/>
					<td><f:select path="managerName">
							<f:options items="${managers}" />
						</f:select></td>
				</tr>
				<tr>
				<td>	<input type="submit" value="submit"/>&nbsp;
					<input type="reset" value="reset"/></td>
				</tr>
			</f:form>
		</table>
	</div>
</body>
</html>

<body>