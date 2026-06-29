<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mostrar Receta</title>
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
		<div class="row">
			<div class="card mb-3">
				<div class="row">
					<div class="col-4">
						<img src="${receta.urlImagen}" alt="receta" class="img-fluid" >
					</div>
					<div class="col-8">
						<div class="card-body">
						    <h5 class="card-title">${receta.nombre}</h5>
						    <p class="card-text"><b>Autor:</b>${receta.creador.nombre}</p>
						    <p class="card-text"><b>Descripción:</b>${receta.descripcion}</p>
						    <p class="card-text"><b>Pasos:</b>${receta.pasos}</p>
						    <p class="card-text"><b>Tiempo Preparación:</b>${receta.tiempoPreparacion}</p>
						    
						    <c:if test="${receta.creador.id == usuarioEnSesion.id}">
						    	<form action="/borrar/${receta.id}" method="POST">
						    		<input type="hidden" name="_method" value="DELETE" >
						    		<input type="submit" value="Eliminar" class="btn btn-danger" >
						    	</form>
						    </c:if>
						    
						    <!-- Agregar/Quitar fav -->
						    <c:if test="${not usuario.recetasFavoritas.contains(receta)}">
						    	<a href="/agregarFavoritos/${usuario.id}/${receta.id}" class="btn btn-info" >Agregar a Favoritos</a>
						    </c:if>
						    
						    <c:if test="${usuario.recetasFavoritas.contains(receta)}">
						    	<a href="/quitarFavoritos/${usuario.id}/${receta.id}" class="btn btn-danger">Quitar de Favoritos</a>
						    </c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<h2>Usuarios que agregaron a fav la receta</h2>
			<ul>
				<c:forEach items="${receta.usuariosFavoritos}" var="usuarioFav">
					<li>${usuarioFav.nombre} ${usuarioFav.apellido}</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>