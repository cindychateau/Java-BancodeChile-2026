package com.skillnest.cynthia.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillnest.cynthia.modelos.Curso;
import com.skillnest.cynthia.modelos.Hobby;
import com.skillnest.cynthia.modelos.Usuario;
import com.skillnest.cynthia.repositorios.RepositorioCursos;
import com.skillnest.cynthia.repositorios.RepositorioHobbies;
import com.skillnest.cynthia.repositorios.RepositorioUsuarios;

@Service
public class Servicios {
	
	@Autowired
	private RepositorioUsuarios repoUsuarios;
	
	@Autowired
	private RepositorioCursos repoCursos;
	
	@Autowired
	private RepositorioHobbies repoHobbies;
	
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
	
	public List<Hobby> obtenerTodosLosHobbies() {
		return repoHobbies.findAll();
	}
	
	public Hobby obtenerHobbyPorId(Long id) {
		return repoHobbies.findById(id).orElse(null);
	}
	
	//Asignar a un usuario un hobby
	public void asignarHobbyAUsuario(Long usuarioId, Long hobbyId) {
		//usuarioId = 1
		//hobbyId = 8
		//Obtener al usuario al que le vamos a agregar el hobby
		Usuario esteUsuario = obtenerUsuarioPorId(usuarioId); //Juana
		
		//Obtener el hobby que se va a agregar
		Hobby esteHobby = obtenerHobbyPorId(hobbyId); //Bailar
		
		esteUsuario.getHobbies().add(esteHobby);
		repoUsuarios.save(esteUsuario);
		
		//esteHobby.getUsuarios().add(esteUsuario);
		//repoHobbies.save(esteHobby);
		
	}
	
	//Quitar a un usuario un hobby
	public void quitarHobbyAUsuario(Long usuarioId, Long hobbyId) {
		//Obtener el usuario al que le queremos quitar el hobby
		Usuario esteUsuario = obtenerUsuarioPorId(usuarioId);
		
		//Obtener el hobby que queremos quitar
		Hobby esteHobby = obtenerHobbyPorId(hobbyId);
		
		esteUsuario.getHobbies().remove(esteHobby);
		repoUsuarios.save(esteUsuario);
		
		
	}

}
