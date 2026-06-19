package com.skillnest.cynthia.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.skillnest.cynthia.modelos.Usuario;
import com.skillnest.cynthia.servicios.Servicios;

@Controller
public class ControladorPrincipal {
	
	@Autowired
	private Servicios servicios;
	
	@GetMapping("/dashboard")
	public String dashboard(Model model /*Enviar de controlador info a jsp*/) {
		List<Usuario> usuarios = servicios.obtenerTodosLosUsuarios();
		
		//Crea una variable en el jsp. ("nombreVariable", valorVariable)
		model.addAttribute("usuarios", usuarios);
		return "dashboard.jsp";
	}
	
	
	
}
