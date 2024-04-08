package BTTH3_21521842.B;

import java.io.FileOutputStream;
import java.io.IOException;

public class B1_12 {

    public static void main(String[] args) {
        String filePath = "b2.txt";
        String content = "We are the best group";

        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            for (char c : content.toCharArray()) {
                fileOutputStream.write(c);
            }
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}