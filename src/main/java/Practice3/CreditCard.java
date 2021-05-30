package Practice3;

public class CreditCard extends Card{

    public Integer availableBalance;
    public Integer availableCredit;

    //Getters & Setters

    public Integer getAvailableBalance() { return availableBalance; }

    public void setAvailableBalance(Integer availableBalance) { this.availableBalance = availableBalance; }

    public Integer getAvailableCredit() { return availableCredit; }

    public void setAvailableCredit(Integer availableCredit) { this.availableCredit = availableCredit; }

    //Constructor con parámetros
    public CreditCard(String NIF, int PIN, String name, String surname, boolean cardStatus, Integer availableBalance, Integer availableCredit) {
            super(NIF,PIN,name,surname,cardStatus);
            this.availableBalance = availableBalance;
            this.availableCredit = availableCredit;
        }


    //Constructor vacío
    public CreditCard(){

    }

    //Override del toString de la superclase "Card" para devolver los datos de esta subclase
    @Override
    public String toString() {
        return
                "\nNombre y apellidos: " + getName() + " " + getSurname() +
                "\nNIF: " + getNIF().toUpperCase() +
                "\nSaldo disponible: " + getAvailableBalance() +
                "\nCrédito disponible: " + getAvailableCredit() +
                "\nCrédito: " + isCardStatus();
    }
}