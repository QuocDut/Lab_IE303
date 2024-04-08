package BTTH3_21521842.B;

import java.io.FileInputStream;
import java.io.IOException;

public class B1_11 {

    public static void main(String[] args) {
        String filePath = "b1.txt";

        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            int byteValue;
            while ((byteValue = fileInputStream.read()) != -1) {
                System.out.printf("%5d: %c%n", byteValue, (char) byteValue);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
