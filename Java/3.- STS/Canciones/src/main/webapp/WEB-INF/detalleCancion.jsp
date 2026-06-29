<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle Canción</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
	<main class="container">
		<h1>${cancion.titulo}</h1>
		<h2>${cancion.artista}</h2>
		<p><strong>Album:</strong> ${cancion.album}</p>
		<p><strong>Género:</strong> ${cancion.genero}</p>
		<p><strong>Idioma:</strong> ${cancion.idioma}</p>
		<a href="/canciones" class="btn btn-success">Volver a lista de canciones</a>
		<a href="/canciones/formulario/editar/${cancion.id}" class="btn btn-warning">Editar</a>
		<form action="/canciones/eliminar/${cancion.id}" method="POST">
			<input type="hidden" name="_method" value="DELETE">
			<input type="submit" value="Eliminar" class="btn btn-danger" >
		</form>
	</main>
</body>
</html>