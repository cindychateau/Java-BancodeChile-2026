//PascalCase = CynthiaCastilloElizondo
//camelCase = cynthiaCastilloElizondo
//snake_case = cynthia_castillo_elizondo
/* PROMESAS */
function muestraPerrito() {
    fetch("https://dog.ceo/api/breeds/image/random")
        .then(respuesta => respuesta.json())
        .then(data => {
            console.log(data); //data como objeto JSON
            console.log(data.message);
            console.log(data['message']);
            //<img alt="texto alt" src="ruta/img.jpg" >
            let imagen = `<img alt="perrito" src="${data.message}" >`;
            //imagen = <img alt="perrito" src="ruta/perrito.jpg">;
            let img_concatenada = "<img alt='perrito' src='"+data.message+"'>";

            //Seleccionar el elemento al que le quiero agregar la imagen, y agregarla.
            document.querySelector(".imagen-perrito").innerHTML = imagen;

            //innerText = SOLO TEXTO
            //innerHTML = Cuando quiero agregar también etiquetas

        })
}

/*ASYNC/AWAIT */
async function muestraPerritoAsync() {
    let respuesta = await fetch("https://dog.ceo/api/breeds/image/random");
    let data = await respuesta.json();
    let imagen = `<img alt="perrito" src="${data.message}" >`;
    document.querySelector(".imagen-perrito").innerHTML = imagen;
}