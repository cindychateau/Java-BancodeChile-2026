// Función que se ejecuta al hacer clic en el botón de like
// Recibe el ID del span donde se muestra el contador de likes
function darLike(idContador) {

    // Busca en el documento el elemento HTML que tenga ese ID
    let spanContador = document.getElementById(idContador);

    // Lee el texto del span y lo convierte a número entero
    // (innerText siempre devuelve un string, por eso se usa parseInt)
    let likesViejos = parseInt(spanContador.innerText);

    // Calcula el nuevo valor sumando 1 al contador anterior
    let likesNuevos = likesViejos + 1;

    // Actualiza el texto del span con el nuevo valor en pantalla
    spanContador.innerText = likesNuevos;
}