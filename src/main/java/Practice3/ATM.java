package Practice3;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class ATM {

    private Integer idATM;
    private Integer idLastAtM;
    private static Integer[][] moneyBills;
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

    public static Integer[][] getMoneyBills() {
        return moneyBills;
    }

    public void setMoneyBills(Integer[][] moneyBills) {
        ATM.moneyBills = moneyBills;
    }

    public static ArrayList<Card> getRegisteredCards() { return registeredCards; }

    public static void setRegisteredCards(ArrayList<Card> registeredCards) {
        ATM.registeredCards = registeredCards;
    }

    //Constructor with parameters
    public ATM(Integer idATM, Integer idLastAtM, Integer[][] moneyBills) {
        this.idATM = idATM;
        this.idLastAtM = idLastAtM;
        ATM.moneyBills = moneyBills;
    }

    //Empty constructor
    public ATM() {
    }

    public static void showMoneyBills(){
        System.out.println("Billetes disponibles en el cajero");
        for (int i = 0; i < getMoneyBills().length ; i++) {
            System.out.println(moneyBills[i][1] + " billetes de " + moneyBills[i][0] + "€");
        }
        System.out.println("======================");
    }


    public static void updateATMBills(int amountRequest) {
        int disposableMoney = 0;
        for (int i = 0; i < moneyBills.length; i++) {
            disposableMoney += moneyBills[i][0] * moneyBills[i][1];
        }
        if (amountRequest > disposableMoney) {
            System.out.println("El importe solicitado no está disponbile");
            System.out.println("La retirada máxima es de: " + disposableMoney);
        } else {

            int[][] billsCount = {{500, 0}, {200, 0}, {100, 0}, {50, 0}, {20, 0}, {10, 0}, {5, 0}};

            for (int i = 0; i < getMoneyBills().length; i++) {
                if (moneyBills[i][0] <= amountRequest) {
                    int noteCount = amountRequest / moneyBills[i][0];
                    System.out.println(noteCount);

                    if (moneyBills[i][1] > 0) {
                        billsCount[i][1] = noteCount >= moneyBills[i][1] ? moneyBills[i][1] : noteCount;
                        moneyBills[i][1] = noteCount >= moneyBills[i][1] ? 0 : moneyBills[i][1] - noteCount;
                        amountRequest = amountRequest - (billsCount[i][1] * moneyBills[i][0]);
                    }
                }
            }

            /**
             * Se muestran los billetes que se han extraído y el tipo de cada uno:
             */

            System.out.println("Dinero y billetes retirados: ");

            for (int i = 0; i < billsCount.length; i++) {
                if (billsCount[i][1] != 0) {
                    System.out.println(billsCount[i][1] + " billete/s de " + billsCount[i][0] + "€");
                    System.out.println("Total retirado: " + amountRequest);
                }
            }
        }
    }


    public static void takeMoneyOut(){
        String newNIF = Main.makeQuestion("Introduce tu NIF: ");
        int newPIN = parseInt(Main.makeQuestion("Introduce tu PIN: "));

        for (int i = 0; i < getRegisteredCards().size(); i++) {
            if (getRegisteredCards().get(i).getNIF().equals(newNIF)){
                System.out.println("El NIF es correcto.");
                if (getRegisteredCards().get(i).getPIN().equals(newPIN)) {
                    System.out.println("El PIN es correcto.");

                    Card activeCard = getRegisteredCards().get(i);
                    int moneyOutRequest = parseInt(Main.makeQuestion("¿Cuanto dinero quieres sacar?"));

                    if (activeCard instanceof DebitCard) {
                        ((DebitCard) activeCard).setAvailableBalance(((DebitCard) activeCard).getAvailableBalance() - moneyOutRequest);
                        updateATMBills(moneyOutRequest);
                        break;
                    } else {
                            System.out.println("No hay saldo suficiente");
                    }

                    if (activeCard instanceof CreditCard) {
                        if(((CreditCard) activeCard).getAvailableBalance() >= moneyOutRequest) {
                            ((CreditCard) activeCard).setAvailableBalance(((CreditCard) activeCard).getAvailableBalance() - moneyOutRequest);
                            updateATMBills(moneyOutRequest);
                            break;
                        } else if (((CreditCard) activeCard).getAvailableBalance() + ((CreditCard) activeCard).getAvailableCredit() <= moneyOutRequest) {
                            int creditMoneyOutRequest = moneyOutRequest - ((CreditCard) activeCard).getAvailableBalance();
                            ((CreditCard) activeCard).setAvailableBalance(0);
                            ((CreditCard) activeCard).setAvailableBalance(((CreditCard) activeCard).getAvailableCredit() - creditMoneyOutRequest);
                            updateATMBills(moneyOutRequest);
                        } else if (((CreditCard) activeCard).getAvailableBalance() + ((CreditCard) activeCard).getAvailableCredit() < moneyOutRequest) {
                        System.out.println("No hay saldo y crédito suficiente");
                        break;
                        }
                    }
                }
                else {
                    System.out.println("El PIN es incorrecto. Volviendo al menú principal.");
                    break;
                }
            } else {
                System.out.println("El NIF es incorrecto. Volviendo al menú principal.");
                break;
            }
        }



    }






}
