package com.skillnest.cynthia.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//localhost:8080/usuarios/ 
//localhost:8080/usuarios/mostrar
//localhost:8080/usuarios/bienvenida
@RequestMapping("/usuarios") //Todas las rutas que tengo en este controlador van a comenzar con /usuarios
public class ControladorUsuarios {
	
	@GetMapping("/")
	public String index() {
		return "index.jsp"; //Regresamos el nombre del archivo que quiero mostrar ante esa ruta
	}
	
	@GetMapping("/mostrar") //localhost:8080/usuarios/mostrar
	public String mostrar(Model model) { //Model model permite enviar información del método hacia JSP
		
		//Crear una variable llamada titulo que tiene valor "Usuarios" y envío a JSP
		model.addAttribute("titulo", "Usuarios"); //titulo = "Usuarios"
		
		String listaUsuarios[] = {"Elena de Troya", "Juana de Arco", "Pablo Picasso", "Pedro Páramo"};
		
		//En JSP: usuarios = {"Elena de Troya", "Juana de Arco", "Pablo Picasso", "Pedro Páramo"}
		model.addAttribute("usuarios", listaUsuarios);
		
		return "mostrar.jsp"; //Al entrar a localhost:8080/usuarios/mostrar despliega mostrar.jsp
	}
	
}
