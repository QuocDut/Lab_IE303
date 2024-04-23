package BTTH3_21521842.B;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class B1_21 {

    public static void main(String[] args) {
        String filePath = "student.txt";

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeUTF("Hello Students and Pupils");
            objectOutputStream.writeObject(new Student("Bao", "Thy"));
            objectOutputStream.writeObject(new Pupil("MinhMang"));
            objectOutputStream.writeObject(new Student("Moutain", "M-TP"));
        } catch (IOException e) {
            System.err.println("Error writing objects to file: " + e.getMessage());
        }
    }
}