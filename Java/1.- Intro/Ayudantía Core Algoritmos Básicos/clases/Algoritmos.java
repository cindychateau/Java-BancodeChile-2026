// Este archivo pertenece al paquete "clases"
package clases;

public class Algoritmos {

    // Recibe un número entero y retorna true si es par, false si es impar
    public static boolean esPar(int numero) {
        // Si el residuo de dividir entre 2 es 0, el número es par
        if (numero % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    // Recibe un número entero y retorna true si es primo, false de lo contrario
    // Un número primo solo es divisible entre 1 y él mismo
    public static boolean esPrimo(int numero) {

        // Los números menores a 2 no son primos
        if (numero < 2) {
            return false;
        }

        // Buscamos si existe algún divisor entre 2 y numero - 1
        for (int i = 2; i < numero; i++) {
            // Si encontramos un divisor exacto, no es primo
            if (numero % i == 0) {
                return false;
            }
        }

        // Si el ciclo terminó sin encontrar divisores, sí es primo
        return true;
    }

    // Recibe un String y retorna ese mismo texto escrito al revés
    public static String stringEnReversa(String texto) {
        // Aquí acumulamos los caracteres en orden inverso
        String resultado = "";

        // Recorremos el String desde el último índice hasta el primero
        // .length() - 1 nos da el índice del último caracter
        for (int i = texto.length() - 1; i >= 0; i--) {
            // .charAt(i) obtiene el caracter en la posición i
            resultado = resultado + texto.charAt(i);
        }

        return resultado;
    }

    // Recibe un String y retorna true si es palíndromo, false de lo contrario
    // Un palíndromo se lee igual de izquierda a derecha que de derecha a izquierda
    public static boolean esPalindromo(String texto) {

        // Convertimos a minúsculas para que la comparación no distinga mayúsculas
        String textoMinusculas = texto.toLowerCase();

        // Reutilizamos el método stringEnReversa para obtener el texto al revés
        String textoReversa = stringEnReversa(textoMinusculas);

        // Si el texto original es igual a su reversa, es palíndromo
        // Usamos .equals() para comparar el contenido de los Strings, no ==
        if (textoMinusculas.equals(textoReversa)) {
            return true;
        } else {
            return false;
        }
    }

    // Recibe un número entero e imprime la secuencia FizzBuzz desde 1 hasta ese número
    public static void secuenciaFizzBuzz(int limite) {

        // Recorremos desde 1 hasta el límite recibido
        for (int i = 1; i <= limite; i++) {
            // Primero verificamos el caso combinado (divisible por 3 Y por 5)
            // Este caso debe ir primero, si no, nunca llegaríamos a él
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("FizzBuzz ");

            // Si solo es divisible por 3
            } else if (i % 3 == 0) {
                System.out.print("Fizz ");

            // Si solo es divisible por 5
            } else if (i % 5 == 0) {
                System.out.print("Buzz ");

            // Si no cumple ninguna condición, imprimimos el número
            } else {
                System.out.print(i + " ");
            }
        }

        // Salto de línea al terminar la secuencia
        System.out.println();
    }
}