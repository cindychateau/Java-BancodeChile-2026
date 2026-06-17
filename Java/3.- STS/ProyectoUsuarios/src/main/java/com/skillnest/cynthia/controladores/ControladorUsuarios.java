package com.skillnest.cynthia.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		model.addAttribute("titulo", "Mostrar Usuarios"); //titulo = "Usuarios"
		
		String listaUsuarios[] = {"Elena de Troya", "Juana de Arco", "Pablo Picasso", "Pedro Páramo", "Eli Carta"};
		
		//En JSP: usuarios = {"Elena de Troya", "Juana de Arco", "Pablo Picasso", "Pedro Páramo"}
		model.addAttribute("usuarios", listaUsuarios);
		
		return "mostrar.jsp"; //Al entrar a localhost:8080/usuarios/mostrar despliega mostrar.jsp
	}
	
	//Ruta 1: Muestra el formulario
	@GetMapping("/formulario") // localhost:8080/usuarios/formulario
	public String formulario() {
		return "formulario.jsp";
	}
	
	//Ruta 2: Reciba la información
	@PostMapping("/registrarUsuario")
	public String registrarUsuario(@RequestParam(value="nombreUsuario") String nombre,
								   @RequestParam(value="emailUsuario") String email) {
		//nombre = "Elena de Troya"
		//email = "elena@skillnest.com
		System.out.println(nombre+" - "+email);
		
		//Validar info
		//Guardar info
		
		return "redirect:/usuarios/bienvenida"; //REDIRECTS no llevan .jsp, ruta	
		
	}
	
	//Ruta 3: Redirección
	@GetMapping("/bienvenida")
	public String bievenida() {
		return "bienvenida.jsp";
	}
	
	
}
