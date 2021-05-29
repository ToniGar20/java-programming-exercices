package Practice3;

public class Helper {
    /** The Constant Currency Denominations. */
    protected static final int[] currDenom = { 10, 20, 50, 100, 200 };

    /** The Number of Currencies of each type */
    protected static int[] currNo = { 1, 4, 2, 2, 10 };
    /** The count. */
    protected int[] count = { 0, 0, 0, 0, 0 };
    protected static int totalCorpus;

    static {
        calcTotalCorpus();
    }

    public static void calcTotalCorpus() {
        for (int i = 0; i < currDenom.length; i++) {
            totalCorpus = totalCorpus + currDenom[i] * currNo[i];
        }
    }


    public synchronized void withdrawCash(int amount) {
        if (amount <= totalCorpus) {
            for (int i = 0; i < currDenom.length; i++) {
                if (currDenom[i] <= amount) {//If the amount is less than the currDenom[i] then that particular denomination cannot be dispensed
                    int noteCount = amount / currDenom[i];
                    if (currNo[i] > 0) {//To check whether the ATM Vault is left with the currency denomination under iteration
                        //If the Note Count is greater than the number of notes in ATM vault for that particular denomination then utilize all of them
                        count[i] = noteCount >= currNo[i] ? currNo[i] : noteCount;
                        currNo[i] = noteCount >= currNo[i] ? 0 : currNo[i] - noteCount;
                        //Deduct the total corpus left in the ATM Vault with the cash being dispensed in this iteration
                        totalCorpus = totalCorpus - (count[i] * currDenom[i]);
                        //Calculate the amount that need to be addressed in the next iterations
                        amount = amount - (count[i] * currDenom[i]);
                    }
                }
            }
            displayNotes();
            displayLeftNotes();

        } else {
            System.out.println("Unable to dispense cash at this moment for this big amount");
        }

    }

    private void displayNotes() {
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                System.out.println(currDenom[i] + " * " + count[i] + " = " + (currDenom[i] * count[i]));
            }
        }
    }

    private void displayLeftNotes() {
        for (int i = 0; i < currDenom.length; i++) {
            System.out.println("Notes of " + currDenom[i] + " left are " + currNo[i]);
        }

    }

    public static void main(String[] args) {
    }
}
