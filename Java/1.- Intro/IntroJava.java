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
        //float numeroDecimal = 1.1;
        char unCaracter = 'X'; // 1 caracter
        char numChar = '1';

        //Datos de clase envoltura: valores, métodos (funciones), funcionalidad adicional
        Integer otroEntero = 5;
        Double otroDecimal = 5.99;
        Character otroChar = 'A'; //1 caracter
        String muchosCaracteres = "ABC123";

        String cadena = "Buenos tardes a todas mis Compañeras";
        System.out.println(cadena.length());
        //Métodos de cadena
        char letra = cadena.charAt(5); //¿Qué caracter/letra está en esa posición?
        System.out.println("Letra en posición 5:"+letra);

        int indice1 = cadena.indexOf("Buenos"); // indexOf: regresa indice/posicion de la palabra enviada
        System.out.println("Buenos:"+indice1);

        int indice2 = cadena.indexOf("hola"); //Cuando NO existe la palabra en la cadena, regresa -1
        System.out.println("hola:" + indice2); 

        System.out.println(cadena.toUpperCase()); //Todas las letras las pone en mayúsculas
        System.out.println(cadena.toLowerCase()); //Todas las letras las pone en minúsculas

        String frase1 = "Mi nombre es:";
        String frase2 = "Elena de Troya";
        String fraseCompleta = frase1.concat(frase2); //concat: concatenar (pegar) 2 textos
        System.out.println(fraseCompleta);

        String x = "hola";
        String y = "Hola";
        System.out.println(x.equals(y)); //equals: true o false si el texto es o no igual
        System.out.println(x.equalsIgnoreCase(y)); //Ignora si es mayúscula o minúscula

        /*
        RETO: Presentación
        Crees un nuevo archivo (usando PascalCase)
        En el nuevo archivo crees la clase (con el mismo nombre del archivo)
        Crees el método main

        Dentro del método main vas a crear las siguientes variables:
        nombre
        edad
        pais
        ciudad
        hobby1
        hobby2

        Imprimas:
        Hola, mi nombre es Cynthia Castillo
        Tengo 34 años de edad
        Soy de México y vivo en Monterrey
        Me gusta mucho leer y ver series
        
         */

    }

}