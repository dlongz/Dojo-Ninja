<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>New Ninja</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container-sm">
		<nav class="nav">
			<a href="/" class="btn btn-primary mb-3 me-3">Home</a>
		</nav>
		<h1>New Ninja</h1>
		<form:form action="/ninja/new" method="post" modelAttribute="ninjaForm">
			<div>
				<form:label path="dojo">Dojo:</form:label>
				<form:select path="dojo">
					<c:forEach items="${allDojos}" var="dojos">
						<form:option value="${dojos.id}">${dojos.name}</form:option>
					</c:forEach>
				</form:select>
			</div>
			<div>
				<form:label path="firstName">First Name:</form:label>
				<form:errors path="firstName"/>
				<form:input path="firstName"/>
			</div>
			<div>
				<form:label path="lastName">Last Name:</form:label>
				<form:errors path="lastName"/>
				<form:input path="lastName"/>
			</div>
			<div>
				<form:label path="age">Age:</form:label>
				<form:errors path="age"/>
				<form:input path="age"/>
			</div>
			<input type="submit" value="Create" class="btn btn-success"/>
		</form:form>
	</div>
</body>
</html>