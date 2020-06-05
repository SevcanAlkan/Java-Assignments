package com.exercises;

import java.util.Scanner;

public class ExerciseFour {

    public void Run() {
        Scanner sc = new Scanner(System.in);

        double cheeseAmountBase = 800.0;
        double waterAmountBase = 2.0;
        double garlicAmountBase = 2.0;
        double breadAmountBase = 400.0;


        System.out.print("Enter the number of people invited to the fondue:");
        int count = sc.nextInt();

        double cheeseAmount = cheeseAmountBase * count / 4;
        double waterAmount = waterAmountBase * count / 4;
        double garlic = garlicAmountBase * count / 4;
        double bread = breadAmountBase * count / 4;

        System.out.println("To make a Friborg fondue for " + count + " people, you will need:");

        System.out.println("- " + cheeseAmount + " gr of Vacherin fribourgeois");
        System.out.println("- " + waterAmount + " dl of water");
        System.out.println("- " + garlic + " clove (s) of garlic");
        System.out.println("- " + bread + " gr of bread");
        System.out.println("- pepper at will");
    }
}
