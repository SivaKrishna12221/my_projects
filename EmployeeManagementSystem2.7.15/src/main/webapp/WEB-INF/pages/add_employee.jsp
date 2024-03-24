<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<style>
#div1 {
	width: fit-content;
	height: fit-content;
}
</style>

<link rel="stylesheet" href="<c:url value='/css/nav-bar.css'/>">
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

	<h1 style="color: green; text-align: center;">Add new Employee</h1>
	<p style="color: white; text-align: center">
		<blink>${message }</blink>
	</p>

	<div class="container" id="div1">
		<table align="center" class="table table-striped table-bordered">
			<f:form modelAttribute="emp" class="form-group">
				<tr>
					<td>FirstName:</td>
					<td>LastName</td>
				</tr>
				<tr>
					<td><f:input path="firstName" /><br>
					<f:errors path="firstName" cssStyle="color:red" /></td>
					<td><f:input path="lastName" /><br>
					<f:errors path="lastName" cssStyle="color:red" /></td>
				</tr>
				<tr>
					<td>DateOfBirth:</td>
					<td>MobileNumber:</td>
				</tr>
				<tr>
					<td><f:input type="date" path="dob" /><br>
					<f:errors path="dob" cssStyle="color:red" /></td>
					<td><f:input path="mobileNo" /><br>
					<f:errors path="mobileNo" cssStyle="color:red" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><f:input type="email" path="email" width="100%" /><br>
					<f:errors path="email" cssStyle="color:red" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td>ConfirmPassword:</td>
				</tr>
				<tr>
					<td><f:input type="password" path="password" /><br>
					<f:errors path="password" cssStyle="color:red" /></td>
					<td><f:input type="password" path="confirmPassword" /><br>
					<f:errors path="confirmPassword" cssStyle="color:red" /></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td>City:</td>
				</tr>
				<tr>
					<td><f:input path="address" /><br>
					<f:errors path="address" cssStyle="color:red" /></td>
					<td><f:select path="city">
							<f:options items="${cities }" />
						</f:select> <br>
					<f:errors path="city" cssStyle="color:red" /></td>
				</tr>
				<tr>
				<tr>
					<td>State:</td>
					<td>Pincode:</td>
				</tr>
				<tr>
					<td><f:select path="state">
							<f:options items="${states }" />
						</f:select> <br>
					<f:errors path="state" cssStyle="color:red" /></td>
					<td><f:input path="pincode" /><br>
					<f:errors path="pincode" /></td>

				</tr>

				<tr>
					<td>Role:</td>
					<td><f:select path="role">
							<f:option value="employee">Employee</f:option>
							<f:option value="manager"> Manager</f:option>
						</f:select></td>
					<f:hidden path="admId" />
				</tr>
				<tr>
					<td><input type="submit" value="add" /></td>
					<td><input type="reset" value="cancel" /></td>
				</tr>
			</f:form>
		</table>

	</div>
</body>
</html>

