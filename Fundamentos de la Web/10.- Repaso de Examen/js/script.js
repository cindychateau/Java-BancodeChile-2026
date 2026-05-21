//alert("Cargando Reporte del Clima");

function cargar_reporte() {
    alert("Cargando Reporte del Clima");
}

function eliminar_cookies() {
    //pie_de_pagina = <footer> ... </footer>
    let pie_de_pagina = document.querySelector("footer");
    pie_de_pagina.remove();

    /*
    document.querySelector("footer").remove();
    */
}

function seleccionar_ciudad(elemento) {
    //elemento = <a href="#" onclick="seleccionar_ciudad(this)" >Sao Paulo</a>
    //ciudad = Sao Paulo
    let ciudad = elemento.innerText;

    document.querySelector("#titulo_ciudad").innerText = ciudad;

    /*
    //etiqueta_h2 = <h2 id="titulo_ciudad">Buenos Aires</h2>
    let etiqueta_h2 = document.querySelector("#titulo_ciudad");
    etiqueta_h2.innerText = ciudad;
    */
}

function cambiar_boton(boton) {
    boton.innerText = "Visto";
    //background-color
    boton.style.backgroundColor = "green";
}

function cambio_temperatura() {
    let selector = document.querySelector("#grados");
    let c_o_f = selector.value; //El valor que el usuario eligió del selector

    document.querySelector("#tipo_temp").innerText = c_o_f;
}