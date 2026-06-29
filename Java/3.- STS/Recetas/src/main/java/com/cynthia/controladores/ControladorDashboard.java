package com.cynthia.controladores;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.cynthia.modelos.Receta;
import com.cynthia.modelos.Usuario;
import com.cynthia.servicios.ServicioRecetas;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorDashboard {

	//Inyección de Dependencia de Servicio
	@Autowired
	private ServicioRecetas servicioR;
	
	//Dashboard
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		/*===== Revisar que el usuario haya iniciado sesión =====*/
		if(session.getAttribute("usuarioEnSesion") == null) {
			//No ha iniciado sesión
			return "redirect:/"; //redirijo al inicio de sesión
		}
		/*===== =====*/
		
		List<Receta> recetas = servicioR.todasLasRecetas();
		model.addAttribute("recetas", recetas);
		
		return "dashboard.jsp";
	}
	
	//1: Muestra form
	@GetMapping("/nuevo")
	public String nuevo(@ModelAttribute("receta") Receta receta,
						HttpSession session) {
		
		/*===== Revisar que el usuario haya iniciado sesión =====*/
		if(session.getAttribute("usuarioEnSesion") == null) {
			//No ha iniciado sesión
			return "redirect:/"; //redirijo al inicio de sesión
		}
		/*===== =====*/
		
		return "nuevo.jsp";
	}
	
	//2: recibe la info
	@PostMapping("/crear")
	public String crear(@Valid @ModelAttribute("receta") Receta receta,
						BindingResult result) {
		
		if(result.hasErrors()) {
			return "nuevo.jsp";
		} else {
			servicioR.guardarReceta(receta);
			return "redirect:/dashboard";
		}
		
	}
	
	@GetMapping("/editar/{id}") //localhost:8080/editar/2
	public String editar(@PathVariable Long id,
						 @ModelAttribute("receta") Receta receta,
						 Model model,
						 HttpSession session) {
		/*===== Revisar que el usuario haya iniciado sesión =====*/
		if(session.getAttribute("usuarioEnSesion") == null) {
			//No ha iniciado sesión
			return "redirect:/"; //redirijo al inicio de sesión
		}
		/*===== =====*/
		
		Receta recetaAEditar = servicioR.buscarReceta(id);
		
		//Hacer un double check de que esa receta haya sido creada por el usuario en sesión
		Usuario usuarioEnSesion = (Usuario)session.getAttribute("usuarioEnSesion");
		if(usuarioEnSesion.getId() != recetaAEditar.getCreador().getId()) {
			return "redirect:/dashboard";
		}
		
		model.addAttribute("receta", recetaAEditar);
		
		
		return "editar.jsp";
	}
	
	@PutMapping("/actualizar/{id}")
	public String actualizar(@Valid @ModelAttribute("receta") Receta receta,
							 BindingResult result) {
		
		if(result.hasErrors()) {
			return "editar.jsp";
		} else {
			servicioR.guardarReceta(receta);
			return "redirect:/dashboard";
		}
		
	}
	
	@GetMapping("/mostrar/{id}")
	public String mostrar(@PathVariable Long id,
						  Model model,
						  HttpSession session){
		/*===== Revisar que el usuario haya iniciado sesión =====*/
		if(session.getAttribute("usuarioEnSesion") == null) {
			//No ha iniciado sesión
			return "redirect:/"; //redirijo al inicio de sesión
		}
		/*===== =====*/
		
		Receta receta = servicioR.buscarReceta(id);
		model.addAttribute("receta", receta);
		
		//Version actualizada de usuario en sesión
		Usuario usuarioEnSesion = (Usuario)session.getAttribute("usuarioEnSesion");
		Usuario usuario = servicioR.buscarUsuario(usuarioEnSesion.getId());
		model.addAttribute("usuario", usuario);
		
		
		
		return "mostrar.jsp";
		
	}
	
	@DeleteMapping("/borrar/{id}")
	public String borrar(@PathVariable Long id) {
		servicioR.borrarReceta(id);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/agregarFavoritos/{usuarioId}/{recetaId}")
	public String agregarFavoritos(@PathVariable Long usuarioId,
								   @PathVariable Long recetaId,
								   HttpSession session) {
		/*===== Revisar que el usuario haya iniciado sesión =====*/
		if(session.getAttribute("usuarioEnSesion") == null) {
			//No ha iniciado sesión
			return "redirect:/"; //redirijo al inicio de sesión
		}
		/*===== =====*/
		
		servicioR.guardarEnFavoritos(usuarioId, recetaId);
		return "redirect:/mostrar/"+recetaId;
		
	}
	
	@GetMapping("/quitarFavoritos/{usuarioId}/{recetaId}")
	public String quitarFavoritos(@PathVariable Long usuarioId,
								   @PathVariable Long recetaId,
								   HttpSession session) {
		/*===== Revisar que el usuario haya iniciado sesión =====*/
		if(session.getAttribute("usuarioEnSesion") == null) {
			//No ha iniciado sesión
			return "redirect:/"; //redirijo al inicio de sesión
		}
		/*===== =====*/
		
		servicioR.quitarFavoritos(usuarioId, recetaId);
		return "redirect:/mostrar/"+recetaId;
		
	}
	
	@GetMapping("/favoritas")
	public String favoritas(HttpSession session,
							Model model) {
		
		/*===== Revisar que el usuario haya iniciado sesión =====*/
		if(session.getAttribute("usuarioEnSesion") == null) {
			//No ha iniciado sesión
			return "redirect:/"; //redirijo al inicio de sesión
		}
		/*===== =====*/
		
		//Version actualizada de usuario en sesión
		Usuario usuarioEnSesion = (Usuario)session.getAttribute("usuarioEnSesion");
		Usuario usuario = servicioR.buscarUsuario(usuarioEnSesion.getId());
		model.addAttribute("usuario", usuario);
		
		return "favoritas.jsp";
		
	}
	
	@GetMapping("/buscar")
	public String buscar(@RequestParam String palabra,
						 HttpSession session,
						 Model model) {
		
		/*===== Revisar que el usuario haya iniciado sesión =====*/
		if(session.getAttribute("usuarioEnSesion") == null) {
			//No ha iniciado sesión
			return "redirect:/"; //redirijo al inicio de sesión
		}
		/*===== =====*/
		
		List<Receta> recetasEncontradas = servicioR.buscarPorNombre(palabra);
		model.addAttribute("recetas", recetasEncontradas);
		
		
		return "dashboard.jsp";
		
	}
	
}
