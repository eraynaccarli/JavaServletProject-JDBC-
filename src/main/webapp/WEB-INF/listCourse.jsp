<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DEPARTMENT LIST</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body style = "background-color:tomato;">
<center>		
		<a href = "/courseSelectionJDBC/menu.jsp"> <input type = "submit" value = "MENU" class = "" style="height:70px; width:200px;"> </a>
		<a href = "/courseSelectionJDBC/addCourseView"> <input type = "submit" value = "Add Course" class = "" style="height:70px; width:200px;"> </a>
</center>

<h1 style = "color:	#F5F5F5;font-size:400%;">COURSE LIST</h1>
	<br><br>
	
	<ul>
	<c:forEach items = "${courses}" var = "course">
	<li>
	<h1 style = "font-size:200%;">${course.name }</h1>
	<p style = "font-size:150%;">${course.code }</p>
	<p style = "font-size:150%;">Category: ${course.department.name }</p>
	</li>
	<br>
	</c:forEach>
	</ul>



</body>
</html>