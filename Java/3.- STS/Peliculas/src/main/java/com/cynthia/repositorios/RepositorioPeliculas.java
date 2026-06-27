package com.cynthia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cynthia.modelos.Pelicula;

@Repository
public interface RepositorioPeliculas extends JpaRepository<Pelicula, Long> {
	
	//save(), deleteById(), findById(), findAll()
	
	//SELECT * FROM peliculas;
	List<Pelicula> findAll();
	
	//SELECT * FROM peliculas ORDER by titulo ASC;
	List<Pelicula> findAllByOrderByTituloAsc(); //A-Z
	
	//SELECT * FROM peliculas ORDER BY anio DESC;
	List<Pelicula> findAllByOrderByAnioDesc(); //Más reciente a más vieja
	
	//Consulta para buscar la peli con una palabra en específico
	
}
