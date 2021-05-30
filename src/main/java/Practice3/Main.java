package Practice3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main{

    public static boolean repeat = true;

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