<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle Libro</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
	<main class="container">
		<div class="row">
			<div class="col-6">
				<h1>Detalle Libro</h1>
				<c:if test="${not empty autor}" >
					<h2>Autor: ${autor}</h2>
					<h2>Libro: ${libro}</h2>
				</c:if>
				<c:if test="${empty autor}" >
					<h2 class="text-danger" >El libro no se encuentra en nuestra lista.</h2>
				</c:if>
				<a class="btn btn-info" href="/libros" >Regresar</a>
			</div>
		</div>
	</main>
</body>
</html>