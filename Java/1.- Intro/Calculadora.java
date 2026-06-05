public class Calculadora {

    //Aquí solo tendré los métodos que se van a poder invocar

    //num1 = 5
    //num2 = 7
    public static int suma(int num1, int num2) {
        return num1 + num2; //regreso 12
    }

    //num1 = 2
    //num2 = 3
    public static int multiplicar(int num1, int num2) {
        return num1 * num2; //2 * 3, regresando 6
    }

    //Sobrecarga: tener 2 o más métodos con el MISMO NOMBRE pero con valores de retorno o parámetros distintos
    public static int suma(int num1, int num2, int num3) {
        return num1 + num2 + num3;
    }

    public static double suma(double num1, double num2) {
        return num1 + num2;
    }

    public static void sumaImpresion(int num1, int num2) {
        System.out.println("SUMA:"+(num1+num2));
    }

}