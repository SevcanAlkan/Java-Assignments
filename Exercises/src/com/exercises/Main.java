package com.exercises;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean continueToWorking = true;
        Scanner sc = new Scanner(System.in); // Scanner using https://www.w3schools.com/java/java_user_input.asp
        Double number = 0.0;

        while (continueToWorking) {
            try {
                printOptions();

                // Error handling for the Scanner
                // https://stackoverflow.com/questions/2696063/java-util-scanner-error-handling
                while (!sc.hasNextInt() && !sc.hasNextDouble()) {
                    System.out.println("Enter a number, please!");
                    sc.nextLine();
                }
                number = sc.nextDouble();
                sc.nextLine();

                switch (number.intValue()) {
                    case 0:
                        continueToWorking = false;
                        break;
                    case 1:
                        ExerciseOne runOne = new ExerciseOne();
                        runOne.Run();
                        break;
                    case 2:
                        ExerciseTwoPartOne runTwoPartOne = new ExerciseTwoPartOne();
                        runTwoPartOne.Run();
                        break;
                    case 3:
                        ExerciseTwoPartTwo runTwoPartTwo = new ExerciseTwoPartTwo();
                        runTwoPartTwo.Run();
                        break;
                    case 4:
                        ExerciseThree runThree = new ExerciseThree();
                        runThree.Run();
                        break;
                    case 5:
                        ExerciseFour runFour = new ExerciseFour();
                        runFour.Run();
                        break;
                    case 6:
                        ExerciseFive runFive = new ExerciseFive();
                        runFive.Run();
                        break;
                    case 7:
                        ExerciseSix runSix = new ExerciseSix();
                        runSix.Run();
                        break;
                    case 8:
                        ExerciseEleven runEleven = new ExerciseEleven();
                        runEleven.Run();
                        break;
                    default:
                        System.out.println("Option not found!");
                        break;
                }

            } catch (Exception ex) {
                System.out.println("Something happened :(");
            }
        }
    }

    private static void printOptions()
    {
        System.out.println("--------------------------------------------");
        System.out.println("Select an exercise to run;");

        System.out.println("(1) Exchange of three values Data");
        System.out.println("(2) Guess who");
        System.out.println("(3) Guess who in three questions");
        System.out.println("(4) Population");
        System.out.println("(5) Fondue");
        System.out.println("(6) Expression ");
        System.out.println("(7) variables \\ operators and expressions");
        System.out.println("(8) Calculation of averages");

        System.out.println("(0) close the app");
        System.out.println("--------------------------------------------");
    }
}
