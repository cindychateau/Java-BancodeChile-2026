package com.skillnest.cynthia.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.skillnest.cynthia.modelos.Curso;
import com.skillnest.cynthia.modelos.Hobby;
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
	public String nuevo(@ModelAttribute("usuario") Usuario usuario, 
						Model model) {
		
		//usuario = Usuario(nombre="", apellido="", email="");
		
		//@ModelAttribute crear un objeto vacío de Usuario y lo manda al jsp
		
		List<Curso> listaCursos = servicios.obtenerTodosLosCursos();
		model.addAttribute("cursos", listaCursos);
		
		return "nuevo.jsp";
	}
	
	//2.- Recibir la info
	@PostMapping("/crear")
	public String crear(@Valid @ModelAttribute("usuario") Usuario usuario, /*@Valid: valida la info del objeto*/
						BindingResult result, /*Encargado de regresar los errores*/
						Model model) {
		
		if(result.hasErrors()) { //Si existen errores
			//Vuelve a mandar el listado, por si hay un error, se vuelvan a cargar los cursos
			List<Curso> listaCursos = servicios.obtenerTodosLosCursos();
			model.addAttribute("cursos", listaCursos);
			
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
		
		Usuario esteUsuario = servicios.obtenerUsuarioPorId(id); //Obtengo el usuario en base al id
		model.addAttribute("usuario", esteUsuario);
		return "usuario.jsp";
		
	}
	
	//4 tipos de peticiones: GET (obtener datos o mostrar), POST (crear nuevos registros), DELETE (borrar registros), PUT (actualizar registros)
	
	@DeleteMapping("/borrar/{id}") //localhost:8080/borrar/6
	public String borrar(@PathVariable Long id) { //id = 6
		servicios.eliminarUsuario(id); 
		return "redirect:/dashboard";
	}
	
	//Editar: mostramos el formulario CON la info del Usuario
	@GetMapping("/editar/{id}") //localhost:8080/editar/6
	public String editar(@PathVariable Long id, 
						@ModelAttribute("usuario") Usuario usuario,
						Model model) {
		
		//Obtenemos la información del objeto/registro usuario
		Usuario esteUsuario = servicios.obtenerUsuarioPorId(id);
		model.addAttribute("usuario", esteUsuario); //Sobreescribo al usuario vacío
		
		List<Curso> listaCursos = servicios.obtenerTodosLosCursos();
		model.addAttribute("cursos", listaCursos);
		
		return "editar.jsp";
	}
	
	
	//Actualizar: recibimos la info y la guardamos (validemos la info)
	//localhost:8080/actualizar/6
	@PutMapping("/actualizar/{id}") //IMPORTANTE: debe llamarse id para que se asigne al ModelAttribute
	public String actualizar(@Valid @ModelAttribute("usuario") Usuario usuarioEditado,
							BindingResult result,
							Model model) {
		
		if(result.hasErrors()) {
			List<Curso> listaCursos = servicios.obtenerTodosLosCursos();
			model.addAttribute("cursos", listaCursos);
			return "editar.jsp"; //para que se muestren los errores y que no cargue de 0 la página
		} else {
			servicios.guardarUsuario(usuarioEditado);
			return "redirect:/dashboard"; //redireccionar a una ruta
		}
		
	}
	
	//Creando una ruta para asignar hobbies a un usuario específico
	@GetMapping("/asignar/{id}") //localhost:8080/asignar/1
	public String asignar(@PathVariable Long id, Model model) {
		
		//Buscar al usuario al que le voy a asignar los hobbies
		Usuario esteUsuario = servicios.obtenerUsuarioPorId(id);
		model.addAttribute("usuario", esteUsuario);
		
		//Lista de Hobbies
		List<Hobby> hobbies = servicios.obtenerTodosLosHobbies();
		model.addAttribute("hobbies", hobbies);
		
		return "asignar.jsp";
		
	}
	
	@GetMapping("/asignarHobby/{usuarioId}/{hobbyId}")
	public String asignarHobby(@PathVariable Long usuarioId, @PathVariable Long hobbyId) {
		//usuarioId = 1
		//hobbyId = 8
		//Invocar a un método de mi servicio que reciba usuarioId y hobbyId y los relacione
		servicios.asignarHobbyAUsuario(usuarioId, hobbyId);
		
		
		return "redirect:/asignar/"+usuarioId;
		
	}
	
	//localhost:8080/quitarHobby/1/8
	@GetMapping("/quitarHobby/{usuarioId}/{hobbyId}")
	public String quitarHobby(@PathVariable Long usuarioId,
							 @PathVariable Long hobbyId) {
		
		//Invocar a un método de mi servicio que reciba usuarioId y hobbyId y los desvincule
		servicios.quitarHobbyAUsuario(usuarioId, hobbyId);
		
		return "redirect:/asignar/"+usuarioId;
		
	}
	
	
	//localhost:8080/pagina/3
	@GetMapping("/pagina/{numPagina}")
	public String paginacion(@PathVariable int numPagina, Model model) {
		
		Page<Usuario> paginaActual = servicios.usuariosPorPagina(numPagina - 1); //Incluye la lista de usuarios que muestra esa página
		
		int totalDePaginas = paginaActual.getTotalPages(); //Visualizar el total de páginas que tenemos
		
		model.addAttribute("paginaActual", paginaActual);
		model.addAttribute("totalDePaginas", totalDePaginas);
		
		return "dashboard2.jsp";
		
	}
	
	
	
}
