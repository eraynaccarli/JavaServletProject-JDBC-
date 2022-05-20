<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"
    %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> LOGIN </title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body style="background-color:tomato;">
	<center>
	<form action="/courseSelectionJDBC/login" method="POST"">
	<br><br>
	<p style="font-size:160%;">LOGIN</p>
		<br><br><br>
	<input name = "username" type = "text" placeholder = "enter username..." size='40'>
	<br><br>
	<input name = "password" type = "password" placeholder = "enter password..." size='40'>
	<br><br>
	<input type = "submit" value = "Login" class=" " style="height:70px; width:100px;">
	
</form>
</body>
	</center>
</html>