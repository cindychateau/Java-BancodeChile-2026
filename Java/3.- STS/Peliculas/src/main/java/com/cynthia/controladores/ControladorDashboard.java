package com.cynthia.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class ControladorDashboard {
	
	//Pte: Servicio
	
	//Dashboard
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session) {
		if(session.getAttribute("usuarioEnSesion") == null) {
			//No ha iniciado sesión
			return "redirect:/"; //redirijo al inicio de sesión
		}
		
		return "dashboard.jsp";
	}
}
