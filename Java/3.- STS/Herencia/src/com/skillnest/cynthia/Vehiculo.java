package com.skillnest.cynthia;

public class Vehiculo {
	
	private String color;
	private int ruedas;
	private int puertas;
	private String marca;
	private String modelo;
	
	//private: SOLO en la clase donde se creó el atributo, se puede acceder a él
	//public: Que cualquier archivo puede acceder a él
	//protected: Solo en la clase y las clases hijas se puede acceder al atributo
	protected int velocidad = 0; //Por defecto todos mis vehículos comienzan con velocidad 0
	
	public Vehiculo() {
		//Constructor vacío
	}
	
	//Constructor con todos los atributos
	public Vehiculo(String color, int ruedas, int puertas, String marca, String modelo) {
		this.color = color;
		this.ruedas = ruedas;
		this.puertas = puertas;
		this.marca = marca;
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getRuedas() {
		return ruedas;
	}

	public void setRuedas(int ruedas) {
		this.ruedas = ruedas;
	}

	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
}
