<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- JSTL: forEach, if... -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> <!-- form:form integrar ModelAttribute -->
<%@ page isErrorPage="true" %>  <!-- Me permite mostrar los errores en la página de edición -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Usuario</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
	<main class="container">
		<h1>Editar Usuario</h1>
		<form:form action="/actualizar/${usuario.id}" method="POST" modelAttribute="usuario">
			<input type="hidden" name="_method" value="PUT" > <!-- sobreescribe el método: PUT -->
			<div>
				<form:label path="nombre">Nombre:</form:label>
				<form:input path="nombre" class="form-control" />
				<form:errors path="nombre" class="text-danger" />
			</div>
			<div>
				<form:label path="apellido">Apellido:</form:label>
				<form:input path="apellido" class="form-control" />
				<form:errors path="apellido" class="text-danger" />
			</div>
			<div>
				<form:label path="email">Email:</form:label>
				<form:input path="email" class="form-control" />
				<form:errors path="email" class="text-danger" />
			</div>
			<div>
				<form:label path="curso">Curso:</form:label>
				<form:select path="curso" class="form-select">
					<c:forEach items="${cursos}" var="esteCurso" >
						<form:option value="${esteCurso.id}">${esteCurso.nombreCurso}</form:option>
					</c:forEach>
				</form:select>
			</div>
			<input type="submit" value="Guardar Usuario" class="btn btn-info mt-3" >
		</form:form>
	</main>
</body>
</html>