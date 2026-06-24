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
	private RepositorioUsuarios repoUsuarios;
	
	@Autowired
	private RepositorioCursos repoCursos;
	
	public List<Usuario> obtenerTodosLosUsuarios() {
		return repoUsuarios.findAll();
	}
	
	//Controlador: obtenerUsuarioPorId(5)
	public Usuario obtenerUsuarioPorId(Long id) {
		return repoUsuarios.findById(id).orElse(null); //objeto Usuario
	}
	
	//Guarde usuario: nuevos registros, ediciones de registros
	public Usuario guardarUsuario(Usuario usuario) {
		return repoUsuarios.save(usuario);
	}
	
	//Elimine el usuario
	//Controlador: eliminarUsuario(6)
	public void eliminarUsuario(Long id) { //id = 6
		repoUsuarios.deleteById(id); //llamo al repo para decirle que elimine al usuario 6
	}
	
	//Regrese todos los cursos
	public List<Curso> obtenerTodosLosCursos(){
		return repoCursos.findAll();
	}

}
