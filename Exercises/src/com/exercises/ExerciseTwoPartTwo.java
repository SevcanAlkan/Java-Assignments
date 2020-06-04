package com.exercises;

import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class ExerciseTwoPartTwo {
    Scanner clavier = new Scanner(System.in);

    public void Run(){
        System.out.print("Think of a character: Miss Rose, ");
        System.out.println("Professor Violet, the Colonel Mustard,");
        System.out.println("Reverend Olive or Mme Leblanc.\n");

        System.out.println("Please answer questions as true: yes, false: no");

        boolean hasMustaches = this.readAnswer("Does your character have mustaches?�");
        boolean hasGlasses = this.readAnswer("Does your character wear glasses?�");
        boolean hasHat = this.readAnswer("Does your character wear a hat?�");
        boolean isAMan = this.readAnswer("Is your character a man?�");

        System.out.print("==> The character you are thinking of is ");

        /*******************************************
         * Complete the program from here.
         *******************************************/

        // Miss Rose, Professor Violet, Colonel Mustard, Reverend Olive, Mr Leblanc
        // Only the Colonel Mustard has a mustache, wear glasses all except M Miss Rose
        // , and Professor Plum is the only one with a hat.

        if (hasMustaches && isAMan && !hasHat && hasGlasses) { //Colonel
            System.out.println("Colonel Mustard");
        } else if (!hasGlasses && !hasHat && !hasMustaches && !isAMan) { // Rose
            System.out.println("Miss Rose");
        } else if (hasHat && hasGlasses && !hasMustaches) { //Professor Plum
            System.out.println("Professor Plum");
        } else if (isAMan && hasGlasses && !hasMustaches && !hasHat) { //Mr Leblanc
            System.out.println("Mr Leblanc");
        } else if (isAMan && hasGlasses && !hasMustaches && !hasHat) { //Reverend Olive
            System.out.println("Reverend Olive");
        }  else {
            System.out.println("No any match!");
        }

        /*******************************************
         * Do not modify anything after this line.
         *******************************************/

        System.out.println();
    }

    private boolean readAnswer(String message) {
        System.out.print(message);

        while (!clavier.hasNextBoolean()) {
            System.out.println("Enter 'true' or 'false, please!");
            clavier.nextLine();
        }
        return clavier.nextBoolean();
    }

    private Hashtable<Integer, String> loadQuestions() {
        Hashtable<Integer, String> questions = new Hashtable<>();

        questions.put(1, "Does your character have mustaches?:");
        questions.put(2, "Does your character wear glasses?");
        questions.put(3, "Does your character wear a hat?");
        questions.put(4, "Is your character a man?");

        return questions;
    }

    private List<> loadMatchConditions() {

    }
}