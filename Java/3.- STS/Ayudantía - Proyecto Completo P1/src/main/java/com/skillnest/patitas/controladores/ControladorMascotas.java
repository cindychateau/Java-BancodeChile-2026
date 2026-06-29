package com.skillnest.patitas.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.skillnest.patitas.modelos.Usuario;
import com.skillnest.patitas.servicios.ServicioUsuarios;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;

@Controller
public class ControladorMascotas {
	
	@Autowired
	private ServicioUsuarios servicioUsuarios;
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		if (session.getAttribute("usuarioId") == null) {
			return "redirect:/login";
		}
		
		Long usuarioId = (Long) session.getAttribute("usuarioId");
		Usuario usuarioEnSesion = servicioUsuarios.obtenerPorId(usuarioId);
		model.addAttribute("usuarioEnSesion", usuarioEnSesion);
		
		return "dashboard.jsp";
	}

}
