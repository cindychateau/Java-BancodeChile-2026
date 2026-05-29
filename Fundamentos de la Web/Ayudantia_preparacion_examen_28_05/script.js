
// 1. BOTONES DE CATEGORÍA

// Recibe el botón que fue clickeado (this desde el HTML)
function cambiarColor(boton) {

  // Le cambia el color de fondo y el color del texto directamente
  boton.style.backgroundColor = "#2d6a4f";
  boton.style.color = "#ffffff";

}



// 2. BOTONES DE LIKE (corazón)

// Recibe el botón que fue clickeado (this desde el HTML)
function darLike(boton) {

  // Busca el <span class="contador"> que está dentro del botón
  const spanContador = boton.querySelector(".contador");

  // Lee el texto del span (ej: "1") y lo convierte a número entero
  // Sin parseInt no podríamos sumar, porque "1" texto ≠ 1 número
  let cantidadActual = parseInt(spanContador.textContent);

  // Le suma 1 a ese número
  cantidadActual = cantidadActual + 1;

  // Escribe el nuevo número de vuelta en el span
  spanContador.textContent = cantidadActual;

}



// 3. BOTÓN CERRAR SESIÓN

// Llamada directo desde el onclick en el HTML
function cerrarSesion() {

  // Muestra una ventana de alerta con ese mensaje
  alert("Sesión cerrada correctamente");

}