// EJERCICIO: BOTÓN ME GUSTA
// El objetivo es practicar eventos onclick y querySelector
// para modificar elementos distintos al que recibe el clic.


// Esta función se ejecuta cada vez que alguien hace clic en un botón "♥ Me gusta".
// Recibe como parámetro "boton", que es el elemento que fue clickeado.
// En el HTML lo llamamos así: onclick="darLike(this)"
// La palabra "this" le pasa el propio botón a la función.

function darLike(boton) {

    // Cada tarjeta tiene este estructura:
    //   <div class="tarjeta">
    //     <div class="tarjeta-header">
    //       ...
    //       <div class="likes-area">
    //         <span class="contador">0</span>   ← aquí está el número
    //         <button class="btn-like">...
    //
    // Para llegar al span.contador desde el botón, subimos dos niveles
    // con .parentElement y luego buscamos el span con querySelector.

    // .parentElement nos da el elemento padre del botón (el div.likes-area)
    var likesArea = boton.parentElement;

    // Dentro de ese div.likes-area, buscamos el span con clase "contador"
    // querySelector busca el primer elemento que coincida con el selector CSS
    var spanContador = likesArea.querySelector(".contador");

    // Leemos el número actual del span y lo convertimos a número entero.
    // innerHTML nos da el contenido de texto del elemento como string.
    // parseInt convierte ese string en un número para poder sumarle 1.
    var likesActuales = parseInt(spanContador.innerHTML);

    // Sumamos 1 al valor actual y lo volvemos a escribir en el span.
    // Al asignar a innerHTML, actualizamos lo que se ve en pantalla.
    spanContador.innerHTML = likesActuales + 1;
}