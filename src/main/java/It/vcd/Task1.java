package lt.vcd;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        int maxRadius = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int currentRadius = scanner.nextInt();
            if (currentRadius > maxRadius) {
                maxRadius = currentRadius;
                count = 1;
            } else if (currentRadius == maxRadius) {
                count++;
            }
        }

        System.out.println(maxRadius + " - " + count);

        scanner.close();
    }
}