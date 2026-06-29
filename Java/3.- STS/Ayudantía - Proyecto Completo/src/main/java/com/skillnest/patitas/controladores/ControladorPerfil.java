package com.skillnest.patitas.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;

import com.skillnest.patitas.modelos.Usuario;
import com.skillnest.patitas.servicios.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorPerfil {

		@Autowired
		private ServicioUsuarios servicioUsuarios;
		
		@GetMapping("/perfil")
		public String perfil(HttpSession session, Model model) {
			if (session.getAttribute("usuarioId") == null) {
				return "redirect:/login";
			}
			
			Long id = (Long) session.getAttribute("usuarioId");
			Usuario usuario = servicioUsuarios.obtenerPorId(id);
			
			usuario.setPassword(" ");
			model.addAttribute("usuario", usuario);
			return "miPerfil.jsp";
		}
		
		@PutMapping("/perfil/actualizar")
		public String actualizar(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, HttpSession session ) {
			if (session.getAttribute("usuarioId") == null) {
				return "redirect:/login";
			}
			
			Long id = (Long) session.getAttribute("usuarioId");
			usuario.setId(id);
			
			servicioUsuarios.actualizarPerfil(usuario, result);
			if (result.hasErrors()) {
				return "miPerfil.jsp";
			}
			return "redirect:/dashboard";
		}
}
