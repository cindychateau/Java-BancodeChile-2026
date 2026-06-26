package com.cynthia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cynthia.modelos.Usuario;

@Repository
public interface RepositorioUsuarios extends JpaRepository<Usuario, Long> {
	
	Usuario findByEmail(String email); //SELECT * FROM usuarios WHERE email = <email>
	
}
