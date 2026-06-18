package com.skillnest.cynthia.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

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

	//Ruta 1: Muestra el Formulario
	@GetMapping("/formulario")
	public String formulario() {
		return "formulario.jsp";
	}
	
	//Ruta 2: Recibe la información
	@PostMapping("/registrarUsuario")
	public String registrar(@RequestParam(value="nombreUsuario") String nombre,
							@RequestParam(value="emailUsuario") String email,
							HttpSession session, /*Permite guardar información sesión*/
							RedirectAttributes flash /*Permite enviar errores*/) {
		System.out.println("Nombre: "+nombre);
		System.out.println("Email:"+email);
		
		//Validar la info
		if(nombre.equals("") || email.equals("")) {
			flash.addFlashAttribute("error", "Todos los datos son obligatorios");
			return "redirect:/usuarios/formulario"; 
		}
		
		// session.setAttribute("username", nombre);
		// session.setAttribute("email", email);
		
		return "redirect:/usuarios/bienvenida";
	}
	
	//Ruta 3: Redirección
	@GetMapping("/bienvenida")
	public String bienvenida() {
		return "bienvenida.jsp";
	}
}
