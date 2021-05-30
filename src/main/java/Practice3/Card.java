package Practice3;

public class Card {

    private String NIF;
    private Integer PIN;
    private String name;
    private String surname;
    private boolean cardStatus;

    //Getters & Setters

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

    //En este caso se utiliza el booleano para que devuelva un mensaje en función de cada estado
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

    //Constructor con parámetros
    public Card(String NIF, Integer PIN, String name, String surname, boolean cardStatus) {
        this.NIF = NIF;
        this.PIN = PIN;
        this.name = name;
        this.surname = surname;
        this.cardStatus = cardStatus;
    }

    //Constructor vacío
    public Card() {
    }

    /**
     * Método showCards
     *
     * Se recorre la lista de tarjetas de la clase ATM printeando los datos con un toString,
     * que sobreescribe los datos en cada subclase.
     */
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

    //Método toString principal
    @Override
    public String toString() {
        return
                "\nNIF=" + getNIF() +
                "\nNombre y apellido='" + getName() + " " + getSurname() +
                "\nCardStatus=" + isCardStatus();
    }
}