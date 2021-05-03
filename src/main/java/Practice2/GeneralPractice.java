package Practice2;

// Aquí aparedce la lista de elementos importados para algunas de las clases que he usado
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GeneralPractice {

    /**
     * Aquí inicio una variable llamada repeat que se establece como true.
     * Cuando su valor para a ser falso entonces el menú dejará de ejecutarse y la aplicación se cerrará.
     */
    public static boolean repeat = true;

    //Método principal que consiste en el menú
    public static void main(String[] args) {
        System.out.println("BIENVENIDO A LA APLICACIÓN DE EJERCICIOS");

        //En este punto ya uso la variable repeat que siempre que sea verdadera ejecutará el menú
        while (repeat) {

            //Texto del menú
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

            //Capturo el valor del número seleccionadodel menú. No lo hago con scanner
            int operation = Integer.parseInt(makeQuestion("Introducir número de la operación seleccionada"));

            /**
             * La variable "operation" será evaluada y según su valor, llamará a los diferentes métodos de la operación.
             * Para el valor "0" que es el de salir, se cambia el valor del booleano "operation" a "false" y el bucle del
             * menú finaliza por lo que la aplicación acaba.
             *
             * En caso de que no se introduzca un número entre 0 y 9, la aplicación te devuelve al menú principal.
             */
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
                    System.out.println("El valor introducido no es válido.");
                    break;
            }
            /**
             * Este código dibuja una línea que solicita un "enter".
             * Lo hago para que al devolver el resultado de la operación no salte de nuevo el menú principal
             * De esta manera se genera una transición entre resultado y siguiente operación a realizar
             * En este caso he usado la clase "Scanner"
             */
            System.out.println("Pulsa ENTER para continuar.");
            Scanner scanner1 = new Scanner(System.in);
            String inputline = scanner1.nextLine();
        }
    }

    /**
     * Método genérico
     *
     * Para no tener que usar scanners en cada método, he generado un método que funciona como la clase "Scanner"
     * Básicamente a través de las clases InputStreamReader y BufferedReader se captura un texto en "value" con un input de tipo texto
     * Por ejemplo makeQuestion podria trabajar con un parámetro texto que fuera "Dime tu nombre"
     * Este "value" es lo que devolverá es el valor que por consola se responda al parámetro
     * @param text
     * @return value
     */
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

    /**
     * Leer 5 números en el orden introducido
     *
     * Creo una Lista vacía a la que voy añadiendo los items.
     * Los items los genero en la linea 136 con el método "makeQuestion"
     * Mencionar que como "makeQuestion" se define como String lo convierto a número con Integer.parseInt (
     * (esto mismo lo hago siempre que el dato manejado no sea de tipo String para evitar errores)
     * Mientras el array tenga un tamaño inferior a 5 el método se ejecuta
     * El segundo for recorre la lista generada
     */
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

    /**
     * Leer 5 números introducidos en el orden inverso
     *
     * El cambio respecto al método anterior es cómo funciona el segundo "for" de la linea 162
     * Este for resta desde su tamaño para hacer el recorrido inverso pero teniendo en cuenta que un array
     * de 5 posiciones empieza en 0 y acaba en 4.
    */
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

    /**
     * Hacer la media de los negativos y positivos. Contar los 0.
     * Se introducen 5 números
     */
    public static void thirdMethod(){
        //Como en los dos anteriores, genero una lista con los 5 inputs
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; numbers.size() < 5; i++) {
            int newNumber = Integer.parseInt(makeQuestion("Introduce el número " + i));
            numbers.add(newNumber);
        }

        //Inicio todas las variables para poderlas usar luego
        int ceros =0;
        double positive = 0;
        int positiveCount = 0;
        double negative = 0;
        int negativeCount = 0;

        //Bucle que funciona con un if. S
        // Si el número es positivo, lo suma al contador "positive" y además suma 1 al contador de positivos léidos
        // Si el número es negativo, misma lógica
        // Si el número es 0 solamente lo cuenta en la variable "ceros" que he creado arriba
        for (int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) > 0){
                positive += numbers.get(i);
                positiveCount++;
            } else if (numbers.get(i) < 0){
                negative += numbers.get(i);
                negativeCount++;
            } else {
                ceros++;
            }
        }
        //Printeo los resultados y básicamente divido el agregador por el contador. Para el 0 solo muestro el contador
        System.out.println("La media de los números POSITIVOS que has introducido es " + positive/positiveCount);
        System.out.println("La media de los números NEGATIVOS que has introducido es " + negative/negativeCount);
        System.out.println("Número de ceros introducidos: " + ceros);
    }

    /**
     * Cuenta los caracteres de una cadena sin contar los 0
     *
     * Capturando la cadena uso el método replace para quitar los espacios por nada y luego guardo esto en "noSpaceText"
     * Cuento la longitud de "noSpaceText" en 218 al mismo tiempo que muestro por consola el resultado
      */
    public static void fourthMethod() {
        String newText = makeQuestion("Introduce texto o escribe algo");
        String noSpaceText = newText.replace(" ", "");
        System.out.println("Tu cadena tiene " + noSpaceText.length() + " caracteres");
    }

    /**
     * Mostrar una cadena de texto al revés
     *
     * Aplico el método "reverse" sobre el input capturado
     */
    public static void fifthMethod() {
        String newText = makeQuestion("Introduce texto o escribe algo");
        String reverse = new StringBuffer(newText).reverse().toString();
        System.out.println("La cadena de texto al revés: " + reverse);
    }

    /**
     * Mostrar una cadena de texto sin espacios
     *
     * Con el metodo replace se cambian los espacios y se guardan en "noSpaceText". Luego, se muestra por consola
     */
    public static void sixthMethod(){
        String newText = makeQuestion("Introduce texto o escribe algo");
        String noSpaceText = newText.replace(" ", "");
        System.out.println("La cadena de texto sin espacios: " + noSpaceText);
    }

    /**
     * Unir dos cadenas de texto
     *
     * newText1 y newText2 capturan los valores que se unen con "+" y espacio entre ambas en la linea 251
     */
    public static void seventhMethod(){
        String newText1 = makeQuestion("Introduce un primer texto o escribe algo");
        String newText2 = makeQuestion("Introduce un segundo texto o escribe algo");
        System.out.println("El resultado de unir ambas cadenas es:");
        System.out.println(newText1 + " " + newText2);
    }

    /**
     * Introducir una vocal que sustituye todas las vocales de una cadena de texto tambien introducida
     *
     * En las dos primeras lineas del metodo capturo la vocal y el texto sobre el que aplicar el cambio
     * A continuacion en newText reeplazo cualquier vocal (mayuscula, minuscula o ambas con caracter especial) por la vocal introducida
     */
    public static void eighthMethod(){
        String myVocal = makeQuestion("Introduce una vocal");
        String text = makeQuestion("Introduce un texto o escribe algo");

        String newText = text.replaceAll("[AEIOUÁÉÍÓÚÀÈÌÒÙÄËÏÖÜaeiouáéíóúàèìòùäëïöü]",myVocal);
        System.out.println("Al sustituir todas las vocales por la que has puesto...");
        System.out.println(newText);
    }

    /**
     * Mostrar el ACII de los caracteres introducidos en una cadena de texto
     *
     * Utilizo el typo byte de array para almacenar el contenido de "text" que es lo introducido.
     * Con esto y llamando al método getBytes una varaible de texto se convierte por UTF-8.
     */
    public static void ninthMethod(){
        String text = makeQuestion("Introduce un texto o escribe algo");
        byte[] textBytes = text.getBytes(StandardCharsets.UTF_8);
        System.out.println("El valor ASCII de los caracteres del texto:");
        System.out.println(Arrays.toString(textBytes));
    }

}
