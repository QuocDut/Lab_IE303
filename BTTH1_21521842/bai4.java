package BTTH1_21521842;

import java.util.Scanner;

public class bai4 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Insert n: ");
            int n = scanner.nextInt();

            // Liệt kê ước của n
            System.out.print("Ước số của " + n + " là: ");
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();

            // Kiểm tra số chữ số của n
            int numDigits = String.valueOf(n).length();
            System.out.println(n + " có " + numDigits + " chữ số.");

            // Kiểm tra n có phải số đối xứng hay không
            boolean isPalindrome = isPalindrome(n);
            if (isPalindrome) {
                System.out.println(n + " là số đối xứng.");
            } else {
                System.out.println(n + " không là số đối xứng.");
            }

            // Kiểm tra n có phải số chính phương hay không
            boolean isPerfectSquare = isPerfectSquare(n);
            if (isPerfectSquare) {
                System.out.println(n + " là số chính phương.");
            } else {
                System.out.println(n + " không là số chính phương.");
            }
        }
    }

    // Hàm kiểm tra số đối xứng
    public static boolean isPalindrome(int num) {
        String numStr = String.valueOf(num);
        return numStr.equals(new StringBuilder(numStr).reverse().toString());
    }

    // Hàm kiểm tra số chính phương
    public static boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
