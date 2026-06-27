package com.cynthia.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cynthia.modelos.Pelicula;
import com.cynthia.servicios.ServicioPeliculas;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorDashboard {
	
	@Autowired
	private ServicioPeliculas servicioPelis;
	
	/*
	 * Controlador llama a Servicio (y muestra jsp)
	 * Servicio llama a repo
	 * Repo se basa en Modelo 
	 * 
	 * Orden de creación: Modelo, Repositorio, Servicio, Controlador, .jsp
	 */
	
	//Dashboard
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		/*===== Revisar que el usuario haya iniciado sesión =====*/
		if(session.getAttribute("usuarioEnSesion") == null) {
			//No ha iniciado sesión
			return "redirect:/"; //redirijo al inicio de sesión
		}
		/*===== =====*/
		
		List<Pelicula> peliculas = servicioPelis.obtenerTodasPelis();
		model.addAttribute("peliculas", peliculas);
		
		return "dashboard.jsp";
	}
	
	//Ruta que muestra el formulario
	@GetMapping("/nuevo")
	public String nuevo(@ModelAttribute("nuevaPeli") Pelicula nuevaPeli, 
						HttpSession session) {
		/*===== Revisar que el usuario haya iniciado sesión =====*/
		if(session.getAttribute("usuarioEnSesion") == null) {
			//No ha iniciado sesión
			return "redirect:/"; //redirijo al inicio de sesión
		}
		/*===== =====*/
		
		
		return "nuevo.jsp";
	}
	
	@PostMapping("/crear")
	public String crear(@Valid @ModelAttribute("nuevaPeli") Pelicula nuevaPeli,
						BindingResult result) {
		
		if(result.hasErrors()) {
			return "nuevo.jsp";
		} else {
			servicioPelis.guardarPeli(nuevaPeli);
			return "redirect:/dashboard";
		}
		
	}
	
}
