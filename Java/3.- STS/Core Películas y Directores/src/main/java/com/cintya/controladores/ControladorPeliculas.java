package com.cintya.controladores;

// HashMap nos sirve para guardar pares de datos relacionados: cada película junto a su director
import java.util.HashMap;

// @GetMapping: responde a las peticiones GET, o sea cuando alguien entra a una URL en el navegador
import org.springframework.web.bind.annotation.GetMapping;
// @PathVariable: nos deja leer la parte variable de la URL (lo que va entre llaves {})
import org.springframework.web.bind.annotation.PathVariable;
// @RestController: marca la clase como un controlador que devuelve texto/datos directo al navegador
import org.springframework.web.bind.annotation.RestController;

@RestController // Recibe peticiones web y devuelve texto plano (HTML como String), NO vistas
public class ControladorPeliculas {

	// Aquí guardamos las películas. La CLAVE es el nombre de la peli y el VALOR es su director.
	// Por ejemplo: la clave "Tarzán" guarda el valor "Kevin Lima".
	private static HashMap<String, String> listaPeliculas = new HashMap<String, String>();

	// El constructor se ejecuta UNA sola vez al arrancar la app y llena el HashMap con datos de prueba
	public ControladorPeliculas() {
		listaPeliculas.put("Winnie the Pooh", "Don Hall"); // put(clave, valor) agrega un par
		listaPeliculas.put("El zorro y el sabueso", "Ted Berman");
		listaPeliculas.put("Tarzán", "Kevin Lima");
		listaPeliculas.put("Mulán", "Barry Cook");
		listaPeliculas.put("Oliver", "Kevin Lima");
		listaPeliculas.put("Big Hero 6", "Don Hall");
	}

	// RUTA 1: responde cuando entramos a /peliculas. Muestra TODAS las películas.
	@GetMapping("/peliculas")
	public String obtenerTodasLasPeliculas() {
		// Vamos armando el HTML como un texto: partimos con el título y abrimos la lista <ul>
		String respuesta = "<h1>Lista de Películas</h1><ul>";
		// keySet() nos entrega todas las CLAVES del HashMap, o sea los nombres de las películas
		for (String nombre : listaPeliculas.keySet()) {
			respuesta += "<li>" + nombre + "</li>"; // por cada nombre agregamos un <li>
		}
		respuesta += "</ul>"; // cerramos la lista
		return respuesta;     // devolvemos todo el texto HTML al navegador
	}

	// RUTA 2: responde a /peliculas/algo. Ese "algo" lo capturamos como el nombre de una peli.
	@GetMapping("/peliculas/{nombre}")
	public String obtenerPeliculaPorNombre(@PathVariable("nombre") String nombre) {
		// containsKey() pregunta si esa película existe como clave dentro del HashMap
		if (listaPeliculas.containsKey(nombre)) {
			// get(clave) nos devuelve el valor de esa clave, o sea el director de la película
			String director = listaPeliculas.get(nombre);
			return "<h1>" + nombre + "</h1><p>Director: " + director + "</p>";
		}
		// Si no la encontró, devolvemos un mensaje avisando
		return "<h1>La película no se encuentra en nuestra lista.</h1>";
	}

	// RUTA 3: responde a /peliculas/director/algo. Busca todas las pelis de ESE director.
	@GetMapping("/peliculas/director/{nombre}")
	public String obtenerPeliculasPorDirector(@PathVariable("nombre") String nombreDirector) {
		String respuesta = ""; // aquí vamos juntando los <li> de las pelis que coincidan
		// Recorremos todas las películas del HashMap
		for (String nombre : listaPeliculas.keySet()) {
			// Comparamos el director de cada peli con el que nos pidieron.
			// Ojo: para comparar textos usamos .equals(), NO el == (que compara otra cosa)
			if (listaPeliculas.get(nombre).equals(nombreDirector)) {
				respuesta += "<li>" + nombre + "</li>"; // si coincide, la agregamos a la lista
			}
		}
		// Si la respuesta quedó vacía, es que ningún director coincidió
		if (respuesta.equals("")) {
			return "<h1>No contamos con películas con ese director en nuestra lista. </h1>";
		}
		// Si encontramos al menos una, armamos el título y la lista completa
		return "<h1>Peliculas de " + nombreDirector + "</h1><ul>" + respuesta + "</ul>";
	}
}