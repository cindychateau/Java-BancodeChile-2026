package com.skillnest.patitas.controladores;

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

import com.skillnest.patitas.modelos.Mascota;
import com.skillnest.patitas.modelos.Usuario;
import com.skillnest.patitas.servicios.ServicioMascotas;
import com.skillnest.patitas.servicios.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorMascotas {
	
	@Autowired
	private ServicioUsuarios servicioUsuarios;
	
	@Autowired
	private ServicioMascotas servicioMascotas;
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		if (session.getAttribute("usuarioId") == null) {
			return "redirect:/login";
		}
		
		Long usuarioId = (Long) session.getAttribute("usuarioId");
		Usuario usuarioEnSesion = servicioUsuarios.obtenerPorId(usuarioId);
		model.addAttribute("usuarioEnSesion", usuarioEnSesion);

		List<Mascota> mascotas = servicioMascotas.obtenerTodas();
		model.addAttribute("mascotas", mascotas);
		return "dashboard.jsp";
	}
	
	@GetMapping("/mascotas/nueva")
	public String nueva(@ModelAttribute("mascota") Mascota mascota, HttpSession session) {
		if (session.getAttribute("usuarioId") == null) {
			return "redirect:/login";
		}
		return "nuevaMascota.jsp";
	}
	
	@PostMapping("/mascotas/crear")
	public String crear(@Valid @ModelAttribute("mascota") Mascota mascota, BindingResult result, HttpSession session) {
		if (session.getAttribute("usuarioId") == null) {
			return "redirect:/login";
		}
		Long usuarioId = (Long) session.getAttribute("usuarioId");
		Usuario dueno = servicioUsuarios.obtenerPorId(usuarioId);
		mascota.setPublicadoPor(dueno);
		
		servicioMascotas.crear(mascota,  result);
		if (result.hasErrors()) {
			return "nuevaMascota.jsp";
		}
		return "redirect:/dashboard";
	}
	
	@GetMapping("/mascotas/{id}")
	public String detalle(@PathVariable("id") Long id, HttpSession session, Model model) {
		if (session.getAttribute("usuarioId") == null) {
			return "redirect:/login";
		}
		Mascota mascota = servicioMascotas.obtenerPorId(id);
		model.addAttribute("mascota", mascota);
		return "detalle.jsp";
	}
	
	@DeleteMapping("/mascotas/{id}")
	public String eliminar(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("usuarioId") == null) {
			return "redirect:/login";
		}
		servicioMascotas.eliminar(id);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/mascotas/{id}/editar")
	public String editar(@PathVariable("id") Long id, @ModelAttribute("mascota") Mascota mascota, HttpSession session, Model model) {
		if (session.getAttribute("usuarioId") == null) {
			return "redirect:/login";
		}
		
		Mascota esta = servicioMascotas.obtenerPorId(id);
		model.addAttribute("mascota", esta);
		return "editarMascota.jsp";
	}
	
	@PutMapping("/mascotas/{id}/actualizar")
	public String actualizar(@PathVariable("id") Long id, @Valid @ModelAttribute("mascota") Mascota mascota, BindingResult result, HttpSession session) {
		if (session.getAttribute("usuarioId") == null) {
			return "redirect:/login";
		}
		mascota.setId(id);
		
		Mascota original = servicioMascotas.obtenerPorId(id);
		mascota.setPublicadoPor(original.getPublicadoPor());
		
		servicioMascotas.actualizar(mascota, result);
		if (result.hasErrors()) {
			return "editarMascota.jsp";
		}
		return "redirect:/dashboard";
	}

}
