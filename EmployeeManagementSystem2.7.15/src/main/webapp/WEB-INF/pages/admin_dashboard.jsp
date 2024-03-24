<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
   <link rel="stylesheet" type="text/css" href="<c:url value='/css/nav-bar.css'/>">
 
</head>

<body>
	<nav class="navbar navbar-expand-lg "
		style="background-color: rgb(39, 220, 132);">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"><span class="bi bi-mortarboard-fill"></span>Employee Management System</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="./home"><span class="bi bi-house"></span>Home</a>
					</li>
				</ul>
			</div>
			<!-- other part -->
			<div class="collapse navbar-collapse" style="padding-left: 20rem;"
				id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="show_admin_info"><span
							class="bi bi-person-circle"></span>Admin</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="./home"><span
							class="bi bi-box-arrow-in-left"></span>Home</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<h2 style="color: green; text-align: center;">Admin Services</h2>
	<div class="conntainer-fluid  mt-5" style="margin-left: 10rem;">
		<div class="row ">
			<div class="col-3  text-center border border-black p-2 m-1">
				<span class="bi bi-person-add"></span>
				<h5>
					<a href="add_employee" style="text-decoration: none;">Add
						Employee</a>
				</h5>
			</div>
			<div class="col-3 text-center border border-black  p-2 m-1">
				<span class="bi bi-people"></span>
				<h5>
					<a href="view_employee" style="text-decoration: none;">View
						Employee</a>
				</h5>
			</div>
			<div class="col-3  text-center border border-black p-2 m-1">
				<span class="bi bi-people"></span>
				<h5>
					<a href="view_manager" style="text-decoration: none;">View
						Manager</a>
				</h5>
			</div>
		</div>
		<!-- another row -->
		<div class="row ">
			<div class="col-3  text-center border border-black p-2 m-1">
				<span class="bi bi-node-plus"></span>
				<h5>
					<a href="manager_assign" style="text-decoration: none;">Manager
						Assign</a></53>
			</div>
			<div class="col-3  text-center border border-black  p-2 m-1">
				<span class="bi bi-patch-question"></span>
				<h5>
					<a href="view_queries" style="text-decoration: none;">View
						Queries</a>
				</h5>
			</div>
			<div class="col-3  text-center border border-black p-2 m-1">
				<span class="bi bi-question-diamond-fill"></span>
				<h5>
					<a href="pay_slips" style="text-decoration: none;">Pay Slip</a>
				</h5>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>


