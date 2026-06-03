import java.util.Scanner; //Librería

public class CondicionalesCiclos {

    public static void main(String[] args) {
        //Aquí va el código que quiero que se ejecute

        int numero = 100;

        if(numero == 100) {
            System.out.println("Los números son iguales");
        } else {
            System.out.println("Los números son distintos");
        }

        int edadInfante = 4;
        if(edadInfante < 2) {
            System.out.println("Es un bebe");
        } else if(edadInfante < 5) {
            System.out.println("Es un toddler");
        } else if(edadInfante < 15) {
            System.out.println("Es un infante");
        } else {
            System.out.println("Es un adolescente");
        }

        //AND &&: busca que ambas condicionales se cumplan
        boolean estaLloviendo = false;
        int temperatura = 20;
        if(temperatura > 18 && !estaLloviendo) { // ! -> negación
            System.out.println("¡Vayamos al parque a dar un paseo!");
        }
        // !estaLloviendo -> estaLloviendo == false

        //OR ||: busca que una u otra condición se cumpla
        int edad = 16;
        boolean permisoPadres = true;
        if(edad >= 18 || permisoPadres) {
            System.out.println("Puedes obtener tu licencia de manejo");
        }

        int dia = 5;
        switch(dia) {
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miércoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            case 5:
                System.out.println("Viernes");
                break;
            case 6:
                System.out.println("Sábado");
                break;
            case 7:
                System.out.println("Domingo");
                break;
            default:
                System.out.println("¡Solo tenemos 7 días!");
                break;
        }

        /* BUCLES / CICLOS */
        for(int i=0; i < 4; i++) {
            System.out.println("¡hey!");
        }

        int n = 0;
        while(n < 4) { // 0 < 4, 1 < 4, 2 < 4, 3 < 4
            System.out.println("¡hola!"); //¡hola! ¡hola! ¡hola! ¡hola!
            n++;// n = 1, n = 2, n = 3, n = 4
        }

        int x = 10;
        while(x < 5) {
            System.out.println("Entra al while de línea 80");
            x++;
        }

        //Al menos se va a ejecutar 1 vez
        do { //PRIMERO sin importar la condicional, ejecuta el código
            System.out.println("Entramos en el do-while");
            x++;
        } while(x < 5);

        //Declarar variable teclado para ingresar info
        Scanner teclado = new Scanner(System.in); 
        System.out.println("Hola, ingresa tu nombre: ");
        String nombre = teclado.nextLine(); //Captura es una línea de texto

        System.out.println("Ingresa tu edad: ");
        int edadPersona = teclado.nextInt(); //Captura un número entero

        System.out.println("¡Ya me robe tu info, sé que eres "+nombre+" de edad "+edadPersona);

        //nextLine -> Captura la línea completa de texto
        //next -> Captura solo 1 palabra
        //nextInt -> Captura un número entero
        //nextDouble -> Captura un número con decimal
        //nextBoolean -> Captura un booleano

    }

}