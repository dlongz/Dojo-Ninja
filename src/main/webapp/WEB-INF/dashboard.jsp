<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>DoJos</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	
</head>
<body>
	<div class="container-sm">
		<nav class="nav">
			<a href="/dojos/new" class="btn btn-primary mb-3 me-3">New Dojo</a>
		</nav>
		<table class="table table-primary table-hovor table-striped col-3">
			<thead>
				<tr>
					<th>Name</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${Dojos}" var="dojo">
				<tr>
					<td><a href="/dojo/${dojo.id}"><c:out value="${dojo.name}"/></a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<a href="/ninja/new" class="btn btn-success">Add Ninja</a>
	</div>
</body>
</html>