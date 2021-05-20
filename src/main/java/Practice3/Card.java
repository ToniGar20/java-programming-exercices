package Practice3;

public class Card {

    private String NIF;
    private Integer PIN;
    private String name;
    private String surname;
    private boolean cardStatus;

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public Integer getPIN() {
        return PIN;
    }

    public void setPIN(Integer PIN) {
        this.PIN = PIN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(boolean cardStatus) {
        this.cardStatus = cardStatus;
    }

    //Constructor with parameters
    public Card(String NIF, Integer PIN, String name, String surname, boolean cardStatus) {
        this.NIF = NIF;
        this.PIN = PIN;
        this.name = name;
        this.surname = surname;
        this.cardStatus = cardStatus;
    }

    //Empty constructor
    public Card() {
    }

    public static void showCard(){
        System.out.println("Tarjetas disponibles:");
        System.out.println("-----------------");
        for (Card cards : ATM.getRegisteredCards()){
            System.out.println("NIF: " + cards.getNIF());
            System.out.println("Nombre y apellido: " + cards.getName() + " " + cards.getSurname());
            System.out.println("-----------------");
        }

    }




}

