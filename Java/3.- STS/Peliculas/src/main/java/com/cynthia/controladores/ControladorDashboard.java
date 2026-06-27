package com.cynthia.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cynthia.modelos.Pelicula;
import com.cynthia.servicios.ServicioPeliculas;

import jakarta.servlet.http.HttpSession;

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
	
}
