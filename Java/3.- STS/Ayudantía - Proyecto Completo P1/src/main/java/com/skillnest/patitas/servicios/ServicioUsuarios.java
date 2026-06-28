package com.skillnest.patitas.servicios;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

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
}
