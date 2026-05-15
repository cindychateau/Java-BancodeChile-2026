/*
FUNCIÓN: Bloque de código que puedo nombrar y que puedo llamar (las veces que necesite)
*/

//function nombre_funcion(parametros1, parametros2...) {}

function saludo() {
    console.log("¡Hola!");
    console.log("Que tengas buen día!")
}

saludo();
saludo();
saludo();
saludo();

function saludo_nombre(nombre) { //nombre = "Elena"
    console.log("Hola "+nombre); //Imprimir: Hola Elena
}

saludo_nombre("Elena");

function correo(lista_correos){ //lista_correos = 
    //Importar las librerías enviar correo
    for(let i=0; i < lista_correos.length; i++) {
        console.log("¡Bienvenido a la plataforma: "+lista_correos[i]);
    }
}

listado_personas = [
    "elena@skillnest.com",
    "juana@skillnest.com",
    "pedro@skillnest.com",
];

correo(listado_personas);

function sumatoria(num1, num2) { //num1 = 20, num2 = 30
    let num3 = num1 + num2; //num3 = 20+30 = 50
    return num3; //<- 50
}

let resultado = sumatoria(15, 16);
console.log("El resultado de la operación es: "+resultado);

console.log("El resultado de una seguna sumatoria es: "+ sumatoria(1, 2));