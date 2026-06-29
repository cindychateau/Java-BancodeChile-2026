package com.cynthia.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynthia.modelos.Receta;
import com.cynthia.modelos.Usuario;
import com.cynthia.repositorios.RepositorioRecetas;
import com.cynthia.repositorios.RepositorioUsuarios;

@Service
public class ServicioRecetas {
	
	@Autowired
	private RepositorioRecetas repoRecetas;
	
	@Autowired
	private RepositorioUsuarios repoUsuarios;
	
	public List<Receta> todasLasRecetas() {
		//return repoRecetas.findAll();
		return repoRecetas.findAllByOrderByNombreAsc();
	}
	
	public Receta buscarReceta(Long id) {
		return repoRecetas.findById(id).orElse(null);
	}
	
	public Receta guardarReceta(Receta receta) {
		return repoRecetas.save(receta);
	}
	
	public void borrarReceta(Long id) {
		repoRecetas.deleteById(id);
	}
	
	public Usuario buscarUsuario(Long id) {
		return repoUsuarios.findById(id).orElse(null);
	}
	
	public void guardarEnFavoritos(Long usuarioId, Long recetaId) {
		Usuario miUsuario = buscarUsuario(usuarioId);
		
		Receta recetaFavorita = buscarReceta(recetaId);
		
		miUsuario.getRecetasFavoritas().add(recetaFavorita);
		repoUsuarios.save(miUsuario);
	}
	
	public void quitarFavoritos(Long usuarioId, Long recetaId) {
		Usuario miUsuario = buscarUsuario(usuarioId);
		
		Receta recetaQuitar = buscarReceta(recetaId);
		
		miUsuario.getRecetasFavoritas().remove(recetaQuitar);
		repoUsuarios.save(miUsuario);
		
	}
	
	public List<Receta> buscarPorNombre(String palabra) {
		return repoRecetas.findByNombreContaining(palabra);
	}
	
}
