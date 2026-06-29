<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${mascota.nombre} - Detalle</title>
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
	</div>
	
	<h2>${mascota.nombre}</h2>
	
	<div class="row">
		<div class="col-md-5">
			<img src="${mascota.urlImagen}" class="img-fluid rounded" alt="foto mascota">
		</div>
		
		<div class=col-md-7">
			<p><strong>Publicado por:</strong>
				${mascota.publicadoPor.nombre} ${mascota.publicadoPor.apellido}
			</p>
			<p>
				<strong>Raza: </strong> ${mascota.raza}
			</p>
			<p>
				<strong>Edad: </strong> ${mascota.edad}
			</p>
			<p>
				<strong>Esterilizada: </strong>
				<c:choose>
					<c:when test="${mascota.esterilizado}">Sí</c:when>
					<c:otherwise>No</c:otherwise>
				</c:choose>
			</p>
			<p>
				<strong>Descripción: </strong> ${mascota.descripcion}
			</p>
			
			<a href="/mascotas/${mascota.id}/editar" class="btn btn-warning">Editar</a>
			
			<form action="/mascotas/${mascota.id}" method="post" class="d-inline">
				<input type="hidden" name="_method" value="DELETE">
				<button class="btn btn-danger">Eliminar mascota</button>
			</form>
			
		</div>
	
	</div>

</body>
</html>