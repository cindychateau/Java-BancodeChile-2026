package com.cynthia.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cynthia.modelos.Cancion;
import com.cynthia.servicios.ServicioCanciones;

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
	
}
