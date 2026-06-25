<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Asignar Hobbies</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
	<main class="container">
		<h1>Asignar hobbies a: ${usuario.nombre}</h1>
		<a href="/dashboard" class="btn btn-info">Regresar a Dashboard</a>
		<hr>
		<h2>Hobbies</h2>
		<table class="table">
			<thead>
				<tr>
					<th>Pasatiempo</th>
					<th>Acción</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${hobbies}" var="hobby" >
					<tr>
						<td>${hobby.pasatiempo}</td>
						<td>
							<!-- Botón para asignar el hobby -->
							<c:if test="${not usuario.hobbies.contains(hobby)}">
								<a href="/asignarHobby/${usuario.id}/${hobby.id}" class="btn btn-warning">Asignar Hobby</a>
							</c:if>
							
							<c:if test="${usuario.hobbies.contains(hobby)}">
								<a href="/quitarHobby/${usuario.id}/${hobby.id}" class="btn btn-danger">Quitar Hobby</a>
							</c:if>
							
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>