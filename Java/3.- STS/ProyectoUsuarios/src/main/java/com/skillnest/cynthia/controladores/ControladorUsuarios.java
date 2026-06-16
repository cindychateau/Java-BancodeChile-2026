package com.skillnest.cynthia.controladores;

import org.springframework.stereotype.Controller;
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
	
}
