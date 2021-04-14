package BasicExercices2;

import java.util.Scanner;

public class exercice1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int number = scanner.nextInt();
        char asciiValue = (char) number;
        System.out.println("Tu valor en ASCII es " + asciiValue);

    }
}
