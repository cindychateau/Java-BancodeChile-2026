// Función que se ejecuta al hacer clic en el botón de like
// Recibe como parámetro el ID del span contador (un string con el id del elemento HTML)
function darLike(idContador) {

    // Busca en todo el documento el elemento cuyo id coincida con el valor recibido
    // A diferencia de la versión anterior, ya no necesita subir al padre: va directo por ID
    let spanContador = document.getElementById(idContador);

    // Lee el texto actual del span (string) y lo convierte a número entero con parseInt
    let likesActuales = parseInt(spanContador.innerText);

    // Suma 1 al valor actual y actualiza el texto visible en pantalla
    spanContador.innerText = likesActuales + 1;
}