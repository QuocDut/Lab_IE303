package BTTH3_21521842.B;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class B1_13 {

    public static void main(String[] args) {
        String inputFilePath = "b1.txt";
        String outputFilePath = "b1_output.txt";

        try (FileInputStream fileInputStream = new FileInputStream(inputFilePath);
                FileOutputStream fileOutputStream = new FileOutputStream(outputFilePath)) {

            byte[] buffer = new byte[10];
            int bytesRead;

            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.err.println("Error reading or writing files: " + e.getMessage());
        }
    }
}