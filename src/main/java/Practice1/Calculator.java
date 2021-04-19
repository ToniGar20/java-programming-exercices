package Practice1;

import java.util.Scanner;

public class Calculator {

    //Método para ejecutar la división
    static void division (double a, double b){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("El resultado de la DIVISIÓN es " + (a/b));
        System.out.println("---------------------------------------------------------------------");
    }

    //Método para ejecutar la multiplicación
    static void multiplication (double a, double b){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("El resultado de la MULTIPLICACIÓN es " + (a*b));
        System.out.println("---------------------------------------------------------------------");
    }

    //Método para ejecutar la resta
    static void substraction (double a, double b){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("El resultado de la RESTA es " + (a-b));
        System.out.println("---------------------------------------------------------------------");
    }

    //Método para ejecutar la suma
    static void addition (double a, double b){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("El resultado de la SUMA es " + (a+b));
        System.out.println("---------------------------------------------------------------------");
    }

    //Método que capturará un primer input como primer operador con un scanner y devuelve un double
    static double getFirstValue (){
        System.out.println("---------------------------------------------------------------------");
        Scanner firstInput = new Scanner(System.in);
        System.out.print("Introduce el primer número: ");
        return firstInput.nextDouble();
    }

    //Método que capturará un primer input como segundo operador con un scanner y devuelve un double
    static double getSecondValue(){
        Scanner secondInput = new Scanner(System.in);
        System.out.print("Introduce el segundo número: ");
        return secondInput.nextDouble();
    }

    //Variable de acceso público que servirá para repetir el método MAIN hasta que no se indique lo contrario
    public static boolean repeat = true;

    //Método principal
    public static void main(String[] args) {
        System.out.println("BIENVENIDO A LA APLICACIÓN CALCULADORA");

        //Bucle while. La razón de que esté es que se ejecutará siempre que el valor de "repeat" sea verdadero (línea 50).
        // Se podrá modificar cuando el usuario en el menú principal indique salir de la aplicación, rompiendo el bucle.
        while (repeat) {

            //Hasta la línea 72 se pasan por la consola los mensajes para usar la app.
            System.out.println("=====================================================================");
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("Introduce una de las siguientes opciones para realizar una operación:");
            System.out.println("=====================================================================");
            System.out.println("1. SUMAR");
            System.out.println("2. RESTAR");
            System.out.println("3. MULTIPLICAR");
            System.out.println("4. DIVIDIR");
            System.out.println(" ");
            System.out.println("0. Salir");
            System.out.println("=====================================================================");
            //Desde el menú, el usuario podrá introducir un valor que se captura en la variable operation.
            Scanner operationSelected = new Scanner(System.in);
            System.out.print("Introducir número de la operación seleccionada: ");
            int operation = operationSelected.nextInt();

            //La variable operation será evaluada y según su valor, llamará a los diferentes métodos de la operación.
            //Añadir que para cada método se le pasan el primer valor y el segundo que son los parámetros de entrada
            //Los parámetros de entrada llaman a los dós métodos de las líneas 35 a 47.
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
                    //En este caso, 0 es para salir de la app: avisará y cambiará el valor de la línea 50.
                    // De esta manera se rompe el bucle y se cerrará el programa.
                    System.out.println("La aplicación ha finalizado.");
                    repeat=false;
                    break;
                default:
                    //Si no se introduce un valor válido la aplicación no ejecuta nada y muestra el mensaje de error:
                    System.out.println("El valor introducido es incorrecto.");
                    break;
            }
            //Este código dibuja una línea que solicita un "enter".
            //Lo hago para que al devolver el resultado de la operación no salte de nuevo el menú principal
            //De esta manera se genera una transición entre resultado y siguiente operación a realizar
            System.out.println("Pulsa ENTER para continuar.");
            Scanner scanner3 = new Scanner(System.in);
            String line = scanner3.nextLine();
        }

    }
}