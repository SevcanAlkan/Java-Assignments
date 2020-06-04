package com.exercises;

import java.util.Scanner;

public class ExerciseOne {
    public void Run() {
        Scanner clavier = new Scanner(System.in);

        System.out.print("Enter the first value: ");
        int a = clavier.nextInt();

        System.out.print("Enter the second value: ");
        int b = clavier.nextInt();

        System.out.print("Enter the third value: ");
        int c = clavier.nextInt();

        System.out.println("The values entered are: a = " + a
                + ", b = " + b + " and c = " + c);

        System.out.println("Permutation: a ==> b, b ==> c, c ==> a");

        /*******************************************
         * Complete the program from here.
         *******************************************/

        int temp = 0;
        temp = b;
        b = a;
        a = c;
        c = temp;

        /*******************************************
         * Do not modify anything after this line.
         *******************************************/

        System.out.println("The permuted values are: a = " + a
                + ", b = " + b + " and c = " + c);
    }
}
