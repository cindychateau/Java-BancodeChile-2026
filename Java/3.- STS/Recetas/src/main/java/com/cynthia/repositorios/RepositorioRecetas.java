package com.cynthia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cynthia.modelos.Receta;

@Repository
public interface RepositorioRecetas extends JpaRepository<Receta, Long> {
	
	List<Receta> findAll();
	
	List<Receta> findAllByOrderByNombreAsc();
	
	//SELECT * FROM recetas WHERE nombre LIKE "%estofado%"
	List<Receta> findByNombreContaining(String palabra);
	
}
