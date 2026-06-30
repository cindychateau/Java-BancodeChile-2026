<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mis Compras</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<header class="d-flex justify-content-between align-items-center">
			<h1>¡Bienvenid@ ${usuarioEnSesion.nombre} !</h1>
			<a href="/dashboard" class="btn btn-primary">Películas</a>
			<a href="/nuevo" class="btn btn-success">Agregar Peli</a>
			<!-- Botón para ir a Mis Compras -->
			<a href="/mis-compras" class="btn btn-warning">Mis Compras</a>
			<a class="btn btn-danger" href="/logout" >Cerrar Sesión</a>
		</header>
		<div class="row">
			<h2>Mis compras</h2>
			<ul>
				<c:forEach items="${usuario.pelisCompradas}" var="pelicula">
					<li>${pelicula.titulo} (${pelicula.anio})</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>