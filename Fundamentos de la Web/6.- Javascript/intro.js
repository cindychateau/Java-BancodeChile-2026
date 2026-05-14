console.log("¡Hola chicas! Bienvenidas a la clase de Javascript"); //Imprimir
//Comentario de linea
/*
Comentario
multilinea
*/

let numero = 1; //Número Entero
let decimal = 1.1; //Número decimal o flotante
let texto = "Este es un texto"; //Texto o cadena
let bool = true; //Booleno -> true o false

console.log(texto);

texto = "Anita lava la tina";

const password = "Abc123"; //const hace que la variable sea constante, por lo tanto NO CAMBIA
//password = "Cdef1234";

let numero1 = 10;
let numero2 = 20;
let suma = numero1 + numero2; //10 + 20 = 30
console.log(suma);

let nombre = "Elena de Troya";
let mensaje = "Mi nombre es:";
console.log(mensaje+nombre); //Concatenar

let combinamosTexto = "ABC";
console.log(combinamosTexto+numero1); //ABC10
console.log(combinamosTexto+numero1+numero2); //ABC1020
console.log(numero1+numero2+combinamosTexto); //"30ABC"

let orden = 10 + 20 / 6;
console.log(orden); // (), /*, +-
/*
pa: paretesis
po:potencias
mu: multiplicaciones
d: division
a: adicion
s: sustracción (resta)
*/

let n = 14;
n++; //Agrega 1 al valor. n = n + 1
n += 5; //n = n + 5 -> 15 + 5 = 20
console.log(n); // ++ -- += -= /= *=

//Interpolación = Intercalar textos y valores de variables
let otro_nombre = "Juana de Arco"
let edad = 18;
let otro_mensaje = `Mi nombre es ${otro_nombre}, ¿cómo estás? Tengo ${edad} años.`;
let mensaje_simbolomas = "Mi nombre es "+otro_nombre+", ¿cómo estás? Tengo "+edad+" años.";
console.log(otro_mensaje);
console.log(mensaje_simbolomas);

//CONDICIONAL
let encendido = true;
if(encendido) { // a === b; a !== b; a < b; a > b; a <= b; a >= b
    console.log("El foco está encendido.");
} else {
    console.log("El foco está apagado.");
}

n = 20;
if(n >= 15) {
    console.log("Número mayor a 15");
    console.log("¡Excelente!");
} else {
    console.log("Número menor a 15");
}

let edad_nino = 10;

if(edad_nino < 2) { //10 < 2 -> false
    console.log("Es un bebe");
} else if(edad_nino < 5) { //10 < 5 -> false
    console.log("Es un toddler");
} else if(edad_nino < 15) { //10 < 15 -> true
    console.log("Es un infante"); //imprimimos: Es un infante
} else {
    console.log("Es un adolescente!");
}

let temperatura = 23;
let estaLloviendo = false; //No está lloviendo
if(temperatura >= 18 && !estaLloviendo) { // && = and -> AMBAS CONDICIONES deben de cumplirse
    console.log("¡Gran día para ir a pasear al parque!");
}

let edad_conductor = 17;
let permisoPadres = true; //SI le dieron permiso los papás
if(edad_conductor >= 18 || permisoPadres) { // || = or -> Una u otra condicional debe cumplirse
    console.log("Puedes obtener tu licencia de manejo");
} else {
    console.log("No cumplió con NINGUN requerimiento");
}

let a = 10;
let b = 3;
if(a !== b) {
    console.log("A y B son diferentes");
}

//BUCLE
/*
i = 0
¡Hola!
¿Cómo estás?
--
i = 1
¡Hola!
¿Cómo estás?
--
i = 2
¡Hola!
¿Cómo estás?
--
i = 3
TERMINA BUCLE
*/
for(let i=0; i < 3; i++) { //(inicializacion; condicional; paso)
    console.log("¡Hola!");
    console.log("¿Cómo estás?");
}

/*
i = 10
IMPRIME: 10
--
i = 9
IMPRIME: 9
--
i = 8
TERMINA BUCLE
*/
for(let i = 10; i > 8; i--)  { 
    console.log(i);
}

let x = 0;
while(x < 2) {
    console.log("Entre al bucle while");
    x++;
}

/*
inicio = 2
final = 8
¡Entre de nuevo al bucle while!
inicio = 4
final = 7
--
¡Entre de nuevo al bucle while!
inicio = 6
final = 6
*/
let inicio = 2;
let final = 8;
while(inicio < final) {
    console.log("¡Entre de nuevo al bucle while!");
    inicio += 2; //incrementa en 2
    final--; 
}

//Estructuras de Datos
//Arreglos / Listas / Arrays
let lista_super = ["manzana", "huevo", "leche", "lechuga"];
console.log(lista_super);
console.log(lista_super[1]);
lista_super[3] = "espinacas";
console.log(lista_super);
console.log(lista_super.length);

let lista_combinada = [
    "letras",
    12,
    1.1,
    true
]

let matriz = [
    [1, 2, 3, 4, 5],
    [6, 7, 8, 9, 10],
    [11, 12, 13, 14, 15]
];
console.log(matriz[1][1]);

let lista_nombres = [
    "Elena de Troya",
    "Juana de Arco",
    "Pablo Picasso",
    "Pedro Páramo"
];
for(let i=0; i < lista_nombres.length; i++) {
    console.log("Entramos y mostramos a: "+lista_nombres[i]);
}

//Objetos
let estudiante = {
    id: 123,
    nombre: "Elena",
    apellido: "De Troya",
    edad: 25,
    hobbies: ["Leer", "Bailar", "Ver series"]
};

console.log(estudiante["nombre"]);
console.log(estudiante.apellido);

estudiante.apellido = "De Arco";
console.log(estudiante);

estudiante.curso = "Full Stack Java";
console.log(estudiante);