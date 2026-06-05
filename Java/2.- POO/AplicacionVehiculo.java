public class AplicacionVehiculo {

    public static void main(String[] args) {
        //Objeto / Instancia: Clase inicializada. Ya tengo información, o ya creo una variable con mi clase
        Vehiculo vehiculo1 = new Vehiculo();
        vehiculo1.color = "rojo";
        vehiculo1.ruedas = 4;
        vehiculo1.puertas = 2;
        vehiculo1.marca = "Audi";
        vehiculo1.modelo = "A3";

        System.out.println("Color:"+vehiculo1.color);

        vehiculo1.infoVehiculo();


    }


}