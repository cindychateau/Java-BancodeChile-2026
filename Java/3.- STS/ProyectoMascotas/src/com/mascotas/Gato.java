package com.mascotas;

//Crear una clase hija que herede de Mascota. 1 atributo adicional
public class Gato extends Mascota{
	
	private String pelaje;

	public Gato(String nombre, String raza, String color, int edad, double peso, String pelaje) {
		super(nombre, raza, color, edad, peso);
		this.pelaje = pelaje;
	}

	public String getPelaje() {
		return pelaje;
	}

	public void setPelaje(String pelaje) {
		this.pelaje = pelaje;
	}
	
	

}
