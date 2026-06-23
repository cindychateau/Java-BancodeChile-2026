package com.skillnest.cynthia.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.skillnest.cynthia.modelos.Usuario;
import com.skillnest.cynthia.servicios.Servicios;

import jakarta.validation.Valid;

@Controller
public class ControladorPrincipal {
	
		@Autowired
	   private Servicios servicio;
	  
	   @GetMapping("/dashboard")
	   public String desplegarUsuarios(Model model) {
	       List<Usuario> usuarios = servicio.obtenerTodosLosUsuarios();
	       model.addAttribute("usuarios", usuarios);
	       return "dashboard.jsp";
	   }
	   
	   @GetMapping("/nuevo")
		public String nuevo(@ModelAttribute("usuario") Usuario usuario) {
			
			//@ModelAttribute crea un objeto vacío de Usuario y lo manda a nuevo.jsp
			return "nuevo.jsp";
		}
		
		@PostMapping("/crear")
		public String crear(@Valid @ModelAttribute("usuario") Usuario nuevoUsuario, /*@Valid: valida la info del objeto*/
							BindingResult result /*Encargado de revisar los errores*/) {
			
			if(result.hasErrors()) {
				return "nuevo.jsp";
			} else {
				servicio.guardarUsuario(nuevoUsuario); //Guardar el objeto usuario que recibimos del formulario
				return "redirect:/dashboard";
			}
			
		}
		
		@GetMapping("/mostrar/{id}") // localhost:8080/mostrar/1
		public String mostrar(@PathVariable("id") Long id, /*id = 1*/
							  Model model) { 
			Usuario esteUsuario = servicio.obtenerUsuarioPorId(id); //buscarUsuario(1)
			model.addAttribute("usuario", esteUsuario);
			return "mostrar.jsp";
		}
		
		@DeleteMapping("/borrar/{id}") // localhost:8080/borrar/1
		public String borrar(@PathVariable("id") Long id) { //id = 1
			servicio.eliminarUsuario(id);
			return "redirect:/dashboard";
		}

		@GetMapping("/editar/{id}") // localhost:8080/editar/1
		public String editar(@PathVariable("id") Long id,
							@ModelAttribute("usuario") Usuario usuario /*Crea objeto vacío y lo envía a jsp*/ ,
							Model model) {
			
			//Obtener el objeto de usuario a editar
			Usuario esteUsuario = servicio.obtenerUsuarioPorId(id);
			model.addAttribute("usuario", esteUsuario); //Sobrescribiendo el usuario vacío
			
			return "editar.jsp";
		}
		
		@PutMapping("/actualizar/{id}") //IMPORTANTE: debe llamarse id. Para asignarlo al objeto de ModelAttribute
		public String actualizar(@Valid @ModelAttribute("usuario") Usuario usuarioEditado,
								BindingResult result) {
			
			if(result.hasErrors()) {
				return "editar.jsp";
			} else {
				servicio.guardarUsuario(usuarioEditado);
				return "redirect:/dashboard";
			}
			
		}
	   
	   
	
}
