// FUNCIÓN: cambioSesion()
// Alterna el texto del botón de sesión entre
// "Iniciar sesión" y "Cerrar sesión" cada vez que se llama.

function cambioSesion() {
    // Obtenemos el botón por su ID en el HTML
    const btn = document.getElementById("btn-sesion");

    // Revisamos qué texto tiene el botón actualmente
    if (btn.textContent === "Iniciar sesión") {
        // Si dice "Iniciar sesión", lo cambiamos a "Cerrar sesión"
        btn.textContent = "Cerrar sesión";
    } else {
        // Si dice cualquier otra cosa (o sea, "Cerrar sesión"), volvemos al texto original
        btn.textContent = "Iniciar sesión";
    }
}


// FUNCIÓN: ocultarBoton()
// Oculta completamente el botón "btn-agregar" de la página.
// El elemento sigue existiendo en el HTML, pero deja de verse.

function ocultarBoton() {
    // Obtenemos el botón por su ID
    const btn = document.getElementById("btn-agregar");

    // display: "none" hace que el elemento desaparezca visualmente
    btn.style.display = "none";
}



// FUNCIÓN: darLike(boton, titulo)
// Incrementa en 1 el contador de likes de una tarjeta.
// Recibe el botón que fue clickeado y el título de la tarjeta.
//
// Parámetros:
//   boton  → el elemento <button> que activó la función
//   titulo → el nombre de la tarjeta (para mostrarlo en el alert)
function darLike(boton, titulo) {
    // Mostramos un mensaje de confirmación con el título de la tarjeta
    alert(titulo + " was liked");

    // Leemos el texto actual del botón (ej: "5 me gusta")
    const textoActual = boton.textContent;

    // Extraemos solo el número del texto usando parseInt()
    // parseInt("5 me gusta") → 5
    const numero = parseInt(textoActual);

    // Le sumamos 1 al número obtenido
    const nuevoNumero = numero + 1;

    // Actualizamos el texto del botón con el nuevo conteo
    boton.textContent = nuevoNumero + " me gusta";
}