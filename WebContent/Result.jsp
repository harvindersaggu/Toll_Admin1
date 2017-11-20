<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Home Page</title>

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
	${msg} 
		<table border="1" align="center" cellpadding="5" cellspacing="0">
		<tr>
		<th>S.No</th>
		<th>Name</th>
		<th>Email</th>
		<th>Toll Name</th>
		<th>Status</th>
		<th>Expiry Date</th>
		</tr>
		
		<c:forEach items="list" items="${list}">
		<tr>
		<td><c:out value="${list.id}"></c:out></td>
		<td><c:out value="${list.username}"></c:out></td>
		<td><c:out value="${list.email}"></c:out></td>
		<td><c:out value="${list.choosetoll}"></c:out></td>
		<td><c:out value="${list.status}"></c:out></td>
		<td><c:out value="${list.expiryDate}"></c:out></td>
		</tr></c:forEach>
		</table>
		<hr>
	<h5> Toll Management System</h5>
	</div>
</body>
</html> 
