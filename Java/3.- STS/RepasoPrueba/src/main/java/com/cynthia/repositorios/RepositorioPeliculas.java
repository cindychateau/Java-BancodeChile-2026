package com.cynthia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cynthia.modelos.Pelicula;

@Repository
public interface RepositorioPeliculas extends JpaRepository<Pelicula, Long> {
	
	List<Pelicula> findAll(); //SELECT * FROM peliculas;
	
	//SELECT * FROM peliculas ORDER BY titulo ASC;
	List<Pelicula> findAllByOrderByTituloAsc();
	
	List<Pelicula> findAllByOrderByAnioDesc();
	
	//SELECT * FROM peliculas WHERE titulo LIKE "%palabra%"
	List<Pelicula> findByTituloContaining(String palabra);
	
}
