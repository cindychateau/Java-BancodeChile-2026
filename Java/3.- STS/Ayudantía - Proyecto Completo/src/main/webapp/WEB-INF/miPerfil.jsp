<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mi perfil</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">
</head>
<body>
<div class="container mt-3">
    <nav class="d-flex justify-content-between align-items-center border-bottom pb-2 mb-4">
        <h3 class="m-0">Patitas a la Obra</h3>
        <div>
            <a href="/dashboard" class="btn btn-link">Mascotas</a>
            <a href="/mascotas/nueva" class="btn btn-link">Agregar mascota</a>
            <a href="/perfil" class="btn btn-link">Mi perfil</a>
            <form action="/logout" method="post" class="d-inline">
                <button class="btn btn-outline-danger btn-sm">Logout</button>
            </form>
        </div>
    </nav>
    <h2>Mi perfil</h2>
    <form:form action="/perfil/actualizar" method="post" modelAttribute="usuario">
        <input type="hidden" name="_method" value="PUT">
        <form:hidden path="id"/>
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
            <form:label path="password">Nueva contraseña</form:label>
            <form:password path="password" class="form-control"/>
            <form:errors path="password" class="text-danger"/>
        </div>
        <div class="mb-3">
            <form:label path="confirmarPassword">Confirmar contraseña</form:label>
            <form:password path="confirmarPassword" class="form-control"/>
            <form:errors path="confirmarPassword" class="text-danger"/>
        </div>
        <button class="btn btn-primary">Guardar cambios</button>
    </form:form>
</div>
</body>
</html>