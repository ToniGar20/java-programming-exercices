package Practice3;

public class CreditCard extends Card{

    public Integer availableBalance;
    public Integer availableCredit;

    public Integer getAvailableBalance() { return availableBalance; }

    public void setAvailableBalance(Integer availableBalance) { this.availableBalance = availableBalance; }

    public Integer getAvailableCredit() { return availableCredit; }

    public void setAvailableCredit(Integer availableCredit) { this.availableCredit = availableCredit; }

    //Constructor with parameters
    public CreditCard(String NIF, int PIN, String name, String surname, boolean cardStatus, Integer availableBalance, Integer availableCredit) {
            super(NIF,PIN,name,surname,cardStatus);
            this.availableBalance = availableBalance;
            this.availableCredit = availableCredit;
        }


    //Empty constructor
    public CreditCard(){

    }

    @Override
    public String toString() {
        return
                "\nName and surname: " + getName() + " " + getSurname() +
                "\nCard Number: " + getNIF().toUpperCase() +
                "\nAvailable Balance: " + getAvailableBalance() +
                "\nAvailable Credit: " + getAvailableCredit() +
                "\nCardStatus: " + isCardStatus();
    }
}
