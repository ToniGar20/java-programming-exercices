/**
 * 2) Declara 2 variables numéricas (con el valor que desees), e indica cual es mayor de los dos.
 * Si son iguales indicarlo también. Ves cambiando los valores para comprobar que funciona.
 */

package BasicExercices1;

public class Exercice2 {

    public static void main(String[] args) {
        int a = 7;
        int b = 7;

        if(a>b){
            System.out.println("La primera variable es mayor que la segunda");
        } else if (b>a){
            System.out.println("La segunda variable es mayor que la primera");
        } else {
            System.out.println("Las variables son iguales");
        }

    }

}

