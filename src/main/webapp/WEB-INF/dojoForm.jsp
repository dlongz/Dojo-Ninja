<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>New Dojo</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	
</head>
<body>
	<div class="container-sm">
		<h1>New Dojo</h1>
		<form:form action="/dojos/new" method="post" modelAttribute="dojoForm">
			<div>
				<form:label path="name" class="form-label">Name: </form:label>
				<form:errors path="name"/>
				<form:input path="name" class="form-control" />
			</div>
			<input type="submit" value="Create" class="btn btn-success"/>
		</form:form>
	</div>
</body>
</html>