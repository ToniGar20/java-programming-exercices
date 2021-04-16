/**
 * 11) Pide por teclado dos números y genera 10 números aleatorios entre esos números.
 * Usa el método Math.random para generar un número aleatorio.
 */

package BasicExercices2;

import java.util.Scanner;

public class exercice11 {

    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Introduce el primer número: ");
        int number1 = scanner1.nextInt();

        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Introduce el segundo número: ");
        int number2 = scanner2.nextInt();
        int max = 0;
        int min = 0;

        if (number1>number2){
            max = number1;
            min = number2;
        } else {
            max = number2;
            min = number1;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(Math.round(Math.random()*(max-min) + min));
        }

    }
}
