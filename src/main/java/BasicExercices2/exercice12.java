package BasicExercices2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class exercice12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un número ");
        int number = scanner.nextInt();

        List<Integer> digits = new ArrayList<Integer>();
        while (number > 0) {
            digits.add(number % 10);
            number = number / 10;
        }

        System.out.println("Tu número tiene " + digits.size() + " dígitos");
        System.out.println("Los dígitos son estos");
        for (int i = digits.size()-1; i >= 0; i--) {
            System.out.println(digits.get(i));
        }
    }
}
