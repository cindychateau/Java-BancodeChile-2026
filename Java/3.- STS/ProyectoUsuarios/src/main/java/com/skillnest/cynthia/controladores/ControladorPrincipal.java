package com.skillnest.cynthia.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.skillnest.cynthia.modelos.Usuario;
import com.skillnest.cynthia.servicios.Servicios;

import jakarta.validation.Valid;

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
	
	//1.- Mostramos formulario
	@GetMapping("/nuevo")
	public String nuevo(@ModelAttribute("usuario") Usuario usuario) {
		
		//usuario = Usuario(nombre="", apellido="", email="");
		
		//@ModelAttribute crear un objeto vacío de Usuario y lo manda al jsp
		
		return "nuevo.jsp";
	}
	
	//2.- Recibir la info
	@PostMapping("/crear")
	public String crear(@Valid @ModelAttribute("usuario") Usuario usuario, /*@Valid: valida la info del objeto*/
						BindingResult result /*Encargado de regresar los errores*/) {
		
		if(result.hasErrors()) { //Si existen errores
			return "nuevo.jsp"; //Muestra nuevo.jsp para que los errores se muestren
		} else {
			servicios.guardarUsuario(usuario);
			return "redirect:/dashboard";
		}
		
	}
	
	@GetMapping("/usuario/{id}") //localhost:8080/usuario/5
	public String usuarioPorId(@PathVariable Long id,
							   Model model) {
		//id = 5
		
		Usuario esteUsuario = servicios.obtenerUsuarioPorId(id);
		model.addAttribute("usuario", esteUsuario);
		return "usuario.jsp";
		
	}
	
	
	
}
