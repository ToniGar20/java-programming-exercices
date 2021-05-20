package Practice3;

public class DebitCard extends Card {

    private Integer availableBalance;

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

//    @Override
//    public void showCard(Card card) {
//    }
}
