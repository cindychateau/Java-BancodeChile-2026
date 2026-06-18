<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenida</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
	<main class="container">
		<div class="row">
			<div class="col-12">
				<h1>¡Bienvenida al sitio web de Proyecto Usuarios!</h1>
				<h2>Nombre de Usuario: ${usuario}</h2> <!-- variables de sesión -->
				<h3>E-mail de Usuario: ${email}</h3>
				<a class="btn btn-danger" href="/usuarios/cerrar" >
					Cerrar Sesión
				</a>
			</div>
		</div>
	</main>
</body>
</html>