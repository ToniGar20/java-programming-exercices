package Practice3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main{

    //Variable con valor verdadero para mantener la iteración inferior
    public static boolean repeat = true;

    /**
     * Método Main principal
     *
     * A partir de una serie de datos cargados, se inicia un bucle while que repetirá mientras el valor de la variable de la línea 11 no cambie a falso.
     * Esto se dará cuando se seleccione la opción "salir" (2). El switch con la opción 1 corre los métodos de las clases "ATM" y "Card".
     *
     * Se genera también un método llamado "makeQuestion" para no tener que abrir la clase "Scanner"
     * La variable "inputline" sirve para generar una transición entre operación y operación
     *
     * @param args
     */
    public static void main(String[] args) {

        Integer [][] moneyNotesCharge = {{500, 1}, {200, 3}, {100, 0}, {50, 0}, {20, 0}, {10, 18}, {5, 25}};
        ATM myATM = new ATM();

        myATM.setMoneyNotes(moneyNotesCharge);
        DebitCard myCard1 = new DebitCard("12345678A", 1111, "Fran", "Perea",true, 20000);
        CreditCard myCard2 = new CreditCard("87654321B", 2222, "Javi", "Cantero", true ,1000, 5000);
        ATM.getRegisteredCards().add(myCard1);
        ATM.getRegisteredCards().add(myCard2);

        while (repeat) {
            System.out.println("=====================================================================");
            System.out.println("CAJERO AUTOMÁTICO");
            System.out.println("=====================================================================");
            System.out.println("Introduce una de las siguientes opciones:");
            System.out.println("1. Sacar dinero");
            System.out.println("2. Salir");
            System.out.println("=====================================================================");

            int option = Integer.parseInt(makeQuestion("Introducir número de la opción seleccionada"));

            switch (option) {
                case 1:
                    ATM.showMoneyNotes();
                    Card.showCards();
                    ATM.takeMoneyOut();
                    ATM.showMoneyNotes();
                    break;
                case 2:
                    System.out.println("La aplicación ha finalizado.");
                    repeat = false;
                    break;
                default:
                    System.out.println("El valor introducido no es válido.");
                    break;
            }

            System.out.println("Pulsa cualquier tecla para continuar.");
            Scanner scanner1 = new Scanner(System.in);
            String inputline = scanner1.nextLine();
        }
    }

    public static String makeQuestion(String text) {
        String value = " ";
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader bf = new BufferedReader(isr);
            System.out.print(text + ": ");
            value = bf.readLine();
        } catch (IOException ex) {
            System.out.println("ERROR WITH SYSTEM.IN!");
        }
        return value;
    }
}