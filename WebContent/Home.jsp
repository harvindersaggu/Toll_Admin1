<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
div {
	background-color: #e6f2ef;
	margin: auto;
	width: 60%;
	border: 3px solid grey;
	border-top-left-radius: 10px;
	border-top-right-radius: 10px;
	padding: 10px;
}

h4, h6, h7 {
	text-align: right;
}

h3 {
	padding-left: 20px;
	text-align: left;
}
</style>
</head>
<body>
	<div align="center">
		<h1>SuperAdmin</h1>

		<h4>
			<a href="Changepwd.jsp">Change password</a> | ${user}<br> <a
				href="logout.toll">Logout</a>
		</h4>
		<hr>

		<h3>${msg}</h3>
		<h3>
			<a href="Admin.jsp">Add Admin</a><br> <a href="Update.jsp">Update
				Details</a><br> <a href="Search.jsp">Search</a>
		</h3>
		<hr>
		<h5>Toll Management System</h5>
	</div>
</body>
</html>