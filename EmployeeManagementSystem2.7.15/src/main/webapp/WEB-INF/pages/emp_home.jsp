<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Home</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
	margin: 0;
	padding: 0;
}

.container {
	max-width: 800px;
	margin: 50px auto;
	text-align: center;
}

h1 {
	color: #333;
}

.links {
	margin-top: 20px;
}

.links a {
	display: inline-block;
	margin: 10px;
	padding: 10px 20px;
	text-decoration: none;
	color: #fff;
	background-color: #007bff;
	border-radius: 5px;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Employee Home</h1>
		<h2 style="color: green; align: center;">${message }</h2>
		<div class="links">
			<a href="emp_login">Sign Up</a>
		</div>
	</div>
</body>
</html>
