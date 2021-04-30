package Practice2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GeneralPractice {
    public static boolean repeat = true;

    public static void main(String[] args) {
        System.out.println("BIENVENIDO A LA APLICACIÓN DE EJERCICIOS");
        while (repeat) {

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

            int operation = Integer.parseInt(makeQuestion("Introducir número de la operación seleccionada: "));

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
                    thirdMethod();
                    break;
                case 4:
                    fourthMethod();
                    break;
                case 5:
                    fifthMethod();
                    break;
                case 6:
                    sixthMethod();
                    break;
                case 7:
                    seventhMethod();
                    break;
                case 8:
                    eighthMethod();
                    break;
                case 9:
                    ninthMethod();
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

    public static void firstMethod() {
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; numbers.size() < 5; i++) {
            int newNumber = Integer.parseInt(makeQuestion("Introduce el número " + i));
            numbers.add(newNumber);
        }
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println("son tus números introducidos.");
    }

    public static void secondMethod() {
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; numbers.size() < 5; i++) {
            int newNumber = Integer.parseInt(makeQuestion("Introduce el número " + i));
            numbers.add(newNumber);
        }
        for (int i = numbers.size() - 1; i >= 0; i--) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println("son tus números introducidos en orden INVERSO.");
    }

    public static void thirdMethod(){
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; numbers.size() < 5; i++) {
            int newNumber = Integer.parseInt(makeQuestion("Introduce el número " + i));
            numbers.add(newNumber);
        }

        int positive = 0;
        int negative = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) >= 0){
                positive += numbers.get(i);
            } else {
                negative += numbers.get(i);
            }
        }
        System.out.println("La suma de los números POSITIVOS que has introducido es " + positive);
        System.out.println("La suma de los números NEGATIVOS que has introducido es " + negative);
    }

    public static void fourthMethod() {
        String newText = makeQuestion("Introduce texto o escribe algo");
        String noSpaceText = newText.replace(" ", "");
        System.out.println("Tu cadena tiene " + noSpaceText.length() + " caracteres.");
    }

    public static void fifthMethod() {
        String newText = makeQuestion("Introduce texto o escribe algo");
        String reverse = new StringBuffer(newText).reverse().toString();
        System.out.println("La cadena de texto al revés: " + reverse);
    }

    public static void sixthMethod(){
        String newText = makeQuestion("Introduce texto o escribe algo");
        String noSpaceText = newText.replace(" ", "");
        System.out.println("La cadena de texto sin espacios: " + noSpaceText);
    }

    public static void seventhMethod(){
        String newText1 = makeQuestion("Introduce un primer texto o escribe algo");
        String newText2 = makeQuestion("Introduce un segundo texto o escribe algo");
        System.out.println("El resultado de unir ambas cadenas es:");
        System.out.println(newText1 + " " + newText2);
    }

    public static void eighthMethod(){
        String myVocal = makeQuestion("Introduce una vocal");
        String text = makeQuestion("Introduce un texto o escribe algo");

        String newText = text.replaceAll("[aeiouAEIOU]",myVocal);
        System.out.println("Al sustituir todas las vocales por la que has puesto...");
        System.out.println(newText);
    }

    public static void ninthMethod(){
        String text = makeQuestion("Introduce un texto o escribe algo");
        byte[] textBytes = text.getBytes(StandardCharsets.UTF_8);
        System.out.println("El valor ASCII de tu texto es:");
        System.out.println(Arrays.toString(textBytes));
    }

}
