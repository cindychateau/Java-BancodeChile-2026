<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL: Librería de etiquetas que agregan lógica de código a nuestros htmls -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mostrar Usuarios</title>
</head>
<body>
	<h1>
		${titulo}
	</h1>
	<ul>
		<!-- usuarios = {"Elena de Troya", "Juana de Arco", "Pablo Picasso", "Pedro Páramo"} -->
		<c:forEach items="${usuarios}" var="usuario">
			<!-- Esto es lo que va a ser repetido por el forEach -->
			<li>
				${usuario}
				
				<!-- if(usuario == 'Pablo Picasso') -->
				<c:if test="${usuario == 'Pablo Picasso' }" >
					<small>(¡Me encanta su arte!)</small>
				</c:if>
				
			</li>
		</c:forEach>
	</ul>
</body>
</html>