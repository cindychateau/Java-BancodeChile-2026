<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle de receta</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="contenedor">
	<%-- <c:choose> funciona como un if/else.
	     Acá decidimos qué mostrar según si la receta existe o no --%>
	<c:choose>
		<%-- Si ingredientes NO es null, significa que la receta sí estaba en el mapa,
		     así que la mostramos --%>
		<c:when test="${ingredientes != null }">
			<h1>${nombreReceta}</h1>
			<h2>Ingredientes:</h2>
			<ul class="lista-ingredientes">
				<%-- Recorremos el arreglo de ingredientes y mostramos uno por uno en un <li> --%>
				<c:forEach var="ingrediente" items="${ingredientes}">
					<li>${ingrediente }</li>
				</c:forEach>
			</ul>
		</c:when>
		<%-- El <c:otherwise> es el "si no" del choose: se muestra cuando ingredientes era null,
		     o sea cuando alguien escribió en la URL una receta que no existe --%>
		<c:otherwise>
			<p class="mensaje-error">La receta no se encuentra en nuestra lista.</p>
		</c:otherwise>
	</c:choose>
</div>

</body>
</html>