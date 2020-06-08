package com.exercises;

import com.exercises.common.GuessWhoCondition;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExerciseTwoPartTwo {
    Scanner clavier = new Scanner(System.in);
    List<GuessWhoCondition> conditions;

    public void Run(){
        System.out.print("Think of a character: Miss Rose, ");
        System.out.println("Professor Violet, the Colonel Mustard,");
        System.out.println("Reverend Olive or Mme Leblanc.\n");

        System.out.println("Please answer questions as true: yes, false: no");

        LoadConditions();
        Boolean hasMustaches, hasGlasses, hasHat, isAMan;
        GuessWhoCondition result;

        hasMustaches = this.readAnswer("Does your character have mustaches?:");
        //characterName = getMatch(hasMustaches, null, null, null);
        hasGlasses = this.readAnswer("Does your character wear glasses?:");
        hasHat = this.readAnswer("Does your character wear a hat?:");
        isAMan = this.readAnswer("Is your character a man?:");

        // Load questions
        // Ask a question
        // remove question from list
        // Check is there only one match
        // If matching with only one person write its name.
        // If not ask next question

        System.out.print("==> The character you are thinking of is ");

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

    private void LoadConditions() {
        conditions = new ArrayList<>();

        GuessWhoCondition colonel = new GuessWhoCondition("Colonel Mustard", true, true,false,true);
        GuessWhoCondition rose = new GuessWhoCondition("Miss Rose", true, true,false,true);
        GuessWhoCondition violet = new GuessWhoCondition("Professor Violet", true, true,false,true);
        GuessWhoCondition leblanc = new GuessWhoCondition("Ms Leblanc", true, true,false,true);
        GuessWhoCondition reverend = new GuessWhoCondition("Reverend Olive", true, true,false,true);

        conditions.add(colonel);
        conditions.add(rose);
        conditions.add(violet);
        conditions.add(leblanc);
        conditions.add(reverend);
    }

    private String getMatch(Boolean hasMustaches, Boolean isAMan, Boolean hasHat, Boolean hasGlasses) {
        if (hasMustaches && isAMan && !hasHat && hasGlasses) { //Colonel
            return "Colonel Mustard";
        } else if (!hasGlasses && !hasHat && !hasMustaches && !isAMan) { // Rose
            return "Miss Rose";
        } else if (hasHat && hasGlasses && !hasMustaches) { //Professor Violet
            return "Professor Violet";
        } else if (!isAMan && hasGlasses && !hasMustaches && !hasHat) { //Ms Leblanc
            return "Ms Leblanc";
        } else if (isAMan && hasGlasses && !hasMustaches && !hasHat) { //Reverend Olive
            return "Reverend Olive";
        }  else {
            return "No any match!";
        }
    }
}
