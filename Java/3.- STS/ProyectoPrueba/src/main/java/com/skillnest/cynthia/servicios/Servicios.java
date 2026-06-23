package com.skillnest.cynthia.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillnest.cynthia.modelos.Usuario;
import com.skillnest.cynthia.repositorios.RepositorioUsuarios;

@Service
public class Servicios {
	 	@Autowired
	   private RepositorioUsuarios repositorioUsuario;

	   public List<Usuario> obtenerTodosLosUsuarios() {
	       return this.repositorioUsuario.findAll();
	   }

	   public Usuario obtenerUsuarioPorId(Long id) {
	       return this.repositorioUsuario.findById(id).orElse(null);
	   }

	   public Usuario guardarUsuario(Usuario usuario) {
	       return this.repositorioUsuario.save(usuario);
	   }

	   public void eliminarUsuario(Long id) {
	   	this.repositorioUsuario.deleteById(id);
	   }
}
