<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mostrar Película</title>
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
			<div class="col-8">
				<div class="card mb-3">
					<div class="row">
						<div class="col-4">
							<img src="${pelicula.urlImagen}" alt="pelicula" class="img-fluid" >
						</div>
						<div class="col-8">
							<div class="card-body">
							    <h5 class="card-title">${pelicula.titulo}</h5>
							    <p class="card-text"><b>Director:</b>${pelicula.director}</p>
							    <p class="card-text"><b>Año:</b>${pelicula.anio}</p>
							    <p class="card-text"><b>Sinopsis:</b>${pelicula.sinopsis}</p>
							    <p class="card-text"><b>Usuario creador:</b>${pelicula.creador.nombre}</p>
							    <!-- BONUS: botón para comprar -->
							    <c:if test="${not usuario.pelisCompradas.contains(pelicula) }">
							    	<a class="btn btn-success" href="/comprar/${usuario.id}/${pelicula.id}">Comprar</a>
							    </c:if>
							    <c:if test="${usuario.pelisCompradas.contains(pelicula)}">
							    	<a class="btn btn-danger" href="#">Comprada!</a>
							    </c:if>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Compradores -->
		<div class="row">
			<h2>Usuarios que han comprado la película</h2>
			<ul>
				<c:forEach items="${pelicula.compradores}" var="comprador">
					<li>${comprador.nombre} ${comprador.apellido}</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>