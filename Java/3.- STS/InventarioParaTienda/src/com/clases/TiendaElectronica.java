package com.clases;

import java.util.ArrayList;
//Para importar automáticamente usamos: Ctrl + Shift + O 
//Mac: Command + Shift + O

public class TiendaElectronica {

	private ArrayList<ProductoElectrodomestico> listaDeProductos;
	
	public TiendaElectronica() {
		listaDeProductos = new ArrayList<>(); //Creo lista vacía
	}
	
	//listaDeProductos = [licuadora1, tele1, compu1, cafetera1]
	public void agregarProducto(ProductoElectrodomestico producto) {
		listaDeProductos.add(producto); //.add es el encargado de agregar un elemento a la lista
	}
	
	//listaDeProductos = [licuadora1, tele1, compu1, cafetera1]
	/*
	 	producto = licuadora1
	 	licuadora1.mostrarInformacion() -> Se imprima toda la info
	 	
	 	producto = tele1
	 	tele1.mostrarInformacion() -> imprimir
	 	
	 	producto = compu1
	 	compu1.mostrarInformacion() -> imprimir
	 	
	 	producto = cafetera1
	 	cafetera1.mostrarInformacion() -> imprimir
	 */
	public void mostrarProductos() {
		for(ProductoElectrodomestico producto : listaDeProductos) {
			producto.mostrarInformacion();
		}
	}
	
	//listaDeProductos = [licuadora1, tele1, compu1, cafetera1]
	//nombreABuscar = "licuadora mabe"
	//producto = licuadora1
	//licuadora1.getNombre() -> "licuadora mabe"
	//"licuadora mabe" == "licuadora mabe"
	public ProductoElectrodomestico buscarProducto(String nombreABuscar) {
		for(ProductoElectrodomestico producto : listaDeProductos) {
			if(producto.getNombre().equals(nombreABuscar)) {
				return producto;
			}
		}
		
		return null; //regresa vacío
	}
	
	//"licuadora mabe"
	public void realizarVenta(String nombreProducto) {
		
		//producto = licuadora1
		ProductoElectrodomestico producto = buscarProducto(nombreProducto);
		
		//Si es null, imprimir que no existe el prod
		if(producto == null) {
			System.out.println("Producto no encontrado.");
		} else {
			//Realizamos la venta
			int cantidadDispDelProducto = producto.getCantidadDisponible();
			if(cantidadDispDelProducto > 0) {
				//Reducimos en 1
				cantidadDispDelProducto--;
				producto.setCantidadDisponible(cantidadDispDelProducto);
				System.out.println("Venta realizada exitosamente: "+producto.getNombre());
			} else {
				System.out.println("Producto agotado: "+producto.getNombre());
			}
			
		}
		
	}
	
}
