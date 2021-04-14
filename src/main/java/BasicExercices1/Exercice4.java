/**
 * 4) Modifica la aplicación anterior, para que nos pida el nombre que queremos introducir.
 */

package BasicExercices1;

import java.util.Scanner;

public class Exercice4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce tu nombre: ");
        String name = scanner.nextLine();

        System.out.println("Bienvenido " + name);

    }
}
