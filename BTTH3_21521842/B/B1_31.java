package BTTH3_21521842.B;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class B1_31 {
    public static void main(String[] args) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("bufftest.txt"));
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter n: ");
            int n = scanner.nextInt();
            Random random = new Random();
            for (int i = 0; i < n; i++) {
                int num = random.nextInt();
                writer.write(String.valueOf(num));
                writer.newLine();
            }
            writer.close();
            scanner.close();
            System.out.println("Numbers have been written to bufftest.txt");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
