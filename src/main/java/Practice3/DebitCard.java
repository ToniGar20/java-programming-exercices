package Practice3;

public class DebitCard extends Card {

    private Integer availableBalance;

    //Getters & Setters

    public Integer getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Integer availableBalance) {
        this.availableBalance = availableBalance;
    }

    //Constructor con parámetros
    public DebitCard(String NIF, int PIN, String name, String surname, boolean cardStatus, Integer availableBalance) {
        super(NIF,PIN,name,surname,cardStatus);
        this.availableBalance = availableBalance;
    }

    //Constructor vacío
    public DebitCard(){
    }

    //Override del toString de la superclase "Card" para devolver los datos de esta subclase
    @Override
    public String toString() {
        return
                "\nNombre y apellidos: " + getName() + " " + getSurname() +
                "\nNIF: " + getNIF().toUpperCase() +
                "\nSaldo disponible: " + getAvailableBalance() +
                "\nDébito: " + isCardStatus();
    }
}