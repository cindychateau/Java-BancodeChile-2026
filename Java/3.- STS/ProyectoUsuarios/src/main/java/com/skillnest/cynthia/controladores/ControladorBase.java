package com.skillnest.cynthia.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@ - Anotación
//Ctrl + Shift + O o en Mac Command + Shift + O para importar automaticamente
@RestController //indica que el archivo es un controlador, establece las rutas del proyecto
public class ControladorBase {
	
	//NO PODEMOS REPETIR RUTAS
	//NI PUEDO REPETIR NOMBRE DE MÉTODOS, a menos queeeeeee: sobrecargue
	
	@GetMapping("/") //Establezco una ruta, ejecutar el método
	public String home() {
		return "<h1>¡Hola desde Spring</h1>";
	}
	
	/*
	 respuesta = <ul>
	 i = 0
	 respuesta = <ul><li>Michi</li>
	 
	 i = 1
	 respuesta = <ul><li>Michi</li><li>Miu</li>
	 
	 i = 2
	 respuesta = <ul><li>Michi</li><li>Miu</li><li>Max</li>
	 
	 i = 3
	 respuesta = <ul><li>Michi</li><li>Miu</li><li>Max</li><li>Luna</li></ul>
	 */
	@GetMapping("/mascotas")
	public String mascotas() {
		String mascotitas[] = {"Michi", "Miu", "Max", "Luna"};
		String respuesta = "<ul>";
		
		for(int i=0; i < mascotitas.length; i++) {
			respuesta += "<li>"+mascotitas[i]+"</li>";
		}
			
		respuesta += "</ul>";
		return respuesta;
	}
	
	@GetMapping("/search") //localhost:8080/search?busqueda=Belleza
	public String buscar(@RequestParam(value="busqueda") String termino) { //termino = Belleza
		return "<h2>Estás buscando: "+termino+"</h2>";
	}
	
	@GetMapping("/hola") //localhost:8080/hola?nombre=Cynthia&apellido=Castillo
	public String hola(@RequestParam(value="nombre") String firstName,
					   @RequestParam(value="apellido") String lastName) {
		return "Hola "+firstName+" "+lastName;
	}
	
	@GetMapping("/cursos/{nombreDelCurso}") //localhost:8080/cursos/fullstackjava
	public String cursos(@PathVariable("nombreDelCurso") String nombreCurso) {
		return "<h1>Estás ingresando al curso de: "+nombreCurso+"</h1>";
	}
	
	//localhost:8080/cursos/fullstackjava/leccion/spring
	@GetMapping("/cursos/{nombreDelCurso}/leccion/{nombreDeLeccion}")
	public String cursos(@PathVariable("nombreDelCurso") String nombreCurso,
				  		 @PathVariable("nombreDeLeccion") String nombreLeccion) {
		return "<h1>Estás ingresando al curso de: "+nombreCurso+". La lección es: "+nombreLeccion+"</h1>";
	}
	
	
	
	
	
}
