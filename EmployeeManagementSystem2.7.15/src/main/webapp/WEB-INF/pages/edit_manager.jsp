<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
    
<!DOCTYPE html>
<html>
<head>
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
    <div class="navbar-left">
        <span class="navbar-title">Admin</span>
    </div>
    <div class="navbar-links">
        <a href="./admin_dashboard">Home</a>
        <a href="add_employee">Add Emp</a>
        <a href="view_employee">View Emp</a>
        <a href="view_manager">View Mgr</a>
        <a href="manager_assig">Manager Assign</a>
        <a href="view_queries">Queries</a>
        <a href="pay_slips">PaySlip</a>
    </div>
    <div class="navbar-right">
        <a href="show_admin_info">Profile</a>
        <a href="logout">Logout</a>
    </div>
</div>
<h1 style="color:green;text-align:center;">Edit Manager Details</h1>

<br>
<p style="color:white;text-align:center"><blink>${message }</blink></p>
<div class="container" id="div1">
	<table align="center" class="table table-striped table-bordered">
		<f:form modelAttribute="emp" class="form-group">
			<tr>
				<td>FirstName:</td>
				<td>LastName:</td>
			</tr>
			<tr>
			    <f:hidden path="empId"/>
				<td><f:input path="firstName" /><br><f:errors path="firstName" cssStyle="color:red"/></td>
				<td><f:input path="lastName" /><br><f:errors path="lastName" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td>DateOfBirth:</td>
				<td>MobileNumber:</td>
			</tr>
			<tr>
				<td><f:input type="date" path="dob" /></td>
				<td><f:input path="mobileNo" /><br><f:errors path="mobileNo" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><f:input type="email" path="email" width="100%" /><br><f:errors path="email" cssStyle="color:red"/></td>
				<f:hidden path="password"/>
					<f:hidden path="confirmPassword"/>
				
			</tr>
			
			<tr>
				<td>Address:</td>
				<td>City:</td>
			</tr>
			<tr>
				<td><f:input path="address" /><br><f:errors path="address" cssStyle="color:red"/></td>
				<td><f:select path="city">
						<f:options items="${cities }" />
					</f:select><br><f:errors path="city" cssStyle="color:red"/></td>
			</tr>
			<tr>
			<tr>
				<td>State:</td>
				<td>Pincode:</td>
			</tr>
			<tr>
				<td><f:select path="state">
						<f:options items="${states}" />
					</f:select><br><f:errors path="state" cssStyle="color:red"/></td>
				<td><f:input path="pincode"/><br><f:errors path="pincode" cssStyle="color:red"/></td>

			</tr>
		<tr>
				<td><input type="submit" value="save" /></td>
				<td><input type="reset" value="cancel" /></td>
			</tr>
		</f:form>
	</table>
</div>

</body>
</html>