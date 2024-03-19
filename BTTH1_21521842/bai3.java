package BTTH1_21521842;

import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the lengths of the triangle sides:");
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            double c = scanner.nextDouble();
            double perimeter = a + b + c;
            double s = perimeter / 2;
            double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
            System.out.println("Perimeter = " + perimeter);
            System.out.println("Area = " + area);
        }
    }
}
