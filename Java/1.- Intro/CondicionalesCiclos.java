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

    }

}