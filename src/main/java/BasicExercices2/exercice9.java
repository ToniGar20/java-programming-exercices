/**
 * 9) Crea una aplicación con un String que contenga una contraseña cualquiera. Después se te pedirá por consola
 * que introduzcas la contraseña (utiliza el método “equals” para comparar), con 3 intentos.
 * Cuando aciertes ya no pedirá más la contraseña y mostrará un mensaje diciendo “Enhorabuena”.
 * Piensa bien en la condición de salida (3 intentos y si acierta sale, aunque le queden intentos).
 */

package BasicExercices2;

import java.util.Scanner;

public class exercice9 {

    public static void main(String[] args) {

        String password = "holaquetal";
        int intents = 3;
        String userInput = "";

        while(userInput != password && intents > 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce tu contraseña: ");
            userInput = scanner.nextLine();
            if(userInput.equals(password)) {
                System.out.println("Enhorabuena. Has introducido la contraseña correcta.");
                break;
            } else {
                intents--;
                if(intents == 1){
                    System.out.println("Te queda " + intents + " intento.");
                } else {
                System.out.println("Te quedan " + intents + " intentos.");
                }
                if(intents == 0){
                    System.out.println("La aplicación ha finalizado.");
                    break;
                }
                continue;
            }
        }
    }
}
