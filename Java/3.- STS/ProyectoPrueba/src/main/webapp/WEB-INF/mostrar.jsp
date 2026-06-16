<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>
		${titulo}
	</h1>
	
	<ul>
		<!--  {"Elena de Troya", "Juana de Arco", "Pablo Picasso", "Pedro Paramo"} -->
		<c:forEach items="${users}" var="usuario">
			<li>
				${usuario}
				<c:if test="${usuario == 'Pablo Picasso'}">
					(¡Amo su arte!)
				</c:if>
			</li>
		</c:forEach>
	</ul>
</body>
</html>