package com.homework;

import java.util.Scanner;

/*
    Assignment 1 : conditional expressions
    Write a Java program that reads a number and indicates whether it is positive, negative, or zero, and is even or odd.
*/

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) {
	    boolean continueToWorking = true;
        Scanner sc = new Scanner(System.in); // Scanner using https://www.w3schools.com/java/java_user_input.asp
        String numberPositiveOrNegativeText = "";
        String numberEvenOrOddText = "";

	    while (continueToWorking) {
            try {
                System.out.println("Enter a whole number");

                // Error handling for the Scanner
                // https://stackoverflow.com/questions/2696063/java-util-scanner-error-handling
                while (!sc.hasNextInt()) {
                    System.out.println("number, please!");
                    sc.nextLine();
                }
                int number = sc.nextInt();
                sc.nextLine();

                // Check the number is negative, zero or positive
                if(number < 0) {
                    numberPositiveOrNegativeText = "negative";
                } else if (number == 0) {
                    numberPositiveOrNegativeText = "zero";
                } else if (number > 0) {
                    numberPositiveOrNegativeText = "positive";
                }

                // Check the number is even or odd https://stackoverflow.com/questions/7342237/check-whether-number-is-even-or-odd
                if ((number & 1) == 0) { // If is it even
                    numberEvenOrOddText = "even";
                } else { // Or it is odd
                    numberEvenOrOddText = "odd";
                }

                // Print the result of the number
                // https://stackoverflow.com/a/5762502/5756182 to set different line color.
                System.out.println(ANSI_YELLOW  + "The number is " + numberPositiveOrNegativeText + " and " + numberEvenOrOddText + ANSI_RESET);

                System.out.println("--------------------------------------------");
                System.out.println("Do you want to continue using the app, if you not please enter 'c'?");
                String userInputStr = sc.nextLine();

                if(userInputStr.toLowerCase().trim().equals("c")){
                    continueToWorking = false;
                }
                System.out.println("--------------------------------------------");

            } catch (Exception ex) {
                System.out.println("Something happened :(");
            }
        }
    }
}
