<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<header class="d-flex justify-content-between align-items-center">
			<h1>¡Bienvenid@ ${usuarioEnSesion.nombre} !</h1>
			
			<a href="/favoritas">Recetas Favoritas</a>
			
			<a href="/dashboard">Todas Recetas</a>
			
			<a href="/nuevo">Agregar Receta</a>
			
			<a class="btn btn-danger" href="/logout" >Cerrar Sesión</a>
		</header>
		<form action="/buscar" method="GET">
			<div class="input-group mb-3">
			  <input type="text" class="form-control" placeholder="Buscar..." name="palabra">
			  <button class="btn btn-primary" type="submit" id="button-addon2">Buscar</button>
			</div>
		</form>
		<div class="row">
			<div class="col-8">
				<c:forEach items="${recetas}" var="receta">
					<div class="card mb-3">
						<div class="row">
							<div class="col-4">
								<img src="${receta.urlImagen}" alt="receta" class="img-fluid" >
							</div>
							<div class="col-8">
								<div class="card-body">
								    <h5 class="card-title"><a href="/mostrar/${receta.id}">${receta.nombre}</a></h5>
								    <p class="card-text"><b>Autor:</b>${receta.creador.nombre}</p>
								    <p class="card-text"><b>Tiempo Preparación:</b>${receta.tiempoPreparacion}</p>
								    <!-- Solamente aquel que creó la peli, puede ver el botón editar -->
								    <c:if test="${receta.creador.id == usuarioEnSesion.id}">
								    	<a href="/editar/${receta.id}" class="btn btn-primary">Editar</a>
								    </c:if>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>