package com.skillnest.cynthia.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillnest.cynthia.modelos.Curso;

@Repository
public interface RepositorioCursos extends CrudRepository<Curso, Long> {
	
	List<Curso> findAll();
	
}
