package com.exercises;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ExerciseThree {

    public void Run (){
        DecimalFormat df = new DecimalFormat("#0.000");
        Scanner keyb = new Scanner(System.in);

        int InitialYear = 2011;        // initial year
        int targetYear = 0;
        double GrowthRate  = 1.2;     // growth rate  in %
        double InitialPopulation = 7.0; // initial population, in milliard humans

        double CurrentPopulation = InitialPopulation; // word population for the current year
        int CurrentYear = InitialYear;              // year for calculation

        System.out.println("====---- PART 1 ----====");
        System.out.println("Population in " + CurrentYear + " : " + df.format(CurrentPopulation));

        /*******************************************
         * Complete the program from here.
         *******************************************/

        // ===== PART 1 =====
        // use this instruction to ask your question:
        System.out.print("Which year (> " + InitialYear + ") ? ");
        while (!keyb.hasNextInt()) {
            System.out.println("Enter year, please!");
            keyb.nextLine();

            targetYear = keyb.nextInt();
            while (targetYear <= InitialYear) {
                System.out.println("Final year have to greater then initial year!");
                keyb.nextLine();
            }
        }

        if(targetYear == 0) {
            targetYear = keyb.nextInt();
        }

        double rate = 0;
        rate = (InitialPopulation * Math.exp(GrowthRate/100)) - InitialPopulation;

        for (int y = InitialYear + 1; y <= targetYear; y++) {
            CurrentPopulation += rate;
        }

        System.out.print("Population in " + targetYear + ": " + df.format(CurrentPopulation));

        // ===== PART 2 =====
        System.out.println("\n====---- PART 2 ----====");
        CurrentPopulation = InitialPopulation;

        System.out.print("Hom many billions (> " + InitialPopulation + ") ? ");

        double targetPopulation = 0.0;
        while (!keyb.hasNextDouble()) {
            System.out.println("Enter year, please!");
            keyb.nextLine();

            targetPopulation = keyb.nextDouble();
            while (targetPopulation <= InitialPopulation) {
                System.out.println("Final population have to greater then initial population!");
                keyb.nextLine();
            }
        }

        if(targetPopulation == 0.0) {
            targetPopulation = keyb.nextDouble();
        }

        while (CurrentPopulation < targetPopulation) {
            rate = (InitialPopulation * Math.exp(GrowthRate/100)) - InitialPopulation;

            CurrentPopulation += rate;
            CurrentYear++;

            System.out.println("Population in " + CurrentYear + ": " + df.format(CurrentPopulation));
        }

        // ===== PART 3 =====
        System.out.println("\n====---- PART 3 ----====");
        CurrentPopulation = InitialPopulation;
        CurrentYear = InitialYear;
        int stepPop = (int)InitialPopulation;

        while (CurrentYear < targetYear) {

            if (stepPop == (int)CurrentPopulation / 2) {
                stepPop = (int)CurrentPopulation;
                GrowthRate = GrowthRate / 2;
            }

            double popRate = (InitialPopulation * Math.exp(GrowthRate/100)) - InitialPopulation;

            CurrentPopulation += popRate;
            CurrentYear++;

            System.out.println("Population in " + CurrentYear + ": " + df.format(CurrentPopulation)+ " grow rate:" + df.format(GrowthRate));
        }

        /*******************************************
         * Do not modify anything after this line.
         *******************************************/
    }
}
