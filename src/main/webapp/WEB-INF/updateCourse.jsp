<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"
	import="java.sql.ResultSet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD COURSE</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<body style="background-color: tomato;">

	<center>
		<a href="/courseSelectionJDBC/menu.jsp"> <input type="submit"
			value="MENU" class="" style="height: 70px; width: 200px;" /></a>
		<form action="/courseSelectionJDBC/UpdateCourse" method="POST">
			<h1 style="font-size: 160%;">UPDATE COURSE</h1>
			<br>
			<br> <input type="text" name="name"
				placeholder="enter new course name... " size='40'> <br>
			<br> <input type="text" name="code"
				placeholder="enter new course code... " size='40'> <br>
			<br> <select name="id">
				<c:forEach items="${courses}" var="course">
					<%-- var = user dongude her iceri geldigimde kullanacagim degisken for'daki i --%>
					<option value="${course.id}">${ course.name}</option>
				</c:forEach>
			</select> <br>
			<br> <input type="submit" value="UPDATE" class=""
				style="height: 70px; width: 200px;" />


		</form>
	</center>
</body>
</html>