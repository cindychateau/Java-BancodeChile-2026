package com.skillnest.cynthia.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillnest.cynthia.modelos.Usuario;

//Genera todas las consultas de mi aplicación web
//CRUD: Create Read Update Delete
@Repository
public interface RepositorioUsuarios extends CrudRepository<Usuario, Long> {
	//JPA: Permite de manera dinámica crear consultas/queries, lenguaje más sencillo
	
	//SELECT * FROM usuarios;
	List<Usuario> findAll();
	
	//INSERT o UPDATE
	Usuario save(Usuario usuario);
	
	//CrudRepository: findAll(), save(), deleteById(), findById()
	
	//SELECT * FROM usuarios WHERE email = "cynthia@skillnest.com"
	Usuario findByEmail(String emailABuscar);
	
	//SELECT * FROM usuarios WHERE apellido = "Martínez"
	List<Usuario> findByApellido(String apellidoABuscar);

}
