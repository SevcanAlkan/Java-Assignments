package com.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

/*
Let I = [2.3 [U] 0.1] U [-10, -2] in the set of reals.
Write the Intervalle.java program which:
1.	asks the user to enter an actual;
2.	records the user's response in a variable x of real type;
3.	tests the membership of x in the set I and displays the message " x belongs to I " if this is the case, and " x does not belong to I " otherwise. This test must use only the relational operators < and == . All logical operators are, however, authorized.
Note that, in elementary logic, " no (A and B) " can also be written " ( not A) or ( not B) ".
Test your program with the values -20, -10, -2, -1, 0, 1, 1.5, 2, 3 and 4.
 */

// [2.3 [U] 0.1] U [-10, -2]  ==  [2.3, 2, 1, 0.1, -10, -2]
public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        boolean continueToWorking = true;
        AtomicBoolean isBelongsToI = new AtomicBoolean(false);
        Scanner sc = new Scanner(System.in); // Scanner using https://www.w3schools.com/java/java_user_input.asp
        List<Double> I = new ArrayList<>();
        Double[] tempArray = {2.3, 2.0, 1.0, 0.1, -10.0, -2.0};
        I.addAll(Arrays.asList(tempArray));
        tempArray = null;
        Double number = null;

        while (continueToWorking) {
            try {
                System.out.println("Enter a decimal number");

                // Error handling for the Scanner
                // https://stackoverflow.com/questions/2696063/java-util-scanner-error-handling
                while (!sc.hasNextInt() && !sc.hasNextDouble()) {
                    System.out.println("decimal number, please!");
                    sc.nextLine();
                }
                number = sc.nextDouble();
                sc.nextLine();

                // Check and than print the result
                Double finalNumber = number;
                I.forEach(member -> {
                    if (isBelongsToI.get() == false && Double.compare(finalNumber, member) == 0) {
                        isBelongsToI.set(true);
                    }
                });

                if (isBelongsToI.get()) {
                    System.out.println(ANSI_YELLOW + "X belongs to I" + ANSI_RESET); // https://stackoverflow.com/a/5762502/5756182 to set different line color.
                } else {
                    System.out.println(ANSI_YELLOW + "X does not belong to I" + ANSI_RESET); // https://stackoverflow.com/a/5762502/5756182 to set different line color.
                }

                System.out.println("--------------------------------------------");
                System.out.println("Do you want to continue using the app, if you not please enter 'c'?");
                String userInputStr = sc.nextLine();

                if (userInputStr.toLowerCase().trim().equals("c")) {
                    continueToWorking = false;
                } else {
                    isBelongsToI.set(false);
                    number = null;
                }
                System.out.println("--------------------------------------------");

            } catch (Exception ex) {
                System.out.println("Something happened :(");
            }
        }
    }
}
