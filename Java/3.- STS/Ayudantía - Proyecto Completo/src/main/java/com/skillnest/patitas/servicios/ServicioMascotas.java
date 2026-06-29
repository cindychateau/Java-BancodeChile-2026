package com.skillnest.patitas.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.skillnest.patitas.modelos.Mascota;
import com.skillnest.patitas.repositorios.RepositorioMascotas;

@Service
public class ServicioMascotas {

	@Autowired
	private RepositorioMascotas repositorioMascotas;
	
	public List<Mascota> obtenerTodas() {
		return repositorioMascotas.findAll();
	}
	
	public Mascota obtenerPorId(Long id) {
		return repositorioMascotas.findById(id).orElse(null);
	}
	
	public Mascota crear(Mascota mascota, BindingResult result) {
		Optional<Mascota> existe = repositorioMascotas.findByNombre(mascota.getNombre());
		if (existe.isPresent()) {
			result.rejectValue("nombre", "Unique", "Ya existe una mascota con ese nombre");
		}
		if (result.hasErrors()) {
			return null;
		}
		return repositorioMascotas.save(mascota);
	}
	
	public void eliminar(Long id) {
		repositorioMascotas.deleteById(id);
	}
	
	public Mascota actualizar(Mascota mascota, BindingResult result) {
		Optional<Mascota> existe = repositorioMascotas.findByNombre(mascota.getNombre());
		if (existe.isPresent() && !existe.get().getId().equals(mascota.getId())) {
			result.rejectValue("nombre", "Unique", "Ya existe una mascota con ese nombre");
		}
		if (result.hasErrors()) {
			return null;
		}
		
		return repositorioMascotas.save(mascota);
	}
}
