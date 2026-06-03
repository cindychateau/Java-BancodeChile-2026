public class Funciones {

    public static void main(String[] args) {
        //Esto es lo único que se ejecuta

        String texto = saludo(); //texto = "Hola mundo";
        System.out.println(texto);

        int resultado = sumaDosNumeros(1, 2); //resultado = 3
        System.out.println(resultado);
    }
    
    //Alcance: public o private
    //static: propio de clase, no necesita objeto para invocarse
    //Tipo de valor de retorno: String, int, double, void
    //nombre de la función
    //(parametros)
    public static String saludo() {
        //Instrucciones que necesita mi función/método
        return "Hola mundo";
    } 

    public static int sumaDosNumeros(int num1, int num2) { //num1 = 1, num2 = 2
        int sumatoria = num1 + num2; //sumatoria = 1 + 2 = 3;
        return sumatoria; //regresa 3
    }

    /* Crea una función llamada esPar que reciba un número y regrese true si el número es par y false si el número es impar */


    /* Crea una función llamada obtenerPromedio que reciba 3 números enteros y regrese el promedio de los 3 */

    /* Crea una función llamada obtenerMayor que reciba 3 números y regrese el número mayor de los 3 */

}