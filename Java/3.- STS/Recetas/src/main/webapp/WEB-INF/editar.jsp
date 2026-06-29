<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar receta</title>
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
			<h2>Editar Receta</h2>
			<form:form action="/actualizar/${receta.id}" method="POST" modelAttribute="receta">
				<input type="hidden" name="_method" value="PUT" >
				<div>
					<form:label path="nombre">Nombre:</form:label>
					<form:input path="nombre" class="form-control" />
					<form:errors path="nombre" class="text-danger" />
				</div>
				<div>
					<form:label path="descripcion">Descripción:</form:label>
					<form:input path="descripcion" class="form-control" />
					<form:errors path="descripcion" class="text-danger" />
				</div>
				<div>
					<form:label path="pasos">Pasos:</form:label>
					<form:textarea path="pasos" class="form-control" />
					<form:errors path="pasos" class="text-danger" />
				</div>
				<div>
					<form:label path="urlImagen">URL Imagen:</form:label>
					<form:input path="urlImagen" class="form-control" />
					<form:errors path="urlImagen" class="text-danger" />
				</div>
				<div>
					<form:label path="tiempoPreparacion">Tiempo preparación:</form:label>
					<form:input path="tiempoPreparacion" class="form-control" type="number" />
					<form:errors path="tiempoPreparacion" class="text-danger" />
				</div>
				<form:hidden path="creador" value="${usuarioEnSesion.id}" />
				<input type="submit" value="Guardar" class="btn btn-success mt-3">
			</form:form>
		</div>
	</div>
</body>
</html>