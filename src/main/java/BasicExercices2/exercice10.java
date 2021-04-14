/**
 * 10) Crea una aplicación que nos pida un día de la semana y que nos diga si es un día laboral o no.
 * Usa un switch para ello.
 */

package BasicExercices2;

import java.util.Scanner;

public class exercice10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un día de la semana (todo en minúsculas y con acentos)");
        String weekDay = scanner.nextLine();

        switch (weekDay) {
            case "sábado":
            case "domingo":
                System.out.println("¡El día es festivo!");
                break;

            case "lunes":
            case "martes":
            case "miércoles":
            case "jueves":
            case "viernes":
                System.out.println("Oh... hoy es día laborable...");
                break;
            default:
                System.out.println("Error. El valor introducido es incorrecto");
        }
    }

}
