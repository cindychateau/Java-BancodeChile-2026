package com.cintya.controladores;

// Importamos solo lo que vamos a usar en esta clase
import java.util.HashMap; // Para guardar cada receta junto a su lista de ingredientes
import org.springframework.stereotype.Controller; // Para marcar esta clase como controlador
import org.springframework.ui.Model; // El "puente" para mandarle datos a la vista (al JSP)
import org.springframework.web.bind.annotation.GetMapping; // Responde a peticiones GET (cuando se entra a una URL)
import org.springframework.web.bind.annotation.PathVariable; // Lee un valor que viene dentro de la URL


@Controller // Le avisamos a Spring que esta clase recibe las peticiones que llegan del navegador
public class ControladorRecetas {

    // Arreglo simple con los nombres de las recetas. Es static porque queremos uno solo
    // para toda la clase, y no que se cree uno nuevo cada vez.
    private static String[] listaRecetas = {"Pizza", "Espagueti", "Lasana"};

    // Acá relacionamos cada receta con sus ingredientes.
    // Por eso es HashMap<String, String[]>: la llave es el nombre (String)
    // y el valor es el arreglo de ingredientes (String[]).
    private static HashMap<String, String[]> recetasConIngredientes = new HashMap<String, String[]>();

    // El constructor se ejecuta una sola vez, cuando se crea el controlador.
    // Lo usamos para llenar el HashMap con los datos de partida.
    public ControladorRecetas() {
        // Creamos el arreglo de ingredientes y lo guardamos en el mapa con su llave
        String[] pizza = {"Pan", "Salsa de tomate", "Queso", "Pepperoni"};
        recetasConIngredientes.put("Pizza", pizza);

        String[] espagueti = {"Pasta", "Salsa de tomate", "Carne molida", "Queso parmesano"};
        recetasConIngredientes.put("Espagueti", espagueti);

        String[] lasana = {"Pasta", "Salsa de tomate", "Queso", "Albahaca", "Espinaca", "Champinones"};
        recetasConIngredientes.put("Lasana", lasana);
    }

    // Cuando alguien entra a la URL /recetas se ejecuta este método
    @GetMapping("/recetas")
    public String obtenerTodasLasRecetas(Model model) {

        // Metemos el arreglo dentro del Model con el nombre "listaRecetas".
        // Con ese mismo nombre lo vamos a ir a buscar después en el JSP.
        model.addAttribute("listaRecetas", listaRecetas);

        // Devolvemos el nombre de la vista a mostrar.
        // Junto con el prefijo del application.properties, esto apunta a recetas.jsp
        return "recetas.jsp";
    }

    // Acá la URL lleva una parte variable: lo que va entre llaves {nombre} cambia según la receta.
    // Por ejemplo /recetas/Pizza o /recetas/Espagueti.
    @GetMapping("/recetas/{nombre}")
    public String obtenerRecetasPorNombre(@PathVariable("nombre") String nombre, Model model) {
        // @PathVariable agarra ese pedazo de la URL y lo guarda en la variable nombre

        // Buscamos en el mapa los ingredientes de esa receta.
        // Ojo: si la receta no existe en el mapa, get() devuelve null (eso lo manejamos en el JSP).
        String[] ingredientes = recetasConIngredientes.get(nombre);

        // Mandamos a la vista el nombre de la receta y sus ingredientes
        model.addAttribute("nombreReceta", nombre);
        model.addAttribute("ingredientes", ingredientes);

        return "detalleReceta.jsp";
    }

}