package com.skillnest.patitas.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.skillnest.patitas.modelos.Usuario;
import com.skillnest.patitas.servicios.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorAutenticacion {

	
	@Autowired
	private ServicioUsuarios servicioUsuarios;
	
	@GetMapping("/")
	public String inicio() {
		return "redirect:/login";
	}
	
	@GetMapping("/registro")
	public String registro(@ModelAttribute("usuario") Usuario usuario) {
		return "registro.jsp";
	}
	
	@PostMapping("/registro")
	public String procesarRegistro(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, HttpSession session) {
		Usuario usuarioGuardado = servicioUsuarios.registrar(usuario, result);
		
		if (result.hasErrors()) {
			return "registro.jsp";
		}
		session.setAttribute("usuarioId", usuarioGuardado.getId());
		
		return "redirect:/dashboad";
	}
}
