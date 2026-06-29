package com.skillnest.patitas.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.skillnest.patitas.modelos.LoginUsuario;
import com.skillnest.patitas.modelos.Usuario;
import com.skillnest.patitas.servicios.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorAutenticacion {

	
	@Autowired
	private ServicioUsuarios servicioUsuarios;
	
	@GetMapping("/")
	public String inicio() {
		return "redirect:/login";
	}
	
	@GetMapping("/registro")
	public String registro(@ModelAttribute("usuario") Usuario usuario) {
		return "registro.jsp";
	}
	
	@PostMapping("/registro")
	public String procesarRegistro(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, HttpSession session) {
		Usuario usuarioGuardado = servicioUsuarios.registrar(usuario, result);
		
		if (result.hasErrors()) {
			return "registro.jsp";
		}
		session.setAttribute("usuarioId", usuarioGuardado.getId());
		
		return "redirect:/dashboad";
	}
	
	@GetMapping("/login")
	public String login(@ModelAttribute("loginUsuario") LoginUsuario loginUsuario) {
		return "login.jsp";
	}
	
	@PostMapping("/login")
	public String procesarLogin(@Valid @ModelAttribute("loginUsuario") LoginUsuario loginUsuario,BindingResult result, HttpSession session) {
		Usuario usuario = servicioUsuarios.login(loginUsuario, result);
		if(result.hasErrors()) {
			return "login.jsp";
		}
		
		session.setAttribute("usuarioId", usuario.getId());
		return "redirect:/dashboard";
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
