package clases;

// Clase que representa a una persona con nombre y edad.
// Sus atributos son privados: solo se accede a ellos desde fuera
// usando los métodos getter y setter.
public class Persona {

    private String nombre;  // nombre de la persona
    private int edad;       // edad de la persona


    // Constructor: recibe nombre y edad para crear una persona
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Imprime en consola el nombre y la edad de la persona
    public void despliegaInformacion() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Edad  : " + this.edad);
    }


    // --- Getters: permiten leer los atributos privados desde fuera ---

    public String getNombre() {
        return this.nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    // --- Setters: permiten modificar los atributos con validación ---

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Solo acepta edades >= 0, evitando valores sin sentido
    public void setEdad(int edad) {
        if (edad >= 0) {
            this.edad = edad;
        } else {
            System.out.println("La edad no puede ser negativa.");
        }
    }
}