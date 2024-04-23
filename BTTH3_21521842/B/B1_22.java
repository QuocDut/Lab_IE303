package BTTH3_21521842.B;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class B1_22 {

    public static void main(String[] args) {
        String filePath = "student.txt";

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            System.out.println("Reading objects from file:");
            System.out.println(objectInputStream.readUTF());
            System.out.println(objectInputStream.readObject());
            System.out.println(objectInputStream.readObject());
            System.out.println(objectInputStream.readObject());
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading objects from file: " + e.getMessage());
        }
    }
}