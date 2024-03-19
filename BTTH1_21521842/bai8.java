package BTTH1_21521842;

import java.util.Scanner;

public class bai8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = 99; // giới hạn giá trị của n
        int secretNumber = (int) (Math.random() * (n + 1)); // số bí mật :>

        int lowerBound = 0; // giới hạn dưới của phạm vi
        int upperBound = n; // giới hạn trên của phạm vi

        while (true) {
            System.out.print("Guess a number between " + lowerBound + " and " + upperBound + ": ");
            int guess = scanner.nextInt();

            if (guess == secretNumber) {
                System.out.println("Congratulations! You guessed the secret number.");
                break;
            } else if (guess < secretNumber) {
                lowerBound = guess + 1;
            } else {
                upperBound = guess - 1;
            }
            if (lowerBound > upperBound) {
                System.out.println("Sorry, you lost. The secret number was " + secretNumber + ".");
                break;
            }
        }

        scanner.close();
    }
}
