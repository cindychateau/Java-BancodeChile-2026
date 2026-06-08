public class Vehiculo {

    public String color;
    public int ruedas;
    public int puertas;
    public String marca;
    public String modelo; //String -> texto. modelo = ""

    //Método de la instancia
    //this = vehiculo1
    //this es el objeto que está invocando al método
    public void infoVehiculo() {
        //"Modelo:"+"A3"+"Marca:"+"Audi"+"Ruedas:"+4
        System.out.println("Modelo:"+this.modelo+" Marca:"+this.marca+" Ruedas:"+this.ruedas);
    }

    /* public Vehiculo() {} */

}