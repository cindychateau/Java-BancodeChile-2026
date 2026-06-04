public class AplicacionCalculadora {


    public static void main(String [] args) {
        //Esto es lo único que voy a ejecutar

        //De aquí llamo a las operaciones que necesite

        //sumar dos números enteros
        int resultadoSuma = Calculadora.suma(5, 7);
        System.out.println("La suma es:"+resultadoSuma);

        //multiplicar dos números enteros
        int resultadoMult = Calculadora.multiplicar(2, 3);
        System.out.println("La multiplicación 2x3 = "+ resultadoMult);

        //sumar 3 números enteros
        int resultadoSuma3 = Calculadora.suma(3, 2, 1);
        System.out.println("Resultado de 3+2+1:"+resultadoSuma3);

        //suma 2 números decimales
        double resultadoSumaDoubles = Calculadora.suma(1.1, 2.2);
        System.out.println("Resultado de 1.1+2.2:"+resultadoSumaDoubles);
    }

    //Aquí pueden ir los métodos
}