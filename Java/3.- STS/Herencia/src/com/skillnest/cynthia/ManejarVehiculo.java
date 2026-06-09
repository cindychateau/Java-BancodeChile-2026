package com.skillnest.cynthia;

/*Interface es un conjunto de métodos que puedo implementar en una clase.
  NO se puede inicializar, porque NO ES un objeto. No tiene método constructor
 */
public interface ManejarVehiculo {
	
	/*Método default: Está listo para ser utilizado, pasa el método tal y como está la clase que lo implementa*/
	public default void manejar() {
		System.out.println("Se está manejando el vehículo");
	}
	
	/*Métodos Abstracto: La interfaz NO lo define, PEROOOO obligamos a nuestra clase a que se implemente*/
	abstract void acelerar();
	abstract void desacelerar();
	
}
