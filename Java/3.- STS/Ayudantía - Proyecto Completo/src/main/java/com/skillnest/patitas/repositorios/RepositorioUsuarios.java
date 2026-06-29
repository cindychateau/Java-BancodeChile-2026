package com.skillnest.patitas.repositorios;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.skillnest.patitas.modelos.Usuario;

@Repository
public interface RepositorioUsuarios extends CrudRepository<Usuario, Long>{

	List<Usuario> findAll();
	
	Optional<Usuario> findByEmail(String email);
}
