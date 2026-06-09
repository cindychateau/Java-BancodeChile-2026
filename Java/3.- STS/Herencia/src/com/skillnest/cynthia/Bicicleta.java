package com.skillnest.cynthia;

public class Bicicleta extends Vehiculo implements ManejarVehiculo{
	
	public void acelerar() {
		System.out.println("Estoy pedaleando más rápido");
		velocidad++;
		System.out.println("Mi velocidad es de: "+velocidad);
	}
	
	public void desacelerar()  {
		System.out.println("Bajo despacito mis pies para bajar velocidad");
		velocidad--;
		System.out.println("Mi velocidad es de: "+velocidad);
	}
	
}
