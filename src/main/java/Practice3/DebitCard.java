package Practice3;

import java.util.ArrayList;

public class DebitCard extends Card {

    private Integer availableBalance;

    private static ArrayList<DebitCard> prova = new ArrayList<>();

    public static ArrayList<DebitCard> getProva() {
        return prova;
    }

    public static void setProva(ArrayList<DebitCard> prova) {
        DebitCard.prova = prova;
    }

    public Integer getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Integer availableBalance) {
        this.availableBalance = availableBalance;
    }

    //Constructor with parameters
    public DebitCard(String NIF, int PIN, String name, String surname, boolean cardStatus, Integer availableBalance) {
        super(NIF,PIN,name,surname,cardStatus);
        this.availableBalance = availableBalance;
    }

    //Empty constructor
    public DebitCard(){
    }

    @Override
    public String toString() {
        return
                "\nNombre y apellidos: " + getName() + " " + getSurname() +
                "\nNIF: " + getNIF().toUpperCase() +
                "\nSaldo disponible: " + getAvailableBalance() +
                "\nDébito: " + isCardStatus();

    }
}
