package lt.vcd;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        // 1. Read matrix elements from input
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // 2. Replace diagonal elements with 0
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 0;          // Main diagonal (row == col)
            matrix[i][n - 1 - i] = 0;  // Secondary diagonal (row + col == n - 1)
        }

        // 3. Print the modified matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + (j == n - 1 ? "" : " "));
            }
            System.out.println();
        }

        scanner.close();
    }
}