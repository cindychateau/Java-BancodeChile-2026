<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
	<main class="container">
		<header>
			<h1>¡Bienvenida al Dashboard!</h1>
			<!-- Botón para crear un nuevo usuario -->
			<a href="/nuevo" class="btn btn-info">Crear nuevo usuario</a>
		</header>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Email</th>
					<th>Curso</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usuarios}" var="usuario" >
				<tr>
					<td>${usuario.nombre}</td>
					<td>${usuario.apellido}</td>
					<td>${usuario.email}</td>
					<td>${usuario.curso.nombreCurso}</td>
					<td>
						<a href="/usuario/${usuario.id}" class="btn btn-primary" >Ver</a>
						<form action="/borrar/${usuario.id}" method="POST">
							<!-- Forzamos a que la solicitud sea DELETE -->
							<input type="hidden" name="_method" value="DELETE">
							<input type="submit" value="Borrar" class="btn btn-danger" >
						</form>
						<a href="/editar/${usuario.id}" class="btn btn-info">Editar</a>
					</td>
				</tr>
				</c:forEach>	
			</tbody>
		</table>
	</main>
</body>
</html>