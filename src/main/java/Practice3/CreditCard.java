package Practice3;

public class CreditCard extends Card{

    Double availableBalance;
    Double availableCredit;

    public Double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Double getAvailableCredit() {
        return availableCredit;
    }

    public void setAvailableCredit(Double availableCredit) {
        this.availableCredit = availableCredit;
    }

    //Constructor with parameters
    public CreditCard(Double availableBalance, Double availableCredit) {
        this.availableBalance = availableBalance;
        this.availableCredit = availableCredit;
    }

    //Empty constructor
    public CreditCard(String s, int i, String javi, String javi1, int i1, int i2){

    }
}
