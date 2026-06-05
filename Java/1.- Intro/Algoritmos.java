public class Algoritmos {

    public static boolean esPar(int num){
        // %
        if(num % 2 == 0) {
            //Es par
            return true;
        } else {
            return false;
        }
    }


    /*
    esPrimo(5)
    num = 5
    i = 2
    5 % 2 == 0 ? 1
    i = 3
    5 % 3 == 0 ? FALSE
    i = 4
    5 % 4 == 0 ? FALSE
    i = 5
     */
    public static boolean esPrimo(int num) {
        if(num <= 1) {
            return false;
        }

        for(int i=2; i < num; i++) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;

    }

}