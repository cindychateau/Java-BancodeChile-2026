package com.skillnest.cynthia.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillnest.cynthia.modelos.Curso;
import com.skillnest.cynthia.modelos.Usuario;
import com.skillnest.cynthia.repositorios.RepositorioCursos;
import com.skillnest.cynthia.repositorios.RepositorioUsuarios;

@Service
public class Servicios {
	 	@Autowired
	   private RepositorioUsuarios repositorioUsuario;
	 	
	 	@Autowired RepositorioCursos repositorioCursos;

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
	   
	 //Método que me regrese todos los salones
		public List<Curso> obtenerCursos() {
			return repositorioCursos.findAll();
		}
}
