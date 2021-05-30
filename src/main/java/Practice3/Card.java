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

    public String isCardStatus() {
        if(cardStatus){
            return "Tarjeta activa";
        } else {
            return "Tarjeta inactiva";
        }

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

    public static void showCards(){
        System.out.println("=====================================================================");
        System.out.println("Tarjetas disponibles:");
        for (int i = 0; i < ATM.getRegisteredCards().size(); i++) {
            System.out.println(ATM.getRegisteredCards().get(i).toString());
        }
        System.out.println("=====================================================================");
        /**
         * Este método showCard trabaja con un método toString que, mediante override en Debit y Credit desde Card
         * imprime una tarjeta u otra según el tipo porque ambas se han creado según tipo en Main y pasadas a la lista
          */
    }

    @Override
    public String toString() {
        return
                "\nNIF=" + getNIF() +
                "\nNombre y apellido='" + getName() + " " + getSurname() +
                "\nCardStatus=" + isCardStatus();
    }
}