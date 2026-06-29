package com.skillnest.patitas.servicios;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.skillnest.patitas.modelos.LoginUsuario;
import com.skillnest.patitas.modelos.Usuario;
import com.skillnest.patitas.repositorios.RepositorioUsuarios;

@Service
public class ServicioUsuarios {

	@Autowired
	private RepositorioUsuarios repositorioUsuarios;
	
	public Usuario registrar(Usuario usuario, BindingResult result) {
		if (!usuario.getPassword().equals(usuario.getConfirmarPassword())) {
			result.rejectValue("confirmarPassword", "Matches", "Las contraseñas no coinciden");
		}
		
		Optional<Usuario> usuarioExistente = repositorioUsuarios.findByEmail(usuario.getEmail());
		if (usuarioExistente.isPresent()) {
			result.rejectValue("email", "Unique", "Este correo ya está registrado");
		}
		if (result.hasErrors()) {
			return null;
		}
		
		String hash = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
		usuario.setPassword(hash);
		
		return repositorioUsuarios.save(usuario);
		
	}
	public Usuario obtenerPorId(Long id) {
		return repositorioUsuarios.findById(id).orElse(null);
	}
	
	public Usuario login(LoginUsuario loginUsuario, BindingResult result) {
		Optional<Usuario> usuarioOptional = repositorioUsuarios.findByEmail(loginUsuario.getEmail());
		
		if (usuarioOptional.isEmpty()) {
			result.rejectValue("email", "Matches", "Credenciales incorrectas");
			return null;
		}
		
		Usuario usuario = usuarioOptional.get();
		
		if (!BCrypt.checkpw(loginUsuario.getPassword(), usuario.getPassword())) {
			result.rejectValue("email","Matches", "Credenciales incorrectas");
			return null;
		}
		
		return usuario;
	}
	
	public Usuario actualizarPerfil(Usuario usuario, BindingResult result) {
		if (!usuario.getPassword().equals(usuario.getConfirmarPassword())) {
			result.rejectValue("confimarPassword", "Matches", "Las contraseñas no coinciden");
		}
		
		Optional<Usuario> usuarioExistente = repositorioUsuarios.findByEmail(usuario.getEmail());
		if (usuarioExistente.isPresent() && !usuarioExistente.get().getId().equals(usuario.getId())) {
			result.rejectValue("email", "Unique", "Este correo ya está registrado");
		}
		
		if (result.hasErrors()) {
			return null;
		}
		
		String hash = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
		usuario.setPassword(hash);
		
		return repositorioUsuarios.save(usuario);
	}
}
