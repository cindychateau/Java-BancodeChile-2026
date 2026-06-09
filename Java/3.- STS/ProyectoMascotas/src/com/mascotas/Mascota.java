package com.mascotas;

public class Mascota {
	
	private String nombre;
	private String raza;
	private String color;
	private int edad;
	private double peso;
	
	//2 Constructores: 1 vacío, otro con todos los atributos
	public Mascota() {
	}

	public Mascota(String nombre, String raza, String color, int edad, double peso) {
		this.nombre = nombre;
		this.raza = raza;
		this.color = color;
		this.edad = edad;
		this.peso = peso;
	}
	
	//Getters y Setters de todos los atributos
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	//Crear una aplicación y generar 3 objetos de la clase hija
}
