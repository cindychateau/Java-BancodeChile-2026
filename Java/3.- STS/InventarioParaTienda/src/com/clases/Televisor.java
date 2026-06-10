package com.clases;

public class Televisor extends ProductoElectrodomestico {
	
	private int tamanoPantalla;
	private String resolucion;
	
	//Método constructor
	public Televisor(String nombre, double precio, int cantidadDisponible, int tamanoPantalla, String resolucion) {
		super(nombre, precio, cantidadDisponible);
		this.tamanoPantalla = tamanoPantalla;
		this.resolucion = resolucion;
	}

	public int getTamanoPantalla() {
		return tamanoPantalla;
	}

	public void setTamanoPantalla(int tamanoPantalla) {
		this.tamanoPantalla = tamanoPantalla;
	}

	public String getResolucion() {
		return resolucion;
	}

	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}
	
	@Override //Sobreescribe
	public void mostrarInformacion() {
		super.mostrarInformacion(); //de la clase padre ejecuta mostrarInformacion()
		System.out.println("Tamaño de pantalla: "+tamanoPantalla);
		System.out.println("Resolución: "+resolucion);
	}
	
	
}
