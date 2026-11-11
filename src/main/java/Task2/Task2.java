package lt.vcd;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        int[] residents = new int[n];

        // 1. Read all input data into an array first
        for (int i = 0; i < n; i++) {
            residents[i] = scanner.nextInt();
        }

        int totalResidents = 0;
        int leftSideTotal = 0;
        int leftSideCount = 0;
        int rightSideTotal = 0;
        int rightSideCount = 0;

        // 2. Perform calculations using stored data
        for (int i = 0; i < n; i++) {
            int houseNumber = i + 1; // Houses are numbered 1 to n
            int count = residents[i];

            totalResidents += count;

            if (houseNumber % 2 != 0) {
                // Odd numbers are on the left side
                leftSideTotal += count;
                leftSideCount++;
            } else {
                // Even numbers are on the right side
                rightSideTotal += count;
                rightSideCount++;
            }
        }

        // 3. Output results
        System.out.println("Total residents: " + totalResidents);
        System.out.println("Left side residents: " + leftSideTotal);
        System.out.println("Right side residents: " + rightSideTotal);

        if (leftSideCount > 0) {
            double leftAvg = (double) leftSideTotal / leftSideCount;
            System.out.printf("Left side average: %.2f\n", leftAvg);
        } else {
            System.out.println("Left side average: N/A");
        }

        if (rightSideCount > 0) {
            double rightAvg = (double) rightSideTotal / rightSideCount;
            System.out.printf("Right side average: %.2f\n", rightAvg);
        } else {
            System.out.println("Right side average: N/A");
        }

        scanner.close();
    }
}