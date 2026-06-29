package com.cynthia.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.cynthia.modelos.Cancion;
import com.cynthia.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {
	
	@Autowired
	private ServicioCanciones sc;
	
	@GetMapping("/canciones")
	public String desplegarCanciones(Model model) {
		List<Cancion> cancionesControlador = sc.obtenerTodasLasCanciones();
		
		model.addAttribute("canciones", cancionesControlador);
		
		return "canciones.jsp";
	}
	
	@GetMapping("/canciones/detalle/{idCancion}") //localhost:8080/canciones/detalle/3
	public String desplegarDetalleCancion(@PathVariable Long idCancion, 
										  Model model) {
		
		Cancion estaCancion = sc.obtenerCancionPorId(idCancion);
		
		model.addAttribute("cancion", estaCancion);
		
		return "detalleCancion.jsp";
	}
	
	//Ruta 1: Muestra el formulario
	@GetMapping("/canciones/formulario/agregar")
	public String formularioAgregarCancion(@ModelAttribute("nuevaCancion") Cancion nuevaCancion) {
		return "agregarCancion.jsp";
	}
	
	
	//Ruta 2: Recibe la info del formulario
	@PostMapping("/canciones/procesa/agregar")
	public String procesarAgregarCancion(@Valid @ModelAttribute("nuevaCancion") Cancion nuevaCancion,
										 BindingResult result) {
		if(result.hasErrors()) {
			return "agregarCancion.jsp";
		} else {
			sc.guardarCancion(nuevaCancion);
			return "redirect:/canciones";
		}
	}
	
	//Ruta 1: Mostrar formulario de edición
	@GetMapping("/canciones/formulario/editar/{idCancion}") // localhost:8080/canciones/formulario/editar/1
	public String formularioEditarCancion(@PathVariable Long idCancion,
										  @ModelAttribute("cancion") Cancion cancion,
										  Model model) {
		
		Cancion cancionAEditar = sc.obtenerCancionPorId(idCancion);
		model.addAttribute("cancion", cancionAEditar);
		
		return "editarCancion.jsp";
	}
	
	//Ruta 2: Reciba la info de edición
	@PutMapping("/canciones/procesa/editar/{id}") //IMPORTANTE: se llame id
	public String procesarEditarCancion(@Valid @ModelAttribute("cancion") Cancion cancion,
										BindingResult result) {
		
		if(result.hasErrors()) {
			return "editarCancion.jsp";
		} else {
			sc.guardarCancion(cancion);
			return "redirect:/canciones";
		}
		
	}
	
	@DeleteMapping("/canciones/eliminar/{id}")
	public String procesarEliminarCancion(@PathVariable Long id) {
		sc.eliminaCancion(id);
		return "redirect:/canciones";
	}
	
	
}
