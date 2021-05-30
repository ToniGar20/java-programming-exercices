package Practice3;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class ATM {

    private Integer idATM;
    private Integer idLastAtM;
    private static Integer[][] moneyNotes;
    private static ArrayList<Card> registeredCards = new ArrayList<>();

    //Getters & Setters

    public Integer getIdATM() {
        return idATM;
    }

    public void setIdATM(Integer idATM) {
        this.idATM = idATM;
    }

    public Integer getIdLastAtM() {
        return idLastAtM;
    }

    public void setIdLastAtM(Integer idLastAtM) {
        this.idLastAtM = idLastAtM;
    }

    public static Integer[][] getMoneyNotes() {
        return moneyNotes;
    }

    public void setMoneyNotes(Integer[][] moneyNotes) {
        ATM.moneyNotes = moneyNotes;
    }

    public static ArrayList<Card> getRegisteredCards() { return registeredCards; }

    public static void setRegisteredCards(ArrayList<Card> registeredCards) {
        ATM.registeredCards = registeredCards;
    }

    //Constructor con parámetros
    public ATM(Integer idATM, Integer idLastAtM, Integer[][] moneyNotes) {
        this.idATM = idATM;
        this.idLastAtM = idLastAtM;
        ATM.moneyNotes = moneyNotes;
    }

    //Constructor vacío
    public ATM() {
    }

    /**
     * Método showMoneyNotes
     *
     * Devuelve el contenido de la variable "moneyNotes" con mensaje por consola, con el tipo de billete y cantidad
     * Si la cantidad de este tipo de billete es 0, no se muestra.
     *
     */
    public static void showMoneyNotes(){
        System.out.println("=====================================================================");
        System.out.println("Billetes disponibles en el cajero: ");
        for (int i = 0; i < getMoneyNotes().length ; i++) {
            if (moneyNotes[i][1] > 0) {
                System.out.println(moneyNotes[i][1] + " billete/s de " + moneyNotes[i][0] + "€");
            }
        }
        System.out.println("=====================================================================");
    }


    /**
     * Método updateATMNotes
     *
     * Método que, mediante un parámetro de entrada, actualizará la variable "moneyNotes" y devolverá la cantidad de
     * billetes extraídos según el parámetro de entrada. Este método se realiza aparte se llama al retirar dinero para
     * así actualizar el estado del importe que tiene el cajero.
     *
     * Más comentarios en el método ->
     *
     * @param amountRequest
     */
    public static void updateATMNotes(int amountRequest) {

        //Se inicia una variable que guardará la cantidad de dinero del cajero.
        //El importe es el valor del billete por la cantidad que haya.
        int disposableMoney = 0;
        for (int i = 0; i < moneyNotes.length; i++) {
            disposableMoney += moneyNotes[i][0] * moneyNotes[i][1];
        }

        //En caso de que el dinero solicitado sea mayor que el disponible (siempre y cuando la tarjeta del usuario alcance esa cifra),
        //sale un aviso de que no está disponible
        if (amountRequest > disposableMoney) {
            System.out.println("El importe solicitado no está disponbile");
            System.out.println("La retirada máxima es de: " + disposableMoney);
        } else {

            //Y en caso contrario, cuando el importe lo cubra la tarjeta y esté en el cajero:
            //1- Se crea un array bidimensional para guardar los billetes de cada tipo solicitados
            //2- Mediante un if se descartan los billetes superiores al importe solicitado
            //3- Se divide el importe pedido con el tipos de billete evaluado
            //4- Se actualiza el array nuevo de billetes extraídos y el array de la variable "moneyNotes"
            //5- Se resta la iteración del tipo de billete sobre el total de dinero pedido. Si falta dinero, la iteración sigue.
            int[][] notesCount = {{500, 0}, {200, 0}, {100, 0}, {50, 0}, {20, 0}, {10, 0}, {5, 0}};

            for (int i = 0; i < getMoneyNotes().length; i++) {
                if (moneyNotes[i][0] <= amountRequest) {
                    int noteCount = amountRequest / moneyNotes[i][0];
                    if (moneyNotes[i][1] > 0) {
                        notesCount[i][1] = noteCount >= moneyNotes[i][1] ? moneyNotes[i][1] : noteCount;
                        moneyNotes[i][1] = noteCount >= moneyNotes[i][1] ? 0 : moneyNotes[i][1] - noteCount;
                        amountRequest = amountRequest - (notesCount[i][1] * moneyNotes[i][0]);
                    }
                }
            }

            //A continuación se muestran los billetes que se han extraído sacando por consola la variable creada "notesCount",
            //solamente si el contador del tipo de billete no es 0.
            System.out.println("Dinero y billetes retirados: ");
            for (int i = 0; i < notesCount.length; i++) {
                if (notesCount[i][1] != 0) {
                    System.out.println(notesCount[i][1] + " billete/s de " + notesCount[i][0] + "€");
                }
            }
        }
    }


    /**
     * Método takeMoneyOut
     *
     * Se compone de las siguientes partes:
     * - Bucle "for" que itera sobre las tarjetas buscando aquellas que coincidan con el NIF y PIN que se pasen.
     * - Gestión mediante condicionales de las credenciales pasadas.
     * - Creación de un objetivo tarjeta que contenga los datos de la coincidencia
     * - Gestión de los datos de saldo y/o crédito de la tarjeta en cuestión según su tipo
     * - Se hacen llamadas en la retirada de dinero al método updateATMNotes.
     *
     */
    public static void takeMoneyOut(){

        //Generación de variables para el login
        System.out.println("=====================================================================");
        System.out.println("Acceso con NIF Y PIN");
        String newNIF = Main.makeQuestion("Introduce tu NIF: ");
        int newPIN = parseInt(Main.makeQuestion("Introduce tu PIN: "));

        //Bucle que iterará para encontrar NIF y PIN en la variable "registeredCards" que guarda todas las tarjetas
        for (int i = 0; i < getRegisteredCards().size(); i++){

            //"if" con 3 partes:
            //1. Se busca DNI en la posición actual del incrementador
            //2. Si no estuviera, se seguirá iterando en el segundo "else if" según el tamaño de la lista
            //3. Si al acabar la lista el DNI no está, error devuelto por pantalla
            if (getRegisteredCards().get(i).getNIF().equals(newNIF)){
                System.out.println("El NIF es correcto.");
            } else if ((getRegisteredCards().get(i).getNIF() != (newNIF)) && i < (getRegisteredCards().size()-1)) {
                continue;
            } else {
                System.out.println("El NIF es incorrecto. Volviendo al menú principal.");
                break;
            }

            //Mismo que con el DNI pero para PIN
            if (getRegisteredCards().get(i).getPIN().equals(newPIN)){
                System.out.println("El PIN es correcto.");
            } else if ((getRegisteredCards().get(i).getPIN() != (newPIN)) && i < (getRegisteredCards().size()-1)) {
                continue;
            } else {
                System.out.println("El PIN es incorrecto. Volviendo al menú principal.");
                break;
            }

            //Al encontrar el DNI y el PIN se instancia una tarjeta con los datos facilitados
            Card activeCard = getRegisteredCards().get(i);

            //Se almacena la variable de dinero a retirar
            System.out.println("=====================================================================");
            int moneyOutRequest = parseInt(Main.makeQuestion("¿Cuanto dinero quieres sacar?"));

            //A partir de aquí se encuentran dos bloques de código:
            //1- El primero para tarjetas de tipo DebitCard
            //2- El segundo para tarjetas de tipo CreditCard
            //NOTA: aplico un CAST a la clase "Card" según quiera manejar "DebitCard" o "CreditCard" para usar sus respectivas variables/atributos

            if (activeCard instanceof DebitCard) {
                if (((DebitCard) activeCard).getAvailableBalance() >= moneyOutRequest) { // Condición de que el débito sea mayor o igual a lo que se quiere retirar
                    ((DebitCard) activeCard).setAvailableBalance(((DebitCard) activeCard).getAvailableBalance() - moneyOutRequest); //Cast para acceder a las variables de la subclase y restar el importe pedido
                    updateATMNotes(moneyOutRequest); //Se actualiza el estado del ATM y lo billetes con el importe confirmado
                    System.out.println("El débito restante en la tarjeta es: " + ((DebitCard) activeCard).getAvailableBalance()); //Se imprime por pantalla el saldo restante
                    break;
                } else {
                    System.out.println("No hay saldo suficiente."); //No hay loreymoney :D
                }
            }

            // Para la tarjeta de crédito hay diferentes opciones
            if (activeCard instanceof CreditCard) {
                //Condición 1: Si el dinero se puede cubrir con el saldo disponible; el método es similar al de DebitCard
                if(((CreditCard) activeCard).getAvailableBalance() >= moneyOutRequest) {
                    ((CreditCard) activeCard).setAvailableBalance(((CreditCard) activeCard).getAvailableBalance() - moneyOutRequest);
                    updateATMNotes(moneyOutRequest);
                    System.out.println("El débito restante en la tarjeta es: " + ((CreditCard) activeCard).getAvailableBalance());
                    System.out.println("El crédito restante en la tarjeta es: " + ((CreditCard) activeCard).getAvailableCredit());
                    break;
                } else if (
                        (((CreditCard) activeCard).getAvailableBalance() < moneyOutRequest)
                                &&
                                (((CreditCard) activeCard).getAvailableBalance() + ((CreditCard) activeCard).getAvailableCredit() >= moneyOutRequest)
                ) //Condición 2: si el dinero solicitado es mayor al saldo pero menor o igual que la suma del débito y crédito
                {
                    int creditMoneyOutRequest = moneyOutRequest - ((CreditCard) activeCard).getAvailableBalance(); //Creo una variable para guardar lo que el saldo no puede cubrir
                    ((CreditCard) activeCard).setAvailableBalance(0); //Saldo a 0
                    ((CreditCard) activeCard).setAvailableCredit(((CreditCard) activeCard).getAvailableCredit() - creditMoneyOutRequest); //El crédito será igual a la diferencia del crédito menos lo guardado en la variable anterior
                    updateATMNotes(moneyOutRequest); //Se actualiza el estado de los billetes del cajero
                    System.out.println("El débito restante en la tarjeta es: " + ((CreditCard) activeCard).getAvailableBalance());
                    System.out.println("El crédito restante en la tarjeta es: " + ((CreditCard) activeCard).getAvailableCredit());
                    break;
                } else if ((((CreditCard) activeCard).getAvailableBalance() + ((CreditCard) activeCard).getAvailableCredit()) < moneyOutRequest) {
                    // Condición 3: si el importe no se puede cubrir con la suma del saldo y el crédito acabamos.
                    System.out.println("No hay saldo y crédito suficiente.");
                    break;
                }
            }
        }
    }
}