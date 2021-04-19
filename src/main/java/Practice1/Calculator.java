package Practice1;

import java.util.Scanner;

public class Calculator {

    static void division (double a, double b){
        System.out.println("--------------------------------------");
        System.out.println("El resultado de la DIVISIÓN es " + (a/b));
    }

    static void multiplication (double a, double b){
        System.out.println("--------------------------------------");
        System.out.println("El resultado de la MULTIPLICACIÓN es " + (a*b));
    }

    static void substraction (double a, double b){
        System.out.println("--------------------------------------");
        System.out.println("El resultado de la RESTA es " + (a-b));
    }

    static void addition (double a, double b){
        System.out.println("--------------------------------------");
        System.out.println("El resultado de la SUMA es " + (a+b));
    }

    static double getFirstValue (){
        Scanner firstInput = new Scanner(System.in);
        System.out.print("Introduce el primer número: ");
        double a = firstInput.nextDouble();
        return a;
    }

    static double getSecondValue(){
        Scanner secondInput = new Scanner(System.in);
        System.out.print("Introduce el segundo número: ");
        double b = secondInput.nextDouble();
        return b;
    }

    public static boolean repeat = true;

    public static void main(String[] args) {
        System.out.println("BIENVENIDO A LA APLICACIÓN CALCULADORA");

        while (repeat) {
            System.out.println("--------------------------------------");
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("Introduce una de las siguientes opciones para realizar una operación ");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("--------------------------------------");
            System.out.println("0. Finalizar la aplicación");
            System.out.println("--------------------------------------");

            Scanner operationSelected = new Scanner(System.in);
            System.out.print("Operación seleccionada ");
            int operation = operationSelected.nextInt();

            switch (operation) {
                case 1:
                    addition(getFirstValue(), getSecondValue());
                    break;
                case 2:
                    substraction(getFirstValue(), getSecondValue());
                    break;
                case 3:
                    multiplication(getFirstValue(), getSecondValue());
                    break;
                case 4:
                    division(getFirstValue(), getSecondValue());
                    break;
                case 0:
                    System.out.println("La aplicación ha finalizado.");
                    repeat=false;
                    break;
                default:
                    System.out.println("El valor introducido es incorrecto, prueba de nuevo.");
            }
        }

    }
}
