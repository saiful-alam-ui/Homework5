package lt.vcd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }

        int numSubjects = scanner.nextInt();
        int numStudents = scanner.nextInt();

        // 2D array to store grades: grades[studentIndex][subjectIndex]
        int[][] grades = new int[numStudents][numSubjects];

        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < numSubjects; j++) {
                grades[i][j] = scanner.nextInt();
            }
        }

        double[] studentAverages = new double[numStudents];
        double highestAverage = -1.0;
        double sumOfAllAverages = 0.0;

        List<Integer> studentsWithFails = new ArrayList<>();

        // 1. Calculate each student's average and check for failing grades (< 5)
        for (int i = 0; i < numStudents; i++) {
            int studentSum = 0;
            boolean hasFailedGrade = false;

            for (int j = 0; j < numSubjects; j++) {
                int grade = grades[i][j];
                studentSum += grade;
                if (grade < 5) {
                    hasFailedGrade = true;
                }
            }

            double avg = (double) studentSum / numSubjects;
            studentAverages[i] = avg;
            sumOfAllAverages += avg;

            if (avg > highestAverage) {
                highestAverage = avg;
            }

            if (hasFailedGrade) {
                studentsWithFails.add(i + 1); // 1-based student number
            }
        }

        // 2. Print each student's average
        System.out.println("Student averages:");
        for (int i = 0; i < numStudents; i++) {
            // Formats to 2 decimal places if non-integer, or whole number if exact
            if (studentAverages[i] == (long) studentAverages[i]) {
                System.out.println((long) studentAverages[i]);
            } else {
                System.out.printf("%.2f%n", studentAverages[i]);
            }
        }
        System.out.println();

        // 3. Print group average
        double groupAverage = sumOfAllAverages / numStudents;
        System.out.println("Group average:");
        if (groupAverage == (long) groupAverage) {
            System.out.println((long) groupAverage);
        } else {
            System.out.printf("%.2f%n", groupAverage);
        }
        System.out.println();

        // 4. Print highest-performing student(s)
        System.out.println("Highest-performing student:");
        for (int i = 0; i < numStudents; i++) {
            if (Math.abs(studentAverages[i] - highestAverage) < 1e-9) {
                System.out.println(i + 1);
            }
        }
        System.out.println();

        // 5. Print students with at least one grade below 5
        System.out.println("Students with at least one grade below 5:");
        if (studentsWithFails.isEmpty()) {
            System.out.println("None");
        } else {
            for (int studentNum : studentsWithFails) {
                System.out.println(studentNum);
            }
        }

        scanner.close();
    }
}