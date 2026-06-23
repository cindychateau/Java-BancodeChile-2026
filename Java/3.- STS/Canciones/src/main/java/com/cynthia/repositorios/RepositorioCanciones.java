package com.cynthia.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cynthia.modelos.Cancion;

//CRUD: Create (Crear), Read (Leer), Update (Actualizar), Delete (Borrar)
@Repository
public interface RepositorioCanciones extends CrudRepository<Cancion, Long> {
	
	List<Cancion> findAll();
	
	//findAll(), save(), findById(), deleteById()
	
	//List<Cancion> findByTitulo();
	//List <Cancion> findByArtista();
	
	//List<Cancion> findByTituloOrderByArtistaAsc(); SELECT * FROM canciones WHERE titulo LIKE "rain" ORDER BY artista ASC
	
}
