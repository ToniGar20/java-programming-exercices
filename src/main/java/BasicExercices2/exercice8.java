/**
 8) Lee un número por teclado y comprueba que este número es mayor o igual que cero, si no
 lo es lo volverá a pedir (do while), después haz que nos muestre el número por consola..
 */

package BasicExercices2;

import java.util.Scanner;

public class exercice8 {

    public static void main(String[] args) {

        int number = 0;
        do {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        number = scanner.nextInt();
        }
        while (number <= 0);

        System.out.println("Has introducido el número " + number + ". Te has pasado el juego");

    }
}
