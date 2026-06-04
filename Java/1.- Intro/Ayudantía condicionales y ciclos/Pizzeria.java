import java.util.Scanner;

public class Pizzeria {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Controla si el menú sigue mostrándose o no
        boolean activo = true;

        // Aquí vamos a ir guardando cada item del pedido como texto
        // Empieza vacío y lo vamos llenando con cada producto elegido
        String resumenPedido = "";

        // Aquí vamos sumando el precio de cada item
        // Empieza en 0 y acumula a lo largo de toda la sesión
        int totalAPagar = 0;

        // Lleva la cuenta de cuántos productos se han ordenado
        int totalItems = 0;

        // do-while para que el menú se muestre al menos una vez
        // y se repita hasta que el usuario elija salir
        do {
            System.out.println("\n¿Qué deseas ordenar?");
            System.out.println("1.- Pizza");
            System.out.println("2.- Acompañamiento");
            System.out.println("3.- Bebida");
            System.out.println("0.- Salir y ver mi pedido");
            System.out.println("> ");

            int opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("\nElige el tamaño de tu pizza:");
                    System.out.println("1.- Individual ($5.900)");
                    System.out.println("2.- Mediana    ($8.990)");
                    System.out.println("3.- Familiar   ($12.990)");
                    System.out.println("4.- XL         ($16.990)");
                    System.out.println("> ");

                    int tamano = teclado.nextInt();

                    // Declaramos las variables antes del if para poder
                    // usarlas más abajo, fuera del bloque condicional
                    String nombreTamano = "";
                    int precioPizza = 0;

                    if (tamano == 1) {
                        nombreTamano = "Individual";
                        precioPizza = 5990;
                    } else if (tamano == 2) {
                        nombreTamano = "Mediana";
                        precioPizza = 8990;
                    } else if (tamano == 3) {
                        nombreTamano = "Familiar";
                        precioPizza = 12990;
                    } else if (tamano == 4) {
                        nombreTamano = "XL";
                        precioPizza = 16990;
                    } else {
                        System.out.println("Opción de tamaño no válida.");
                        // break corta el case 1 completo, no llega al submenú de tipos
                        break;
                    }

                    System.out.println("\nElige el tipo de pizza:");
                    System.out.println("1.- Pepperoni");
                    System.out.println("2.- Todas las carnes");
                    System.out.println("3.- Veggie");
                    System.out.println("4.- Hawaiana");
                    System.out.println("5.- Ultra Suprime");
                    System.out.println("> ");

                    int tipoPizza = teclado.nextInt();
                    String nombreTipo = "";

                    switch (tipoPizza) {
                        case 1: nombreTipo = "Pepperoni";        break;
                        case 2: nombreTipo = "Todas las carnes"; break;
                        case 3: nombreTipo = "Veggie";           break;
                        case 4: nombreTipo = "Hawaiana";         break;
                        case 5: nombreTipo = "Ultra Suprime";    break;
                        default: nombreTipo = ""; // opción fuera de rango
                    }

                    if (nombreTipo.equals("")) {
                        System.out.println("Opción de tipo no válida.");
                    } else {
                        // Armamos el nombre completo del producto
                        String itemPizza = "Pizza " + nombreTamano + " de " + nombreTipo;

                        // Concatenamos el item al resumen
                        // \n hace que el siguiente item quede en una línea nueva
                        resumenPedido = resumenPedido + (totalItems + 1) + ". " + itemPizza + " - $" + precioPizza + "\n";

                        // Sumamos el precio al total acumulado
                        totalAPagar = totalAPagar + precioPizza;
                        totalItems++;

                        System.out.println("\n¡Agregado al pedido! " + itemPizza + " - $" + precioPizza);
                        System.out.println("-------------------------------------------------------");
                    }
                    break;

                case 2:
                    System.out.println("\nElige tu acompañamiento:");
                    System.out.println("1.- Papas fritas medianas ($2.490)");
                    System.out.println("2.- Papas fritas grandes  ($3.290)");
                    System.out.println("3.- Palitos de ajo        ($2.990)");
                    System.out.println("4.- Alitas de pollo       ($2.990)");
                    System.out.println("> ");

                    int opcionAcom = teclado.nextInt();
                    String nombreAcom = "";
                    int precioAcom = 0;

                    switch (opcionAcom) {
                        case 1: nombreAcom = "Papas fritas medianas"; precioAcom = 2490; break;
                        case 2: nombreAcom = "Papas fritas grandes";  precioAcom = 3290; break;
                        case 3: nombreAcom = "Palitos de ajo";        precioAcom = 2990; break;
                        case 4: nombreAcom = "Alitas de pollo";       precioAcom = 2990; break;
                        default: nombreAcom = "";
                    }

                    if (nombreAcom.equals("")) {
                        System.out.println("Opción no válida, intenta de nuevo.");
                    } else {
                        resumenPedido = resumenPedido + (totalItems + 1) + ". " + nombreAcom + " - $" + precioAcom + "\n";
                        totalAPagar = totalAPagar + precioAcom;
                        totalItems++;

                        System.out.println("\n¡Agregado al pedido! " + nombreAcom + " - $" + precioAcom);
                        System.out.println("-----------------------------------------------");
                    }
                    break;

                case 3:
                    System.out.println("\nElige tu bebida:");
                    System.out.println("1.- Agua mineral        ($990)");
                    System.out.println("2.- Jugo de naranja     ($1.490)");
                    System.out.println("3.- Coca-Cola           ($1.990)");
                    System.out.println("4.- Cerveza artesanal   ($2.990)");
                    System.out.print("> ");

                    int opcionBebida = teclado.nextInt();
                    String nombreBebida = "";
                    int precioBebida = 0;

                    switch (opcionBebida) {
                        case 1: nombreBebida = "Agua mineral";      precioBebida = 990;  break;
                        case 2: nombreBebida = "Jugo de naranja";   precioBebida = 1490; break;
                        case 3: nombreBebida = "Coca-Cola";         precioBebida = 1990; break;
                        case 4: nombreBebida = "Cerveza artesanal"; precioBebida = 2990; break;
                        default: nombreBebida = "";
                    }

                    if (nombreBebida.equals("")) {
                        System.out.println("Opción no válida, intenta de nuevo.");
                    } else {
                        resumenPedido = resumenPedido + (totalItems + 1) + ". " + nombreBebida + " - $" + precioBebida + "\n";
                        totalAPagar = totalAPagar + precioBebida;
                        totalItems++;

                        System.out.println("\n¡Agregado al pedido! " + nombreBebida + " - $" + precioBebida);
                        System.out.println("-----------------------------------------------");
                    }
                    break;

                case 0:
                    // Ponemos activo en false para que el do-while no repita
                    activo = false;

                    if (totalItems == 0) {
                        // Si no se ordenó nada, resumenPedido sigue vacío
                        System.out.println("\nNo ordenaste nada. ¡Hasta pronto!");
                    } else {
                        // Imprimimos el String que fuimos construyendo durante la sesión
                        System.out.println("\n========================================");
                        System.out.println("         RESUMEN DE TU PEDIDO");
                        System.out.println("========================================");
                        System.out.print(resumenPedido);
                        System.out.println("----------------------------------------");
                        // Mostramos el total que fuimos acumulando con cada item
                        System.out.println("TOTAL A PAGAR: $" + totalAPagar);
                        System.out.println("========================================");
                        System.out.println("¡Gracias por tu pedido! Hasta pronto");
                    }
                    break;

                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
                    break;

            } // fin switch

        } while (activo); // el ciclo sigue mientras activo sea true

        teclado.close(); // cierra el Scanner cuando termina el programa, libera recursos utilizados
    }
}