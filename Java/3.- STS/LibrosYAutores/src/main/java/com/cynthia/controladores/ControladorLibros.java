package com.cynthia.controladores;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorLibros {
	
	private static HashMap<String, String> listaLibros = new HashMap<String, String>();
	
	//Método constructor: Encargado de inicializar la lista de libros
	public ControladorLibros() {
		listaLibros.put("Odisea", "Homero");	
		listaLibros.put("Don Quijote de la Mancha", "Miguel de Cervantes");
		listaLibros.put("El Código Da Vinci", "Dan Brown");		
		listaLibros.put("Alicia en el país de las maravillas", "Lewis Carroll");
		listaLibros.put("El Hobbit", "J.R.R. Tolkien");	
		listaLibros.put("El alquimista", "Paulo Coelho");	
	}
	
	@GetMapping("/libros")
	public String obtenerTodosLosLibros(Model model) {
		model.addAttribute("listaLibros", listaLibros);
		return "libros.jsp";
	}
	
	@GetMapping("/libros/{nombre}") //localhost:8080/libros/Odisea
	public String obtenerInformacionDeLibro(@PathVariable("nombre") String nombreLibro, Model model /*Permite enviar info del método al jsp*/) {
		//nombreLibro = "Odisea"
		String nombreAutor = listaLibros.get(nombreLibro); //autor = Homero
		
		//autor = Homero (jsp)
		model.addAttribute("autor", nombreAutor); //Crea una variable autor que se puede acceder desde el jsp
		model.addAttribute("libro", nombreLibro); //libro = Odisea (jsp)
		
		return "detalleLibro.jsp";
	}
	
	//1. Muestre Formulario
	@GetMapping("/libros/formulario")
	public String formularioLibro() {
		return "formularioLibros.jsp";
	}
	
	//2. Procese formulario
	@PostMapping("/procesa/libro")
	public String procesaLibro(@RequestParam(value="nombreLibro") String nombreLibro, 
							   @RequestParam(value="nombreAutor") String nombreAutor) {
		//listaLibros.put("Odisea", "Homero");
		//nombreLibro = Cien años de soledad
		//nombreAutor = Gabriel Garcia Marquez
		listaLibros.put(nombreLibro, nombreAutor);//listaLibros.put("Cien años de soledad", "Gabriel Garcia Marquez");
		
		return "redirect:/libros";
		
		
	}
	
	
	
}
