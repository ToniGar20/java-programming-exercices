package Practice3;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class ATM {

    private Integer idATM;
    private Integer idLastAtM;
    private static Integer[][] moneyNotes;
    private static ArrayList<Card> registeredCards = new ArrayList<>();


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

    //Constructor with parameters
    public ATM(Integer idATM, Integer idLastAtM, Integer[][] moneyNotes) {
        this.idATM = idATM;
        this.idLastAtM = idLastAtM;
        ATM.moneyNotes = moneyNotes;
    }

    //Empty constructor
    public ATM() {
    }

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


    public static void updateATMNotes(int amountRequest) {
        int disposableMoney = 0;
        for (int i = 0; i < moneyNotes.length; i++) {
            disposableMoney += moneyNotes[i][0] * moneyNotes[i][1];
        }
        if (amountRequest > disposableMoney) {
            System.out.println("El importe solicitado no está disponbile");
            System.out.println("La retirada máxima es de: " + disposableMoney);
        } else {

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
            /**
             * A continuación se muestran los billetes que se han extraído y el tipo de cada uno:
             */
            System.out.println("Dinero y billetes retirados: ");
            for (int i = 0; i < notesCount.length; i++) {
                if (notesCount[i][1] != 0) {
                    System.out.println(notesCount[i][1] + " billete/s de " + notesCount[i][0] + "€");
                }
            }
        }
    }


    public static void takeMoneyOut(){
        System.out.println("=====================================================================");
        System.out.println("Acceso con NIF Y PIN");
        String newNIF = Main.makeQuestion("Introduce tu NIF: ");
        int newPIN = parseInt(Main.makeQuestion("Introduce tu PIN: "));

        for (int i = 0; i < getRegisteredCards().size(); i++){
            if (getRegisteredCards().get(i).getNIF().equals(newNIF)){
                System.out.println("El NIF es correcto.");
            } else if ((getRegisteredCards().get(i).getNIF() != (newNIF)) && i < (getRegisteredCards().size()-1)) {
                continue;
            } else {
                System.out.println("El NIF es incorrecto. Volviendo al menú principal.");
                break;
            }

            if (getRegisteredCards().get(i).getPIN().equals(newPIN)){
                System.out.println("El PIN es correcto.");
            } else if ((getRegisteredCards().get(i).getPIN() != (newPIN)) && i < (getRegisteredCards().size()-1)) {
                continue;
            } else {
                System.out.println("El PIN es incorrecto. Volviendo al menú principal.");
                break;
            }

            Card activeCard = getRegisteredCards().get(i);

            System.out.println("=====================================================================");
            int moneyOutRequest = parseInt(Main.makeQuestion("¿Cuanto dinero quieres sacar?"));
            System.out.println("=====================================================================");

            if (activeCard instanceof DebitCard) {
                if (((DebitCard) activeCard).getAvailableBalance() >= moneyOutRequest) {
                    ((DebitCard) activeCard).setAvailableBalance(((DebitCard) activeCard).getAvailableBalance() - moneyOutRequest);
                    updateATMNotes(moneyOutRequest);
                    System.out.println("El débito restante en la tarjeta es: " + ((DebitCard) activeCard).getAvailableBalance());
                    break;
                } else {
                    System.out.println("No hay saldo suficiente.");
                }
            }

            if (activeCard instanceof CreditCard) {
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
                ) {
                    int creditMoneyOutRequest = moneyOutRequest - ((CreditCard) activeCard).getAvailableBalance();
                    ((CreditCard) activeCard).setAvailableBalance(0);
                    ((CreditCard) activeCard).setAvailableCredit(((CreditCard) activeCard).getAvailableCredit() - creditMoneyOutRequest);
                    updateATMNotes(moneyOutRequest);
                    System.out.println("El débito restante en la tarjeta es: " + ((CreditCard) activeCard).getAvailableBalance());
                    System.out.println("El crédito restante en la tarjeta es: " + ((CreditCard) activeCard).getAvailableCredit());
                    break;
                } else if ((((CreditCard) activeCard).getAvailableBalance() + ((CreditCard) activeCard).getAvailableCredit()) < moneyOutRequest) {
                    System.out.println("No hay saldo y crédito suficiente.");
                    break;
                }
            }
        }
    }
}