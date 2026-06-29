<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Mascota</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">
</head>
<body>

	<div class="container mt-3">
		<nav class="d-flex justify-content-between align-items-center border botton pb-2 mb-4">
			<a href="/dashboard" class="btn btn-link">Mascotas</a>
			<a href="/mascotas/nueva" class="btn btn-link">Agregar mascota</a>
			<a href="/perfil" class="btn btn-link">Mi perfil</a>
			<form action="/logout" method="post" class="d-inline">
				<button class="btn btn-outline-danger btn-sm">Logout</button>
			</form>
		</nav>
		
		<h2>Agregar mascota</h2>
		
		<form:form action="/mascotas/crear" method="post" modelAttribute="mascota">
			<div class="mb-3">
				<form:label path="nombre">Nombre</form:label>
				<form:input path="nombre" class="form-control"/>
				<form:errors path="nombre" class="text-danger"/>
			</div>
			<div class="mb-3">
				<form:label path="especie">Especie</form:label>
				<form:input path="especie" class="form-control"/>
				<form:errors path="especie" class="text-danger"/>
			</div>
			<div class="mb-3">
				<form:label path="raza">Raza</form:label>
				<form:input path="raza" class="form-control"/>
				<form:errors path="raza" class="text-danger"/>
			</div>
			<div class="mb-3">
				<form:label path="edad">Edad</form:label>
				<form:input path="edad" type="number" class="form-control"/>
				<form:errors path="edad" class="text-danger"/>
			</div>
			<div class="mb-3">
				<form:label path="descripcion">Descripción</form:label>
				<form:textarea path="descripcion" class="form-control"/>
				<form:errors path="descripcion" class="text-danger"/>
			</div>
			<div class="mb-3">
				<form:label path="urlImagen">URL de la imagen</form:label>
				<form:input path="urlImagen" class="form-control" placeholder="https://...foto.jpg"/>
				<form:errors path="urlImagen" class="text-danger"/>
			</div>
			<div class="form-check mb-3">
				<form:checkbox path="esterilizado" class="form-check-input"/>
				<form:label path="esterilizado" class="form-check-label">¿Está esterilizada?</form:label>
			</div>
			<button class="btn btn-primary">Agregar</button>
			
		</form:form>
	</div>

</body>
</html>