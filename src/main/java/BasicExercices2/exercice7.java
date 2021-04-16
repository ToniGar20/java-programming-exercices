/**
 * 7) Realiza una aplicación que nos pida un número de productos vendidos, después nos pedirá el precio de cada producto
 * (tendrá que pedirnos tantos precios como productos le hayamos indicado al principio)Al final mostrará la suma del
 * total de productos por el precio de cada producto. Piensa que es lo que se repite y lo que no.
 */

package BasicExercices2;

import java.util.Scanner;

public class exercice7 {

    public static void main(String[] args) {

        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Introduce el número de productos vendidos: ");
        int sales = scanner1.nextInt();

        double prices = 0;

        for (int i = 1; i <= sales; i++) {
            Scanner scanner2 = new Scanner(System.in);
            System.out.print("Introduce el valor del producto " + (i) + " ");
            double newPrice = scanner2.nextDouble();
            prices += newPrice;

        }

        System.out.println("El valor total de los productos es " + prices);
    }
}
