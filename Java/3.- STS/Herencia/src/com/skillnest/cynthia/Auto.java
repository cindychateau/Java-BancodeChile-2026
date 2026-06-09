package com.skillnest.cynthia;

public class Auto extends Vehiculo implements ManejarVehiculo {
	
	private String patente;

	public Auto(String color, int ruedas, int puertas, String marca, String modelo, String patente) {
		//Usamos el método constructor de la clase superior
		super(color, ruedas, puertas, marca, modelo);
		/*
		 this.color = color;
		 this.ruedas = ruedas;
		 this.puertas = puertas;
		 this.marca = marca;
		 this.modelo = modelo;
		 */
		this.patente = patente;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}
	
	public void acelerar() {
		System.out.println("Estamos pisando el acelerador.");
		velocidad += 2;
		System.out.println("Mi velocidad es de: "+velocidad);
	}
	
	public void desacelerar() {
		System.out.println("Estoy pisando el freno");
		velocidad -= 2;
		System.out.println("Mi velocidad es de: "+velocidad);
	}
	
	
}
