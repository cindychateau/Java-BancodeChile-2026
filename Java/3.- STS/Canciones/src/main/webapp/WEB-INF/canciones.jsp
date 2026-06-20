<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Canciones</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
	<main class="container">
		<h1>Lista de Canciones</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Título</th>
					<th>Artista</th>
					<th>Detalle</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${canciones}" var="cancion">
					<tr>
						<td>${cancion.titulo}</td>
						<td>${cancion.artista}</td>
						<td>
							<a href="/canciones/detalle/${cancion.id}" class="btn btn-success">Detalle</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>