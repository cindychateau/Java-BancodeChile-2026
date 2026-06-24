package com.skillnest.cynthia.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillnest.cynthia.modelos.Hobby;

@Repository //Consultas
public interface RepositorioHobbies extends CrudRepository<Hobby, Long> {
	
	List<Hobby> findAll();
	
	/*
	 C(Create): save(curso)
	 R(Read): findAll(), findById(id)
	 U(Update): save(curso)
	 D(Delete: deleteById
	 */
	
}
