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