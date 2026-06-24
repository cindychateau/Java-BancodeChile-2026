package com.skillnest.cynthia.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillnest.cynthia.modelos.Curso;

@Repository
public interface RepositorioCursos extends CrudRepository<Curso, Long> {

	/*
	 C(Create): save(curso)
	 R(Read): findAll(), findById(id)
	 U(Update): save(curso)
	 D(Delete: deleteById
	 */
	
	List<Curso> findAll();
	
	
}
