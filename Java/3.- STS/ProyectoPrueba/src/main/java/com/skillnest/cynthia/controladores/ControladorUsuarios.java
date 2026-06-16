package com.skillnest.cynthia.controladores;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class ControladorUsuarios {
	
	
	@GetMapping("/")
	public String index() {
		return "index.jsp"; 
	}
	
	@GetMapping("/mostrar")
	public String muestraUsuario(Model model) {
		
		/*Usuario user1 = new Usuario("Cynthia", "Castillo", 1);
		Usuario user2 = new Usuario("Valeria", "Romero", 2);*/
		
		model.addAttribute("titulo", "Usuarios");
		
		String usuarios[] = {"Elena de Troya", "Juana de Arco", "Pablo Picasso", "Pedro Paramo"};
		
		model.addAttribute("users", usuarios);
		
		return "mostrar.jsp";
		
	}
}
