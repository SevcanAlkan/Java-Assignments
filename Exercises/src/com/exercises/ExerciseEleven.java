package com.exercises;

import java.util.Scanner;

public class ExerciseEleven {
    private static Scanner scanner =  new Scanner(System.in);

    public void Run() {
        // Ask the user for the number of students
        int numberStudents;
        System.out.print("Give the number of students: ");
        numberStudents = scanner.nextInt();
        double average = 0.0;
        //Initialize an array that can contain as many
        // of notes that of students
        double[] grades = new double [numberStudents];
        double totalGrade = 0;

        for (int i = 0; i < numberStudents; i++) {
            System.out.print("Grade of the " + (i + 1) + ". student: ");
            grades[i] = scanner.nextDouble();
            totalGrade += grades[i];
        }

        double classAvgGrade = totalGrade / numberStudents;

        System.out.println("Class avg grade is: " + classAvgGrade);

        for (int i = 0; i < numberStudents; i++) {
            System.out.println((i + 1) + ". student grade is: " + grades[i] + ", difference between class avg: " + grades[i] * 100 / classAvgGrade);
        }
    }
}
