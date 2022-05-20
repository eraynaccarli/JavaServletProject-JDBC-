<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"
    import = "java.sql.ResultSet"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> ADD CATEGORY </title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body style="background-color:tomato;">

	<center>
	<form action="/courseSelectionJDBC/register" method="POST" enctype="multipart/form-data">
		<br><br><br><br>
		<h1 style="font-size:160%;">REGISTER</h1> 
		<br><br>
		<input type = "file" name = "image">	
		<br><br><br>
		<input type = "text" name = "username" placeholder = "enter username... " size='40'> 
		<br><br>
			<input type = "password" name = "password" placeholder = "enter password... " size='40'> 
		<br><br>
		<input type = "submit" value = "ENTER" class = ""  style="height:70px; width:100px;"/>
	</form>
	</center>
</body>
</html>