/*
PascalCase - CadaPalabraVaConMayuscula -> Nombres de Archivos y Nombres de clases
camelCase - primeraVaEnMinusculaDespuesCadaPalabraMayuscula -> nombres de variables y de funciones (métodos)

javac NombreArchivo.java -> compilar
java NombreArchivo -> ejecución del código
 */

public class IntroJava {

    /* Método principal/main: es lo único que se ejecuta de mi programa */
    //public: permiso, que cualquiera puede ejecutar la función
    //static: es de mi clase (Más detalles en la sesión de Programación Orientada a Objetos)
    //void: No regresa nada
    //main: nombre de la función, es decir la función principal
    //(): argumentos
    public static void main(String[] args) {
        //Javascript: console.log("texto");
        System.out.println("¡Hola mundo!");

        //Variable -> Es un espacio en memoria donde nosotros asignamos un valor
        //Java nos pide que desde la declaración de la variable nosotros establezcamos el tipo de dato

        //Datos primitivos: representan un valor
        int miNumeroEntero = 100;
        double pi = 3.14159;
        boolean feliz = true;
        float numeroDecimal = 1.1;
        char unCaracter = 'X'; // 1 caracter
        char numChar = '1';

        //Datos de clase envoltura: valores, métodos (funciones), funcionalidad adicional
        Integer otroEntero = 5;
        Double otroDecimal = 5.99;
        Character otroChar = 'A'; //1 caracter
        String muchosCaracteres = "ABC123";

        String cadena = "Buenos tardes a todas mis Compañeras";
        System.out.println(cadena.length());
        //Ver más métodos de cadenas
    }

}