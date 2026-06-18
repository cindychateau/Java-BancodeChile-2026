package com.skillnest.cynthia.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.skillnest.cynthia.modelos.Usuario;
import com.skillnest.cynthia.servicios.Servicios;

@Controller
public class ControladorPrincipal {
	
		@Autowired
	   private final Servicios servicio;

	   public ControladorPrincipal(Servicios servicio) {
	       this.servicio = servicio;
	   }
	  
	   @GetMapping("/dashboard")
	   public String desplegarUsuarios(Model model) {
	       List<Usuario> usuarios = servicio.obtenerTodosLosUsuarios();
	       model.addAttribute("usuarios", usuarios);
	       return "dashboard.jsp";
	   }
	
}
