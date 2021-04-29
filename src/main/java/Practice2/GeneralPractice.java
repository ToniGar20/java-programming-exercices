package Practice2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeneralPractice {
    public static boolean repeat = true;

    public static void main(String[] args) {
        System.out.println("BIENVENIDO A LA APLICACIÓN DE EJERCICIOS");
        while (repeat) {

            //Hasta la línea 72 se pasan por la consola los mensajes para usar la app.
            System.out.println("=====================================================================");
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("Introduce una de las siguientes opciones para usar la aplicación:");
            System.out.println("=====================================================================");
            System.out.println("1. Leer 5 números en el orden en el que se han introducido");
            System.out.println("2. Leer 5 números en el orden INVERSO en el que se han introducido");
            System.out.println("3. Media de positivos y negativos con 5 números introducidos");
            System.out.println("4. Caracteres que contiene un texto sin contar espacios en blanco");
            System.out.println("5. Texto invertido");
            System.out.println("6. Texto sin espacios en blanco");
            System.out.println("7. Dos cadenas concatenadas");
            System.out.println("8. Sustitución de vocales en una cadena");
            System.out.println("9. ASCII de los caracteres de una cadena");
            System.out.println(" ");
            System.out.println("0. Salir de la aplicación");
            System.out.println("=====================================================================");
            Scanner operationSelected = new Scanner(System.in);
            System.out.print("Introducir número de la operación seleccionada: ");
            int operation = operationSelected.nextInt();

            //La variable operation será evaluada y según su valor, llamará a los diferentes métodos de la operación.
            //Añadir que para cada método se le pasan el primer valor y el segundo que son los parámetros de entrada
            //Los parámetros de entrada llaman a los dós métodos de las líneas 35 a 47.
            switch (operation) {
                case 1:
                    firstMethod();
                    break;
                case 2:
                    secondMethod();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 0:
                    System.out.println("La aplicación ha finalizado.");
                    repeat = false;
                    break;
                default:
                    System.out.println("El valor introducido no es válido");
                    break;
            }
            //Este código dibuja una línea que solicita un "enter".
            //Lo hago para que al devolver el resultado de la operación no salte de nuevo el menú principal
            //De esta manera se genera una transición entre resultado y siguiente operación a realizar
            System.out.println("Pulsa ENTER para continuar.");
            Scanner scanner1 = new Scanner(System.in);
            String inputline = scanner1.nextLine();
        }
    }

    public static void firstMethod() {
        List<String> numbers = new ArrayList<String>();
        for (int i = 1; numbers.size() < 5; i++) {
            String newNumber=makeQuestion("Introduce el número " + i);
            numbers.add(newNumber);
        }
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println("son tus números introducidos.");
    }

    public static void secondMethod(){
        List<String> numbers = new ArrayList<String>();
        for (int i = 1; numbers.size() < 5; i++) {
            String newNumber=makeQuestion("Introduce el número " + i);
            numbers.add(newNumber);
        }
        for (int i = numbers.size()-1; i >= 0; i--) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println("son tus números introducidos en orden INVERSO.");
    }

        public static String makeQuestion(String text) {
            String valor = " ";
            try {
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader (isr);
                System.out.print(text + ": ");
                valor = br.readLine();
            } catch (IOException ex) {
                System.out.println("Error");
            }
            return valor;
        }


}
