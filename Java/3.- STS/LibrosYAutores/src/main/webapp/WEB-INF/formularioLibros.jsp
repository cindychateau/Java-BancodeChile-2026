<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
	<main class="container">
		<div class="row">
			<div class="col-6">
				<h1>Nuevo Libro</h1>
				<form action="/procesa/libro" method="POST" >
					<input name="nombreLibro" class="form-control mb-3" placeholder="Nombre del Libro" >
					<input name="nombreAutor" class="form-control mb-3" placeholder="Nombre del Autor" >
					<input type="submit" class="btn btn-primary" value="Guardar Libro" >
				</form>
			</div>
		</div>
	</main>
</body>
</html>