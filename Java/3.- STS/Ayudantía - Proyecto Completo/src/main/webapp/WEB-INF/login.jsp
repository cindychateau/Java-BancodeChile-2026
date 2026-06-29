<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - Patitas a la Obra</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">
</head>
<body>
	<div class="container mt-4" style="max-width:480px">
		<h1>Patitas a la Obra</h1>
		<h2 class="text-muted">Login</h2>
		
		<form:form action="/login" method="post" modelAttribute="loginUsuario">
			<div class="mb-3">
				<form:label path="email">Correo</form:label>
				<form:input path="email" class="form-control"/>
				<form:errors path="email" class="text-danger"/>
			</div>
			<div class="mb-3">
				<form:label path="password">Contraseña</form:label>
				<form:password path="password" class="form-control"/>
				<form:errors path="password" class="text-danger"/>
			</div>
			<button class="btn btn-primary">Login</button>
			<a href="/registro" class="btn btn-link">Crear una cuenta</a>
		</form:form>
	</div>

</body>
</html>