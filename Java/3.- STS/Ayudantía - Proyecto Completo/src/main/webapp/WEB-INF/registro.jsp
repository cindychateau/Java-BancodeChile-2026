<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro - Patitas a la Obra</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">
</head>
<body>
	<div class="container mt-4" style="max-width:520px">
    <h1>Patitas a la Obra</h1>
    <h2 class="text-muted">Registro</h2>
    <form:form action="/registro" method="post" modelAttribute="usuario">
     	<div class="mb-3">
         <form:label path="nombre">Nombre</form:label>
         <form:input path="nombre" class="form-control"/>
         <form:errors path="nombre" class="text-danger"/>
     	</div>
     	<div class="mb-3">
         <form:label path="apellido">Apellido</form:label>
         <form:input path="apellido" class="form-control"/>
         <form:errors path="apellido" class="text-danger"/>
     	</div>
     
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
     	<div class="mb-3">
         <form:label path="confirmarPassword">Confirmar contraseña</form:label>
         <form:password path="confirmarPassword" class="form-control"/>
         <form:errors path="confirmarPassword" class="text-danger"/>
     	</div>
     
     	<button class="btn btn-primary">Registrarse</button>
     	<a href="/login" class="btn btn-link">¿Ya tienes cuenta? Inicia Sesión</a>
     </form:form>
     </div>
</body>
</html>