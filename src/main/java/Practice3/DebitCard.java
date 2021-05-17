package Practice3;

public class DebitCard extends Card {

    Double availableBalance;

    public Double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Double availableBalance) {
        this.availableBalance = availableBalance;
    }

    //Constructor with parameters
    public DebitCard(Double availableBalance) {
        this.availableBalance = availableBalance;
    }


    //Empty constructor
    public DebitCard(String s, int i, String fran, String fran1, int i1){
    }
}
