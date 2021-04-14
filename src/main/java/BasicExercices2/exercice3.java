/**
 * 3) Lee un número por teclado que pida el precio de un producto (puede tener decimales)
 * y calcule el precio final con IVA. El IVA será una constante que será del 21%.
 */

package BasicExercices2;

import java.util.Scanner;

public class exercice3 {

    public static void main(String[] args) {
        final double tax = 1.21;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el precio de un producto para calcularlo con IVA: ");
        double price = scanner.nextInt();
        double finalPrice = price*tax;
        System.out.println("El precio del producto con IVA es " + finalPrice);

    }
}
