<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva Canción</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
	<main class="container">
		<h1>Nueva Canción</h1>
		<form:form action="/canciones/procesa/agregar" method="POST" modelAttribute="nuevaCancion" >
			<div>
				<form:label path="titulo">Título: </form:label>
				<form:input path="titulo" class="form-control" />
				<form:errors path="titulo" class="text-danger" />
			</div>
			<div>
				<form:label path="artista">Artista: </form:label>
				<form:input path="artista" class="form-control" />
				<form:errors path="artista" class="text-danger" />
			</div>
			<div>
				<form:label path="album">Album: </form:label>
				<form:input path="album" class="form-control" />
				<form:errors path="album" class="text-danger" />
			</div>
			<div>
				<form:label path="genero">Género: </form:label>
				<form:input path="genero" class="form-control" />
				<form:errors path="genero" class="text-danger" />
			</div>
			<div>
				<form:label path="idioma">Idioma: </form:label>
				<form:input path="idioma" class="form-control" />
				<form:errors path="idioma" class="text-danger" />
			</div> 
			<input type="submit" value="Guardar" class="" >
		</form:form>
	</main>
</body>
</html>