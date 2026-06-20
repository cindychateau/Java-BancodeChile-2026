package com.cynthia.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynthia.modelos.Cancion;
import com.cynthia.repositorios.RepositorioCanciones;

@Service
public class ServicioCanciones {
	
	@Autowired
	private RepositorioCanciones repoCanciones;
	
	public List<Cancion> obtenerTodasLasCanciones() {
		return repoCanciones.findAll();
	}
	
	public Cancion obtenerCancionPorId(Long id) {
		return repoCanciones.findById(id).orElse(null);
	}
	
}
