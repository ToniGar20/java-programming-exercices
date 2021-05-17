package Practice3;

import java.util.ArrayList;

public class ATM {

    Integer idATM;
    Integer idLastAtM;
    Integer[][] moneyBills;
    ArrayList<Card> registeredCards = new ArrayList<>();


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

    public Integer[][] getMoneyBills() {
        return moneyBills;
    }

    public void setMoneyBills(Integer[][] moneyBills) {
        this.moneyBills = moneyBills;
    }

    public ArrayList<Card> getRegisteredCards() {
        return registeredCards;
    }

    public void setRegisteredCards(ArrayList<Card> registeredCards) {
        this.registeredCards = registeredCards;
    }

    //Constructor with parameters
    public ATM(Integer idATM, Integer idLastAtM, Integer[][] moneyBills, ArrayList<Card> registeredCards) {
        this.idATM = idATM;
        this.idLastAtM = idLastAtM;
        this.moneyBills = moneyBills;
        this.registeredCards = registeredCards;
    }

    //Empty constructor
    public ATM() {
    }
}
