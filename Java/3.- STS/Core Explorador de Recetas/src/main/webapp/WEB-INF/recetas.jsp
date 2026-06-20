<%-- Define el lenguaje, el tipo de contenido y la codificación.
     UTF-8 es importante para que se vean bien las tildes y la ñ --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- Importamos la librería JSTL core con el prefijo "c".
     Eso nos habilita etiquetas como <c:forEach> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Recetas</title>
    <%-- El href parte con / o sea que busca el CSS desde la raíz del sitio --%>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <div class="contenedor">
        <h1>Nuestras recetas</h1>
        <ul class="lista-recetas">

            <%-- <c:forEach> recorre la lista que mandamos desde el controlador.
                 "items" es de dónde saca los datos (la listaRecetas del Model)
                 y "var" es el nombre que le damos a cada elemento en cada vuelta --%>
            <c:forEach var="receta" items="${listaRecetas}">
                <li>
                    <%-- Por cada receta armamos un link a su detalle.
                         ${receta} se reemplaza por el nombre, ej: /recetas/Pizza --%>
                    <a href="/recetas/${receta}">${receta}</a>
                </li>
            </c:forEach>
        </ul>
    </div>
</body>
</html>