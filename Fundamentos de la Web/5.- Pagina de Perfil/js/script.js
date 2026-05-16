console.log("¡Entramos a la página!");

function bienvenida() {
    alert("¡Bienvenido a la Página de Perfil!");
}

/*this: se refiere al elemento que está invocando a la función, es decir el elemento que dispara el evento.
this se recibe como parámetro en la función */
function eliminar(elemento) {
    //console.log(elemento);
    elemento.remove();
}

function cambiar_texto(elemento_h1) {
    //elemento_h1 = <h1 onclick="cambiar_texto(this)">Profile</h1>
    //elemento_h1.innerText = "Profile";
    if(elemento_h1.innerText == "Perfil") {
        elemento_h1.innerText = "Profile";
        elemento_h1.style.color = "brown";
    } else {
        elemento_h1.innerText = "Perfil";
        elemento_h1.style.color = "white";
    }
}