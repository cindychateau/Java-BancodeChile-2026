// ARREGLOS Y FUNCIONES
// Fundamentos del Lenguaje JavaScript


// PARTE 1: ARREGLOS
//
// Un arreglo es una lista ordenada de valores en una sola variable.
// En vez de crear una variable por cada dato, los metemos todos juntos.
// Cada valor tiene una posición llamada índice, que empieza siempre en 0.
//
//   gastosSemana[0] → primer elemento
//   gastosSemana[1] → segundo elemento ... y así.

var gastosSemana = [3200, 1500, 4800, 900, 2100, 3700, 1200];
//                   [0]    [1]   [2]   [3]  [4]   [5]   [6]
//                  lun    mar   mie   jue  vie   sab   dom


// Para leer un valor usamos el nombre del arreglo y su índice entre corchetes.

console.log("Gasto del lunes: $" + gastosSemana[0]);
console.log("Gasto del miércoles: $" + gastosSemana[2]);


// .length nos dice cuántos elementos tiene el arreglo.
// Si hay 7 elementos, los índices van del 0 al 6 (es decir, length - 1).

var cantidadDias = gastosSemana.length;
console.log("Total de días registrados: " + cantidadDias);


// Para acceder al último elemento sin saber cuántos hay,
// usamos arreglo[arreglo.length - 1].

var gastoUltimoDia = gastosSemana[gastosSemana.length - 1];
console.log("Gasto del último día: $" + gastoUltimoDia);


// En vez de sumar los gastos uno a uno, usamos un bucle for
// que recorre cada elemento desde el índice 0 hasta el último.

var totalSemana = 0;

for (var i = 0; i < gastosSemana.length; i++) {
    // gastosSemana[i] nos da el elemento en la posición i en cada vuelta
    totalSemana += gastosSemana[i];
}

console.log("El gasto total de la semana fue: $" + totalSemana);


// PARTE 2: OPERACIONES CON ARREGLOS
//
// Los arreglos tienen métodos que nos permiten agregar,
// eliminar y modificar sus elementos.

var userData = ["Lewis", "Hamilton", "l.hamilton@oficina.com"];
console.log(userData);


// .push() agrega un nuevo elemento al final del arreglo.

userData.push("piloto");
console.log(userData);


// .pop() elimina el último elemento del arreglo.
// No necesita argumentos, simplemente quita el último.

userData.pop();
console.log(userData);


// Para cambiar un valor usamos su índice y le asignamos el nuevo dato.

userData.push("piloto");
userData[3] = "fotógrafo";
console.log(userData);

// Resumen de los índices de userData:
//   userData[0] → nombre
//   userData[1] → apellido
//   userData[2] → correo
//   userData[3] → pasatiempo


// .length se actualiza solo cuando agregamos o quitamos elementos.

console.log("Largo del arreglo: " + userData.length);
userData.pop();
console.log("Largo después de pop(): " + userData.length);


// PARTE 3: OBJETOS
//
// Un objeto guarda datos relacionados usando nombres descriptivos
// (llamados propiedades) en vez de índices numéricos.
// Es ideal cuando los datos tienen significado propio.

var hamburguesaClasica = {
    pan: "pan con semillas de sésamo",
    carne: "carne de res 100%",
    queso: "queso cheddar",
    extras: ["lechuga", "tomate", "cebolla", "salsa especial"]
};

// Para leer una propiedad usamos objeto.propiedad

console.log("Pan: " + hamburguesaClasica.pan);
console.log("Carne: " + hamburguesaClasica.carne);
console.log("Queso: " + hamburguesaClasica.queso);
console.log("Extras: " + hamburguesaClasica.extras[0]);


// Un objeto también puede tener funciones como propiedades.
// A estas funciones les llamamos métodos.
// La palabra "this" hace referencia al propio objeto.

var hamburguesaEspecial = {
    pan: "pan de hamburguesa",
    carne: "carne de res",
    queso: "queso americano",
    extras: ["lechuga", "tomate", "cebolla", "salsa especial"],
    infoHamburguesa: function() {
        // "this" se refiere al objeto hamburguesaEspecial
        console.log("Pan: " + this.pan);
        console.log("Carne: " + this.carne);
        console.log("Queso: " + this.queso);
        // .join(", ") convierte el arreglo en un texto separado por comas
        console.log("Extras: " + this.extras.join(", "));
    }
};

// Llamamos al método igual que a una función, pero con punto
hamburguesaEspecial.infoHamburguesa();


// PARTE 4: FUNCIONES
//
// Una función es un bloque de código con nombre que podemos
// ejecutar cuantas veces queramos. No se ejecuta sola,
// hay que invocarla.

function saludar() {
    console.log("¡Hola, amigo!");
}

saludar(); // La llamamos así. Podemos llamarla cuantas veces queramos.
saludar();


// Los parámetros son variables que recibe la función.
// Los argumentos son los valores reales que le pasamos al llamarla.

function saludarPorNombre(nombreAmigo) {
    console.log("¡Hola, amigo " + nombreAmigo + "!");
}

saludarPorNombre("Luis");
saludarPorNombre("Camila");


// Con return la función calcula algo y devuelve el resultado
// para usarlo después. Al ejecutar return, la función se detiene.

function encontrarMaximo(a, b) {
    if (a > b) {
        return a;
    } else {
        return b;
    }
}

var numero1 = 7.1;
var numero2 = 7.07;
var maximo = encontrarMaximo(numero1, numero2);
console.log("El máximo entre " + numero1 + " y " + numero2 + " es: " + maximo);


// PARTE 5: DESAFÍOS

// Desafío 1: Número de corte
// Devuelve un nuevo arreglo con solo los números menores al valorCorte.

function numeroDeCorte(arreglo, valorCorte) {
    var resultado = [];
    for (var i = 0; i < arreglo.length; i++) {
        if (arreglo[i] < valorCorte) {
            resultado.push(arreglo[i]);
        }
    }
    return resultado;
}

console.log(numeroDeCorte([1, 2, 8, 4, 5, 7, 6], 4)); // [1, 2]


// Desafío 2: Peor que el promedio
// Calcula el promedio del arreglo y devuelve los números
// que están por debajo de ese promedio.

function numerosBajoPromedio(arreglo) {
    // Paso 1: calcular la suma total
    var total = 0;
    for (var i = 0; i < arreglo.length; i++) {
        total += arreglo[i];
    }

    // Paso 2: calcular el promedio
    var promedio = total / arreglo.length;
    console.log("Promedio: " + promedio);

    // Paso 3: filtrar los que están bajo el promedio
    var bajoPromedio = [];
    for (var i = 0; i < arreglo.length; i++) {
        if (arreglo[i] < promedio) {
            bajoPromedio.push(arreglo[i]);
        }
    }

    return bajoPromedio;
}
var arreglo_2 = [22, 34, 1, 13, 2, 9, 13, 11, 50]
console.log(numerosBajoPromedio([1, 20, 3, 4, 15, 6, 27]));
console.log(numerosBajoPromedio(arreglo_2))
