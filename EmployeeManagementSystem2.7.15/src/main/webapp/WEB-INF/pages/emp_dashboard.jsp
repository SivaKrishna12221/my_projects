<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Dash board</title>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<style>


</style>
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
			<a class="navbar-brand" ><span class="bi bi-mortarboard-fill"></span>Employee </a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="./emp_dashboard"><span class="bi bi-house"></span>Home</a>
					</li>
				</ul>
			</div>
			<!-- other part -->
			<div class="collapse navbar-collapse" style="padding-left: 20rem;"
				id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="show_emp_info"><span
							class="bi bi-person"></span>Employee</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="logout"><span
							class="bi bi-box-arrow-in-left"></span>Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<h2 style="color: green; text-align: center;">Employee Services</h2>
	<div class="conntainer-fluid  mt-5" style="margin-left: 10rem;">
		<div class="row ">
			<div class="col-3  text-center border border-black p-2 m-1">
				<span class="bi bi-person-workspace"></span>
				<h5>
					<a href="project_details" style="text-decoration: none;">
						project</a>
				</h5>
			</div>
			<div class="col-3 text-center border border-black  p-2 m-1">
				<span class="bi bi-patch-question"></span>
				<h5>
					<a href="leave_apply" style="text-decoration: none;">
						Leave</a>
				</h5>
			</div>
			<div class="col-3  text-center border border-black p-2 m-1">
				<span class="bi bi-chat-left-text-fill"></span>
				<h5>
					<a href="show_leave_status" style="text-decoration: none;">View
						Leave status</a>
				</h5>
			</div>
		</div>
		<!-- another row -->
		<div class="row ">
			<div class="col-3  text-center border border-black p-2 m-1">
				<span class="bi bi-exclamation-circle"></span>
				<h5>
					<a href="send_query" style="text-decoration: none;">Help Desk
						</a></h5>
			</div>
			<div class="col-3  text-center border border-black  p-2 m-1">
				<span class="bi bi-question-diamond-fill"></span>
				<h5>
					<a href="show_emp_query_status" style="text-decoration: none;">
						Query Status</a>
				</h5>
			</div>
			<div class="col-3  text-center border border-black p-2 m-1">
				<span class="bi bi-question-circle-fill"></span>
				<h5>
					<a href="pay_slip" style="text-decoration: none;">Pay Slip</a>
				</h5>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>






