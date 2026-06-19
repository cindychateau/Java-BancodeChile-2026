package com.skillnest.cynthia.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillnest.cynthia.modelos.Usuario;
import com.skillnest.cynthia.repositorios.RepositorioUsuarios;

@Service
public class Servicios {
	
	@Autowired
	private RepositorioUsuarios repoUsuarios;
	
	public List<Usuario> obtenerTodosLosUsuarios() {
		return repoUsuarios.findAll();
	}
	
	//Controlador: obtenerUsuarioPorId(5)
	public Usuario obtenerUsuarioPorId(Long id) {
		return repoUsuarios.findById(id).orElse(null);
	}
	
	//Guarde usuario
	public Usuario guardarUsuario(Usuario usuario) {
		return repoUsuarios.save(usuario);
	}
	
	//Elimine el usuario (Lunes)

}
