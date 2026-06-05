import java.util.ArrayList;
public class Arreglos {

    public static void main(String[] args) {
        /* ARREGLOS / ARRAYS / LISTAS */

        //Arreglo estático: no cambia de tamaño.
        int[] arreglo; //Declaración
        arreglo = new int[5]; //Inicialización, establezco el tamaño del arreglo
        arreglo[0] = 4;
        arreglo[1] = 8;
        arreglo[2] = 9;
        arreglo[3] = 10;
        arreglo[4] = 5;

        int[] arreglo2 = {4, 8, 9, 10, 5}; //Arreglo de 5 espacios
        System.out.println(arreglo2[1]);
        arreglo2[3] = 11;


        boolean[] arrayBooleans;
        arrayBooleans = new boolean[3];
        arrayBooleans[0] = true;
        System.out.println("Tamaño arreglo de booleans: "+arrayBooleans.length);

        int[] calificaciones = {7, 5, 4};
        int sumaCalificaciones = 0;
        for(int i=0; i < calificaciones.length; i++) {
            //calificaciones[i]
            sumaCalificaciones += calificaciones[i];
        }

        double promedio = sumaCalificaciones / calificaciones.length;

        //Arreglos Dinámicos ->  ArrayList
        //ArrayList<TipoDeDato> nombreArray = new ArrayList<TipoDeDato>();
        ArrayList<String> estudiantes = new ArrayList<String>(); //Declarando e Inicializando mi lista
        estudiantes.add("Juana"); //.add(valor) = Agregar un nuevo valor al listado
        estudiantes.add("Elena");
        estudiantes.add("Petra");

        System.out.println(estudiantes.get(1)); //.get(indice) = Consulta el valor de un indice específico
        estudiantes.set(0, "Juanita"); //.set(indice, nuevoValor) = Cambia el valor de un índice
        System.out.println("Tamaño de estudiantes: "+estudiantes.size()); //.size() = Tamaño del ArrayList

        String nombreEstudiante2 = estudiantes.get(2);

    }


}