/**
 * Created by ilyes on 22/11/15.
 */
public class AutomateEtatFinal {

    private char[] aphabet;
    private int[][] transitions;
    private boolean[] finalState;

    public AutomateEtatFinal() {

    }


    public AutomateEtatFinal(char[] aphabet, int[][] transitions, boolean[] finalState) {

        try {

            if (Others.isMatriceColumnsNumbersEqual(transitions)) {
                this.transitions = transitions;
            }

            if (Others.isRowsNumberEqualToColumnsNumber(aphabet, transitions)) {
                this.aphabet = aphabet;
            }
            this.finalState = finalState;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Return the assicieted integer for an alphabet item
     *
     * @param caractere the caractere
     * @return the int
     */
    int charToInteger(char caractere) {

        // Parcour des l'laphbet et on retourne l'entier associer
        for (int i = 0; i < aphabet.length; i++) {
            if (aphabet[i] == caractere) {
                return i;
            }
        }
        return -1;
    }


    boolean isValideWord(String word) {
        int etat = 0;

        // Parcour du mot
        for (int i = 0; i < word.length(); i++) {


            // Get the actual char from the word
            System.out.print("state : ( " + (etat + 1) + ", " + word.charAt(i) + ")  = ");
            int acctualChar = charToInteger(word.charAt(i));

            // If the char value is -1 it's meen the acctual
            // letter is not in the alphabet
            if (acctualChar == -1) {
                System.out.println("Cacartere est hors de l'laphabet");
                return false;
            }

            // Get the the result of transition function
            etat = transitions[etat][charToInteger(word.charAt(i))];
            System.out.println("" + (etat + 1));

            if (etat == -1) {
                return false;
            }
        }

        System.out.println("---- " + (etat + 1));
        return finalState[etat];
    }

    public void printAutomate() {

        // Affiche les lettres dans une seulle ligne
        System.out.print("   ");
        for (int i = 0; i < aphabet.length; i++) {
            System.out.print(aphabet[i] + "  ");
        }


        // saut de ligne
        System.out.println("");

        for (int i = 0; i < transitions.length; i++) {
            System.out.print((i + 1) + "  ");
            for (int j = 0; j < transitions[i].length; j++) {
                System.out.print((transitions[i][j] + 1) + "  ");
            }
            System.out.println("");
        }
    }


    public static void printAutomate(char[] aphabet, int[][] transitions, boolean[] finalState) {

        // Affiche les lettres dans une seulle ligne
        System.out.print("   ");
        for (int i = 0; i < aphabet.length; i++) {
            System.out.print(aphabet[i] + "  ");
        }


        // saut de ligne
        System.out.println("");

        for (int i = 0; i < transitions.length; i++) {
            System.out.print((i + 1) + "  ");
            for (int j = 0; j < transitions[i].length; j++) {
                System.out.print((transitions[i][j] + 1) + "  ");
            }
            System.out.println("");
        }
    }

    /**
     * Test if an automate is set or not yet
     * @return
     */
    public boolean isEmpty() {
        return aphabet == null && transitions == null && finalState == null;
    }
}
