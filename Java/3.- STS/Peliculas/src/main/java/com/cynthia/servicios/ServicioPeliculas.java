package com.cynthia.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynthia.modelos.Pelicula;
import com.cynthia.repositorios.RepositorioPeliculas;
import com.cynthia.repositorios.RepositorioUsuarios;

@Service
public class ServicioPeliculas {
	
	//Inyección de dependencias
	@Autowired
	private RepositorioPeliculas repoPelis; 
	
	@Autowired
	private RepositorioUsuarios repoUsuarios;
	
	//CRUD: Create, Read (2), Update, Delete
	
	//Método que regrese la lista de las peliculas
	public List<Pelicula> obtenerTodasPelis() {
		//return repoPelis.findAll(); //Regresa todas las películas en cualquier orden
		return repoPelis.findAllByOrderByTituloAsc(); //Regresa todas las pelis en orden de titulo asc
	}
	
	//Método que guarda peli (crea un nuevo registro, y me actualiza un registro)
	public Pelicula guardarPeli(Pelicula pelicula) {
		return repoPelis.save(pelicula);
	}
	
	public void borrarPeli(Long id) {
		repoPelis.deleteById(id);
	}
	
	public Pelicula buscarPeli(Long id) {
		return repoPelis.findById(id).orElse(null);
	}
	
	/*BONUS*/
	//Comprar una película
	
	
}
