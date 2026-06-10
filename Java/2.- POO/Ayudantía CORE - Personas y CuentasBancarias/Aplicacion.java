// Se importan las clases del paquete "clases" para poder usarlas aquí.
// También se puede usar: import clases.*;
import clases.Persona;
import clases.CuentaBancaria;

public class Aplicacion {

    public static void main(String[] args) {

        // --- Creación de personas ---
        // Cada objeto Persona recibe nombre y edad vía constructor
        Persona persona1 = new Persona("Pedrito Pascal", 43);
        Persona persona2 = new Persona("Juanito de las Nieves", 35);
        Persona persona3 = new Persona("Felipe Camiroaga", 54);

        System.out.println("--- Información de las personas ---");
        persona1.despliegaInformacion();
        System.out.println();
        persona2.despliegaInformacion();
        System.out.println();
        persona3.despliegaInformacion();

        // --- Creación de cuentas bancarias ---
        // Cada cuenta recibe un saldo inicial y un titular (objeto Persona).
        // Al crearse, se registran automáticamente en la lista estática de CuentaBancaria.
        System.out.println("\n--- Cuentas bancarias creadas ---\n");

        CuentaBancaria cuenta1 = new CuentaBancaria(12000000, persona1);
        CuentaBancaria cuenta2 = new CuentaBancaria(200000, persona2);
        CuentaBancaria cuenta3 = new CuentaBancaria(350000, persona3);

        cuenta1.despliegaInformacion();
        cuenta2.despliegaInformacion();
        cuenta3.despliegaInformacion();

        // --- Operaciones bancarias ---
        // Se prueban depósitos y retiros válidos e inválidos
        // para verificar que las validaciones funcionan correctamente
        System.out.println("\n--- Operaciones bancarias ---\n");

        System.out.println("Depósito en la cuenta de Pedrito Pascal");
        cuenta1.depositar(200000);          // depósito válido

        System.out.println("Depósito en la cuenta de Felipito");
        cuenta3.depositar(560000);          // depósito válido

        System.out.println("\nRetiro en cuenta de Juanito de las Nieves");
        cuenta2.retirar(150000);            // retiro válido

        System.out.println("Retiro en cuenta de Felipito");
        cuenta3.retirar(1500000);           // retiro inválido: monto supera el saldo

        System.out.println("\nDepósito en cuenta de Juanito de las Nieves");
        cuenta2.depositar(-300);            // depósito inválido: monto negativo

        // --- Saldo final de cada cuenta ---
        // Se usa getNumeroCuenta() y getSaldo() para leer atributos privados
        System.out.println("\n--- Saldo actual de cada cuenta ---");

        System.out.println("Cuenta " + cuenta1.getNumeroCuenta() + "(Pedrito) " + cuenta1.getSaldo());
        System.out.println("Cuenta " + cuenta2.getNumeroCuenta() + "(Juanito) " + cuenta2.getSaldo());
        System.out.println("Cuenta " + cuenta3.getNumeroCuenta() + "(Felipito) " + cuenta3.getSaldo());

        // Método estático: se llama desde la clase, no desde un objeto.
        // Imprime todas las cuentas registradas en la lista compartida.
        CuentaBancaria.imprimeInformacionDeTodasLasCuentas();
    }
}