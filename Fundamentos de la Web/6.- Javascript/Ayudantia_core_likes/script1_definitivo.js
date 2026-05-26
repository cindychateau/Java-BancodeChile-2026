// Función que se ejecuta al hacer clic en el botón de like
// Recibe como parámetro el botón que fue clickeado (se pasa con this desde el HTML)
function darLike(boton) {

    // Sube al elemento padre del botón para acceder al contenedor completo del área de likes
    let likesArea = boton.parentElement;

    // Dentro de ese contenedor, busca el elemento que tenga la clase "contador"
    // Ese elemento es el <span> donde se muestra el número de likes
    let spanContador = likesArea.querySelector(".contador");

    // Lee el texto actual del span (que es un string) y lo convierte a número entero
    let likesActuales = parseInt(spanContador.innerText);

    // Suma 1 al valor actual y actualiza el texto visible en pantalla
    spanContador.innerText = likesActuales + 1;



    //ESTA PARTE ES PARA EJEMPLIFICAR MENSAJE DE ALERTA AL DAR LIKE
    //let tarjetaHeader = likesArea.parentElement;
    //let nombreAutor = tarjetaHeader.querySelector(".autor").innerText;

    //alert("Le diste like a la publicación de " + nombreAutor + "!")
}