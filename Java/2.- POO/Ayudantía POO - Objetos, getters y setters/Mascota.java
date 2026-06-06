
// CLASE: Mascota


public class Mascota {


    // ATRIBUTOS
    // Son las características de cada mascota.
    // Se declaran como "private" para que no puedan ser
    // modificados directamente desde fuera de la clase.
    // Solo se accede a ellos mediante getters y setters.


    private String nombre;        // Nombre de la mascota (ej: "Simón")
    private String especie;       // Especie (ej: "Perro", "Gato", "Conejo")
    private String raza;          // Raza específica (ej: "Labrador", "Angora")
    private int edad;             // Edad en años
    private double peso;          // Peso en kilogramos
    private boolean estaVacunada; // true si está vacunada, false si no



    // CONSTRUCTOR
    // Método especial que se ejecuta automáticamente al hacer
    // new Mascota(...). Recibe los datos iniciales y los asigna
    // a los atributos usando "this." para distinguir el atributo
    // del parámetro cuando tienen el mismo nombre.


    public Mascota(String nombre, String especie, String raza, int edad, double peso) {
        this.nombre = nombre;       // Asigna el parámetro "nombre" al atributo "nombre"
        this.especie = especie;     // Asigna el parámetro "especie" al atributo "especie"
        this.raza = raza;           // Asigna el parámetro "raza" al atributo "raza"
        this.edad = edad;           // Asigna el parámetro "edad" al atributo "edad"
        this.peso = peso;           // Asigna el parámetro "peso" al atributo "peso"
        this.estaVacunada = false;  // Por defecto toda mascota llega sin vacunar
    }


    // MÉTODOS DE INSTANCIA
    // Son acciones que puede realizar cada objeto Mascota.
    // Se ejecutan sobre un objeto específico usando: objeto.metodo()


    // Imprime en consola la ficha completa de la mascota
    public void mostrarInformacion() {
        System.out.println("------------------------");
        System.out.println("Ficha de la mascota:");
        System.out.println("Nombre  : " + this.nombre);
        System.out.println("Especie : " + this.especie);
        System.out.println("Raza    : " + this.raza);
        System.out.println("Edad    : " + this.edad);
        System.out.println("Peso    : " + this.peso);

        // Operador ternario: si estaVacunada es true imprime "Sí", si no imprime "No"
        // Sintaxis: (condición) ? "valor si true" : "valor si false"
        System.out.println("Vacunada: " + (this.estaVacunada ? "Sí" : "No"));
        System.out.println("------------------------");
    }

    // Imprime un saludo distinto según la especie de la mascota
    public void saludar() {
        // equalsIgnoreCase compara dos Strings ignorando mayúsculas/minúsculas
        if (this.especie.equalsIgnoreCase("Perro")) {
            System.out.println(this.nombre + " dice: ¡Guau guau!");
        } else if (this.especie.equalsIgnoreCase("Gato")) {
            System.out.println(this.nombre + " dice: ¡Miau miau!");
        } else {
            // Para cualquier otra especie, muestra este mensaje genérico
            System.out.println(this.nombre + " te mira con curiosidad... O.O");
        }
    }

    // Registra que la mascota fue vacunada
    // Si ya estaba vacunada, avisa que no es necesario repetir
    public void vacunar() {
        if (this.estaVacunada) {
            System.out.println(this.nombre + " ya estaba vacunada. No es necesario repetir.");
        } else {
            this.estaVacunada = true; // Actualiza el atributo a true
            System.out.println(this.nombre + " fue vacunada exitosamente. ¡Bien hecho!");
        }
    }

    // Incrementa la edad de la mascota en 1 año
    public void cumplirAnios() {
        this.edad++; // Equivale a: this.edad = this.edad + 1
        System.out.println("Feliz cumpleaños, " + this.nombre + "! Ahora tiene " + this.edad + " años.");
    }

    // Actualiza el peso de la mascota con un nuevo valor
    // Valida que el peso sea mayor que 0 antes de guardarlo
    public void actualizarPeso(double nuevoPeso) {
        if (nuevoPeso <= 0) {
            // Si el valor no es válido, avisa y no actualiza el atributo
            System.out.println("El peso ingresado no es válido. Debe ser mayor que 0.");
        } else {
            this.peso = nuevoPeso; // Guarda el nuevo peso en el atributo
            System.out.println("Peso actualizado a " + this.peso + " kg.");
        }
    }



    // GETTERS (métodos de acceso)
    // Permiten leer el valor de un atributo privado desde afuera
    // de la clase. Convención de nombre: getNombreAtributo()
  

    // Retorna el nombre de la mascota
    public String getNombre() {
        return this.nombre;
    }

    // Retorna la especie de la mascota
    public String getEspecie() {
        return this.especie;
    }

    // Retorna la raza de la mascota
    public String getRaza() {
        return this.raza;
    }

    // Retorna la edad de la mascota
    public int getEdad() {
        return this.edad;
    }

    // Retorna el peso de la mascota
    public double getPeso() {
        return this.peso;
    }

    // Retorna si la mascota está vacunada (true) o no (false)
    // Para atributos booleanos la convención es usar "is" en vez de "get"
    public boolean isEstaVacunada() {
        return this.estaVacunada;
    }



    // SETTERS (métodos de modificación)
    // Permiten cambiar el valor de un atributo privado desde
    // afuera de la clase. Convención de nombre: setNombreAtributo()


    // Cambia el nombre de la mascota
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Cambia la especie de la mascota
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    // Cambia la raza de la mascota
    public void setRaza(String raza) {
        this.raza = raza;
    }

    // Cambia la edad, validando que no sea un número negativo
    public void setEdad(int edad) {
        if (edad >= 0) {
            this.edad = edad;
        } else {
            System.out.println("La edad no puede ser negativa.");
        }
    }

    // Cambia el peso, validando que sea un número mayor que 0
    // El parámetro es double para aceptar valores decimales (ej: 4.5 kg)
    public void setPeso(double peso) {
        if (peso > 0) {
            this.peso = peso;
        } else {
            System.out.println("El peso debe ser mayor a 0.");
        }
    }

    // Cambia directamente el estado de vacunación de la mascota
    public void setEstaVacunada(boolean estaVacunada) {
        this.estaVacunada = estaVacunada;
    }

}