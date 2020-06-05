package com.exercises;

import java.util.Scanner;

public class ExerciseSix {
    public void Run() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Comb lthough have you received money ( EUR )? ");
        double totalAmount = sc.nextDouble();

        double bookAndSuppliesAmount = totalAmount * 0.75;
        double usableAmount = (bookAndSuppliesAmount * 0.25) * 0.25;
        System.out.println("Book and Supplies: " + bookAndSuppliesAmount + "euro");

        double coffeePrice = 1.2;
        double flashInformaticPrice = 3;
        double metroTicketPrice = 2;

        double unUsedAmount = 0;
        int coffeeAmount = (int)(usableAmount / coffeePrice);
        unUsedAmount = usableAmount % coffeePrice;

        int flashInformaticAmount = (int)(usableAmount / flashInformaticPrice);
        unUsedAmount += usableAmount % flashInformaticPrice;

        int metroTicketAmount = (int)(usableAmount / metroTicketPrice);
        unUsedAmount += usableAmount % metroTicketPrice;

        System.out.println(coffeeAmount + " coffees");
        System.out.println(flashInformaticAmount + " issues of Flash Informatique");
        System.out.println(metroTicketAmount + " metro tickets");

        System.out.println("and you will have " + unUsedAmount + " euros left for white roses.");
    }
}
