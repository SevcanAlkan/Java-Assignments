package com.exercises;

import java.util.Scanner;

public class ExerciseFive {

    public void Run() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a (int):");
        int a = sc.nextInt();

        System.out.print("Enter b (int):");
        int b = sc.nextInt();

        System.out.print("Enter c (int):");
        int c = sc.nextInt();

        System.out.print("Enter x (double):");
        double x = sc.nextDouble();

        double firstSection = (double)(a+b)/2;

        double result = firstSection * Math.pow(x, 3.0) + Math.pow(((double)a+(double)b), 2) * Math.pow(x, 2) + a + b + c;
        System.out.println("The value of the polynomial is: " + result);
    }
}
