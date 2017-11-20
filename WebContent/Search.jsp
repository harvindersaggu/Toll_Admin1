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
	border-radius: 10px;
	padding: 10px;
}
select {
    padding: 16px 20px;
    border: 2px solid grey;
    border-radius: 4px;
    background-color: #f1f1f1;
    width: 22%;
    height: 5%
}
input[type=text],input[type=email] {
    padding: 12px 20px;
    margin: 8px 0;
    border: 2px solid grey;
    border-radius: 4px;
    box-sizing: border-box;
    width: 40%;
    height: 3%;
}
input[type=submit] {
    padding: 12px 20px;
    margin: 8px 0;
    border: 2px solid grey;
    border-radius: 4px;
    box-sizing: border-box;
    width: 20%;
    height: 3%;
}
h1 {
	text-align: center;
}
h4,h6,h7{
text-align: right;
}
</style>
</head>
<body>
	
	<div align="center">
	<h1>Search Admin</h1>
	<h4><a href="Changepwd.jsp">Change password</a> | ${user}<br>
<a href="logout.toll">Logout</a></h4>
<hr>
		<form action="search.toll" method="post">
		${msg} 
			<br> Name:<input type="text" name="username"><br>
			<font style="text-align: center">OR</font>
			<br> Email:<input type="text" name="email"><br>
			<br> Toll Name:<input type="text" name="choosetoll"><br>
			<input type="submit" value="Search"><br>
			<br>
		</form>
		<hr>
	<h5> Toll Management System</h5>
	</div>
</body>
</html> 

</body>
</html>