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

function cambia_imagen(elemento_img) {
    elemento_img.src = "img/gatito.jpg";
}

function regresa_imagen(elemento_img) {
    elemento_img.src = "img/CynthiaCastillo_linkedin.png";
}

function editar_perfil() {
    let elemento_nombre = document.querySelector("#nombre-perfil");
    //elemento_nombre = <h2 id="nombre-perfil">Cynthia Castillo</h2>

    let elemento_parrafo = document.querySelector(".locacion-rol");
    /*
    elemento_parrafo = <p class="locacion-rol">
                        Monterrey, México <br>
                        Líder de Instrucción en Skillnest e Instructora del mejor grupo de Full Stack Java
                    </p>
    */

    elemento_nombre.innerText = "cindychateau";
    elemento_parrafo.innerHTML = "Magicland<br> Reyna del mundo Magicland";

    //background-color
    //margin-top
    //background-image
    elemento_nombre.style.backgroundColor = "beige";
    //camelCase. Cynthia Castillo Elizondo ->cynthiaCastilloElizondo
}