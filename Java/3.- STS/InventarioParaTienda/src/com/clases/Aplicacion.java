package com.clases;

public class Aplicacion {

	public static void main(String[] args) {
		
		ProductoElectrodomestico licuadora1 = new ProductoElectrodomestico("Licuadora Mabe", 11000);
		
		System.out.println(licuadora1);
		
		//Creamos la tienda con lista de productos vacía
		TiendaElectronica tienda = new TiendaElectronica(); 

		//Creamos una tele
		//Podemos poner todo en una sola línea o en diferentes líneas para que se vea más limpio
		Televisor tv1 = new Televisor(
                "Samsung Smart TV", //Nombre
                12000, //precio
                3, //cantidad
                55, //tamaño
                "4K" //resolución
        );
		
		//Creamos otra tele
        Televisor tv2 = new Televisor(
                "LG OLED",
                18000,
                1,
                65,
                "4K"
        );
        
        //Creamos una laptop
        ComputadoraPortatil laptop1 = new ComputadoraPortatil(
                "Laptop Gamer", //nombre
                25000, //precio
                2, //cantidad
                "ASUS", //marca
                16, //ram
                "AS12345" //serie
        );

        //Creamos otra laptop
        ComputadoraPortatil laptop2 = new ComputadoraPortatil(
                "MacBook Air",
                30000,
                1,
                "Apple",
                8,
                "MB56789"
        );

        // Agregamos productos a la lista
        tienda.agregarProducto(tv1);
        tienda.agregarProducto(tv2);
        tienda.agregarProducto(laptop1);
        tienda.agregarProducto(laptop2);
        tienda.agregarProducto(licuadora1);

        System.out.println("=== INVENTARIO INICIAL ===");
        tienda.mostrarProductos(); //Mostramos los productos

        System.out.println("\n=== VENTAS ===");

        tienda.realizarVenta("Samsung Smart TV");
        tienda.realizarVenta("Samsung Smart TV");
        tienda.realizarVenta("Samsung Smart TV");
        
        tienda.realizarVenta("Licuadora Mabe");

        tienda.realizarVenta("LG OLED");
        
        tienda.realizarVenta("Producto Inexistente"); //Marca que el producto no se encontró

        System.out.println("\n=== INVENTARIO FINAL ===");
        tienda.mostrarProductos();
		

	}

}
