// CLASE: Aplicacion


public class Aplicacion {

    public static void main(String[] args) {



        // CREAR OBJETOS (instanciar la clase Mascota)
        // Usamos "new Mascota(...)" para llamar al constructor.
        // Cada objeto tiene sus propios datos independientes.
        // Sintaxis: NombreClase nombreVariable = new NombreClase(parámetros);


        // Creamos la primera mascota: un perro llamado Simón
        // Parámetros del constructor: nombre, especie, raza, edad, peso
        Mascota mascota1 = new Mascota("Simón", "Perro", "Labrador", 1, 20);

        // Creamos la segunda mascota: una gata llamada Michi
        Mascota mascota2 = new Mascota("Michi", "Gato", "Angora", 6, 5.5);

        // Creamos la tercera mascota: un conejo llamado Topo
        Mascota mascota3 = new Mascota("Topo", "Conejo", "Pelo corto", 2, 3.1);


        // USAR MÉTODOS DE INSTANCIA
        // Llamamos a los métodos usando: objeto.metodo()
        // El método se ejecuta sobre ese objeto específico.


        System.out.println("\n--- Información inicial de las mascotas ---\n");

        // Mostramos la ficha completa de cada mascota
        mascota1.mostrarInformacion();
        mascota2.mostrarInformacion();
        mascota3.mostrarInformacion();


        System.out.println("\n--- ¡Las mascotas saludan! ---\n");

        // Cada mascota saluda de forma distinta según su especie
        mascota1.saludar(); // Simón es perro → "¡Guau guau!"
        mascota2.saludar(); // Michi es gato  → "¡Miau miau!"
        mascota3.saludar(); // Topo es conejo → mensaje genérico


        System.out.println("\n--- Vacunando a las mascotas ---\n");

        // Vacunamos a Simón y Michi por primera vez
        mascota1.vacunar();
        mascota2.vacunar();

        // Intentamos vacunar a Simón de nuevo
        // Como ya estaba vacunado, el método avisará que no es necesario
        mascota1.vacunar();


        System.out.println("\n--- Actualizando pesos tras control veterinario ---\n");

        // Actualizamos el peso de Topo con un valor válido
        mascota3.actualizarPeso(2.0);

        // Intentamos actualizar el peso de Michi con un valor negativo
        // El método validará que sea mayor que 0 y mostrará un aviso
        mascota2.actualizarPeso(-2.1);


        System.out.println("\n--- ¡Cumpleaños de Simón! ---\n");

        // Simón cumple años: su edad aumenta en 1 dentro del método
        mascota1.cumplirAnios();


   
        // USAR GETTERS
        // Como los atributos son private, no podemos acceder a ellos
        // directamente (mascota1.nombre daría error).
        // Los getters nos permiten leerlos de forma controlada.


        // Leemos el nombre actual de mascota1 usando su getter
        System.out.println("Nombre de mascota1: " + mascota1.getNombre());



        // USAR SETTERS
        // Igual que los getters, los setters son el único camino
        // para modificar atributos privados desde fuera de la clase.


        // Cambiamos el nombre de mascota1 usando su setter
        mascota1.setNombre("Pancracio");

        // Verificamos que el cambio se aplicó correctamente con el getter
        System.out.println("Nombre de mascota1: " + mascota1.getNombre());

    }

}