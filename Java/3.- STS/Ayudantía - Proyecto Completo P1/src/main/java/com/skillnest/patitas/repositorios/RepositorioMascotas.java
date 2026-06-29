package com.skillnest.patitas.repositorios;


import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.skillnest.patitas.modelos.Mascota;

@Repository
public interface RepositorioMascotas extends CrudRepository<Mascota, Long>{
	
	List<Mascota> findAll();
	
	Optional<Mascota> findByNombre(String nombre);
}
