package clases;

import java.util.ArrayList;
import java.util.Random;

// Clase que representa una cuenta bancaria asociada a un titular (Persona).
// Lleva el registro de todas las cuentas creadas mediante un atributo estático.
public class CuentaBancaria {

    private double saldo;        // saldo disponible en la cuenta
    private Persona titular;     // persona dueña de esta cuenta
    private int numeroCuenta;    // número único generado automáticamente al crear la cuenta

    // Atributo estático: es compartido por TODAS las instancias de CuentaBancaria.
    // Funciona como un registro global de todas las cuentas creadas.
    private static ArrayList<CuentaBancaria> listaDeCuentasBancarias = new ArrayList<>();

    // Constructor: recibe el saldo inicial y el titular.
    // Genera un número de cuenta aleatorio de 6 dígitos (entre 100000 y 999999)
    // y agrega esta cuenta a la lista estática compartida.
    public CuentaBancaria(double saldo, Persona titular) {
        this.saldo = saldo;
        this.titular = titular;
        this.numeroCuenta = new Random().nextInt(900000) + 100000;

        listaDeCuentasBancarias.add(this); // se registra a sí misma en la lista global
    }


    // Agrega monto al saldo. Valida que el monto sea positivo.
    public void depositar(double monto) {
        if (monto <= 0) {
            System.out.println("El monto a depositar debe ser mayor a 0.");
        } else {
            this.saldo += monto;
            System.out.println("Depósito exitoso. Nuevo saldo: $" + this.saldo);
        }
    }

    // Resta monto del saldo. Valida que el monto sea positivo y que haya saldo suficiente.
    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("El monto a retirar debe ser mayor que 0.");
        } else if (monto > this.saldo) {
            System.out.println("Fondos insuficientes. Saldo actual: $" + this.saldo);
        } else {
            this.saldo -= monto;
            System.out.println("Retiro exitoso. Nuevo saldo: $" + this.saldo);
        }
    }

    // Imprime en consola los datos de esta cuenta y los datos del titular
    public void despliegaInformacion() {
        System.out.println("-----------------------");
        System.out.println("Número de cuenta: " + this.numeroCuenta);
        System.out.println("Saldo           :" + this.saldo);
        System.out.println("--- Titular ---");
        this.titular.despliegaInformacion(); // reutiliza el método de la clase Persona
        System.out.println("-----------------------");
    }

    // Método estático: se llama desde la clase, no desde un objeto.
    // Recorre la lista global e imprime la información de todas las cuentas registradas.
    public static void imprimeInformacionDeTodasLasCuentas() {
        System.out.print("\n-------- TODAS LAS CUENTAS BANCARIAS--------");

        if (listaDeCuentasBancarias.isEmpty()) {
            System.out.println("No hay cuentas registradas.");
        } else {
            for (CuentaBancaria cuenta : listaDeCuentasBancarias) {
                cuenta.despliegaInformacion();
            }
        }

        System.out.println("Total de cuentas: " + listaDeCuentasBancarias.size());
        System.out.println("------------------------------------");
    }

    // --- Getters ---

    public double getSaldo() {
        return this.saldo;
    }

    public Persona getTitular() {
        return this.titular;
    }

    public int getNumeroCuenta() {
        return this.numeroCuenta;
    }

    // Getter estático: devuelve la lista completa de cuentas registradas
    public static ArrayList<CuentaBancaria> getCuentaBancarias() {
        return listaDeCuentasBancarias;
    }

    // --- Setters ---

    // Solo acepta saldo >= 0
    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            System.out.println("El saldo no puede ser negativo.");
        }
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
}