import com.sun.xml.internal.bind.v2.TODO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by ilyes on 23/11/15.
 */
public class Interaction {

    private static AutomateEtatFinal automate;
    private static Scanner key = new Scanner(System.in);

    public static void menu() {


        int choix;
        do {
            System.out.println("------- Finite State Automata --------");
            System.out.println("1. Defination de l'automate");
            System.out.println("2. Checking a Word");
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
                    break;
            }


        } while (choix != 99);


    }

    private static void interactionCreationAutomate() {
        List<String> alphabetList = new ArrayList<>();
        char[] alphabet;
        int stateNumbers;
        int[][] states;
        boolean[] finalStates;


        // Saisi de l'aplhabet par the user
        String input;
        System.out.println("Saisir l'alphabet : ");

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

        // TODO: 23/11/15 generation d'une matrice qui est corespond au nombre de letters
        
    }


}
