// Importamos la clase Algoritmos del paquete "clases" para poder usar sus métodos
import clases.Algoritmos;

// Importamos ArrayList para poder crear listas dinámicas
import java.util.ArrayList;

public class Aplicacion {
    
    public static void main(String[] args) {

        System.out.println("-----esPar-----");

        // Arreglo estático con los números que vamos a evaluar
        int[] numerosParImpar = {4, 7, 13, 15, 16, 2, 99};

        // Recorremos cada número del arreglo con un ciclo for-each
        for (int numero : numerosParImpar) {
            // Llamamos al método esPar y guardamos el resultado
            boolean resultado = Algoritmos.esPar(numero);
            System.out.println("¿" + numero + " es par? " + resultado);
        }


        System.out.println("\n-----esPrimo-----");

        // Creamos un ArrayList de Integer para guardar los números a evaluar
        // Usamos Integer (clase envoltura) porque ArrayList no acepta tipos primitivos
        ArrayList<Integer> numerosParaPrimo = new ArrayList<Integer>();
        numerosParaPrimo.add(1);
        numerosParaPrimo.add(6);
        numerosParaPrimo.add(7);
        numerosParaPrimo.add(43);
        numerosParaPrimo.add(12);
        numerosParaPrimo.add(17);
        numerosParaPrimo.add(23);

        // Recorremos cada número del ArrayList con un ciclo for-each
        for (int numero : numerosParaPrimo) {
            // Llamamos al método esPrimo y guardamos el resultado
            boolean resultado = Algoritmos.esPrimo(numero);
            System.out.println("¿" + numero + " es primo? " + resultado);
        }


        System.out.println("\n-----stringEnReversa-----");

        // Arreglo estático de Strings con las palabras a evaluar
        // Lo declaramos aquí porque lo reutilizaremos también en esPalindromo
        String[] palabras = {"holi", "Java", "75421", "ana", "ala"};

        // Recorremos cada palabra del arreglo con un ciclo for-each
        for (String palabra : palabras) {
            // Llamamos al método stringEnReversa y guardamos el resultado
            String reversa = Algoritmos.stringEnReversa(palabra);
            System.out.println("Reversa de '" + palabra + "' " + reversa);
        }

        System.out.println("\n-----esPalindromo-----");    

        // Reutilizamos el arreglo "palabras" que declaramos arriba
        for (String palabra : palabras) {
            // Llamamos al método esPalindromo y guardamos el resultado
            boolean resultado = Algoritmos.esPalindromo(palabra);
            System.out.println("¿'" + palabra + "' es palíndromo? " + resultado);
        }

        System.out.println("\n-----secuenciaFizzBuzz-----");

        // Arreglo estático con los límites que queremos probar
        int[] limites = {15, 5, 20};

        // Recorremos cada límite y ejecutamos la secuencia FizzBuzz para cada uno
        for (int limite : limites) {
            System.out.print("FizzBuzz del 1 al " + limite + ": ");
            Algoritmos.secuenciaFizzBuzz(limite);
        }
    }
}