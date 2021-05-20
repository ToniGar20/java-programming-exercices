package Practice3;

import java.util.ArrayList;
import java.util.Arrays;

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

    public void takeMoneyOut(String NIF, Integer PIN){
        for (int i = 0; i < getRegisteredCards().size(); i++) {
            if (getRegisteredCards().get(i).getNIF().equals(NIF)){
                System.out.println("El NIF es correcto");
                if(getRegisteredCards().get(i).getPIN().equals(PIN)){
                    System.out.println("El PIN es correcto");
                    int dineroRetirar = parseInt(Main.makeQuestion("¿Cuanto dinero quieres sacar?"));

                    // No puedo hacer el get del saldo de la tarjeta porque en la lista se guardan tarjetas, no saldo

                    // Duda principal. La lista es de tipo Card y no guarda los datos de Debit y Credit...

                }
            }
        }
    }

    public static void showMoneyBills(){
        System.out.println("Billetes disponibles en el cajero");
        for (int i = 0; i < getMoneyBills().length ; i++) {
                System.out.println(moneyBills[i][1] + " billetes de " + moneyBills[i][0] + "€");
        }
        System.out.println("======================");
    }

}
