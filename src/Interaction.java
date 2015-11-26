import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by ilyes on 23/11/15.
 */
public class Interaction {

    private static AutomateEtatFinal automate = new AutomateEtatFinal();
    private static Scanner key = new Scanner(System.in);

    public static void menu() {


        int choix;
        do {
            System.out.println("------- Finite State Automata --------");
            System.out.println("1. Defination de l'automate");
            System.out.println("2. Checking a Word");
            System.out.println("3. Print the Automate");
            System.out.println("99. Exit");

            System.out.print("Votre choix : ");
            choix = key.nextInt();

            switch (choix) {

                case 1:
                    // Definition de l'automate et de
                    // ces parametres
                    interactionCreationAutomate();
                    break;

                case 2:
                    // Cheking a word with the automata
                    // that was define in the first choice
                    interactionCheckWord();
                    break;
                case 3:
                    iteractionPrintAutomate();
                    break;
            }


        } while (choix != 99);


    }

    private static void interactionCheckWord() {
        String word = null;

        if (!automate.isEmpty()) {
            System.out.print("Saisir le mot a tester : ");
            word = key.next();

            if (automate.isValideWord(word)) {
                System.out.println("se mot appartient au langage definit par cette automate");
            } else {
                System.out.println("se mot né pas reconu par cette automate");
            }
        } else {
            System.out.println("l'automate na pas encore été definit");
        }

    }


    private static void iteractionPrintAutomate() {
        if (!automate.isEmpty()) {
            automate.printAutomate();
        } else {
            System.out.println("Warning : l'Automate né pas encore definit \n");
        }
    }

    private static void interactionCreationAutomate() {
        List<String> alphabetList = new ArrayList<>();
        char[] alphabet;
        int stateNumbers;
        int[][] states;
        boolean[] finalStates = null;


        inputAlphabet(alphabetList);


        // Saisi du nombre de state
        System.out.print("Qu'elle est le nombres d'etats : ");
        stateNumbers = key.nextInt();


        // Initialisation de tous les etats a false
        // sa veut dire que intialement il ni ya
        // aucun etats final
        finalStates = new boolean[stateNumbers];

        // Transfert des String lue a la
        // list de char
        // alphabet.size - 1 pour ne pas inclure
        // le dernier char qui est dans notre cas le -
        alphabet = new char[alphabetList.size() - 1];
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = alphabetList.get(i).charAt(0);
        }

        // Generation d'une matrice dont le nombres
        // de colone vaut le nombre de lettres
        // de l'alphabet et le nombre de ligne vaut
        // le nombre de ligne est le nombre des etats
        // init la matrice des states a - 1
        states = new int[stateNumbers][alphabet.length];
        for (int i = 0; i < states.length; i++) {
            for (int j = 0; j < states[i].length; j++) {
                states[i][j] = -1;
            }
        }

        // Lecture des etats final
        int indiceInput;
        System.out.println("Qu'elle sont les etats finaux : (-1 pour terminer)");
        do {
            indiceInput = key.nextInt();
            if (indiceInput > 0) {
                finalStates[indiceInput - 1] = true;
            }
        } while (indiceInput != -1);

        // Creation de l'automate
        automate = new AutomateEtatFinal(alphabet, states, finalStates);
        automate.printAutomate();


        // Lectures des transition (la fonctions de transition)
        int value;
        for (int i = 0; i < states.length; i++) {
            int j = 0;
            do {
                System.out.print("state ( " + (i + 1) + ", " + alphabet[j] + " ) = ");
                value = key.nextInt();

                // Testing the user input
                // before add in it into thr states array
                if (value >= 0 && value <= stateNumbers) {
                    // insertion into the states arrays
                    states[i][j] = value - 1;
                    j++;
                } else {
                    System.out.println("ERROR le nombre que vous avez entrer né pas un etas de cette automate");
                }
            } while (j < alphabet.length);
        }


        System.out.println("L'Automate a été parfaitement crée");

    }

    private static void inputAlphabet(List<String> alphabetList) {
        // Saisi de l'aplhabet par the user
        String input;
        System.out.println("Saisir l'alphabet : (-1 pour terminer)");

        // Partie input letters
        do {
            // Read a letter
            System.out.print(">> ");
            input = key.next();

            // Get the char from the String
            char actualCharInput = input.charAt(0);

            // Cheking if the input is a letter
            // if it's not so print an ERROR
            if ('a' <= actualCharInput && actualCharInput <= 'z' || Objects.equals(input, "-1")) {
                alphabetList.add(input);
            } else {
                System.out.println("ERROR please enter only letters");
            }

        } while (!Objects.equals(input, "-1"));
    }


}
