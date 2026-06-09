package com.skillnest.cynthia;

public class Aplicacion {

	public static void main(String[] args) {
		
		Vehiculo vehiculo1 = new Vehiculo("rojo", 4, 2, "Audi", "A3");
		System.out.println("El color del vehículo es: "+vehiculo1.getColor());
		
		
		Auto autoDeElena = new Auto("negro", 4, 4, "Nissan", "Kicks", "ABCD12");
		
		System.out.println("La marca del auto es:"+autoDeElena.getMarca());
		
	}

}
