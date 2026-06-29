<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard - Patitas a la Obra</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">
</head>
<body>
	<div class="container mt-3">
		<nav class="d-flex justify-content-between align-items-center border-bottom pb-2 mb-4">
			<h3 class="m-0">Patitas a la Obra</h3>
			<div>
				<a href="/dashboard" class="btn btn-link">Mascota</a>
				<a href="/mascotas/nueva" class="btn btn-link">Agregar mascota</a>
				<a href="/perfil" class="btn btn-link">Mi Perfil</a>
				<form action="/logout" method="post" class="d-inline">
					<button class="btn btn-outline-danger btn-sm">Logout</button>
				</form>
			</div>
		</nav>
	
		<h2>Bienvenid@ de vuelta ${usuarioEnSesion.nombre}</h2>
		
		<table class="table table-hover mt-3">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Especie</th>
					<th>Edad</th>
					<th>Esterilizado</th>
					<th>Detalle</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${mascotas}" var="mascota">
					<tr>
						<td>${mascota.nombre}</td>
						<td>${mascota.especie}</td>
						<td>${mascota.edad}</td>
						<td>
							<c:choose>
								<c:when test="${mascota.esterilizado}">Sí</c:when>
								<c:otherwise>No</c:otherwise>
							</c:choose>
						</td>
						<td>
							<a href="/mascotas/${mascota.id}" class="btn btn-primary btn-sm">
								Ver
							</a>
							<a href="/mascotas/${mascota.id}/editar" class="btn btn-warning btn-sm">Editar</a>
			
							<form action="/mascotas/${mascota.id}" method="post" class="d-inline">
								<input type="hidden" name="_method" value="DELETE">
								<button class="btn btn-danger btn-sm">Eliminar mascota</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>