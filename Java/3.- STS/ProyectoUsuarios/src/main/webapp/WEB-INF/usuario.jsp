<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mostrar Usuario</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
	<main class="container">
		<h1>Detalle del usuario</h1>
		<h2>${usuario.nombre} ${usuario.apellido}</h2>
		<h3>${usuario.email}</h3>
		<h4>Hobbies:</h4>
		<ul>
			<c:forEach items="${usuario.hobbies}" var="hobby">
				<li>${hobby.pasatiempo}</li>
			</c:forEach>
		</ul>
		<a href="/dashboard" class="btn btn-primary">Regresar</a>
	</main>
</body>
</html>