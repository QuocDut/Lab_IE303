//Từ Quốc Anh -21521842 

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Tạo một lớp Animal
class Animal {
    private String name;
    private String description;
    private String sound;

    // Khởi tạo một đối tượng Animal
    public Animal(String name, String description, String sound) {
        this.name = name;
        this.description = description;
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSound() {
        return sound;
    }
}

// Tạo một lớp Cage
class Cage {
    private String cageCode;
    private List<Animal> animals;

    public Cage(String cageCode) {
        this.cageCode = cageCode;
        this.animals = new ArrayList<>();
    }

    public String getCageCode() {
        return cageCode;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}

// Tạo một lớp Zoo
class Zoo {
    private List<Cage> cages;

    public Zoo() {
        this.cages = new ArrayList<>();
    }

    public void addCage(Cage cage) {
        cages.add(cage);
    }

    public void removeCage(String cageCode) {
        cages.removeIf(cage -> cage.getCageCode().equals(cageCode));
    }

    public List<Cage> getCages() {
        return cages;
    }
}

//
public class bai3 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // Khởi tạo một đối tượng Zoo
        Zoo zoo = new Zoo();

        Scanner scanner = new Scanner(System.in);
        // Hiển thị menu
        boolean running = true;
        while (running) {
            System.out.println("1. Add animal to cage");
            System.out.println("2. Remove animal from cage");
            System.out.println("3. Add cage");
            System.out.println("4. Remove cage");
            System.out.println("5. Display information");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            // tạo một dòng trống để đọc chuỗi kế tiếp
            switch (choice) {
                case 1: // Thêm Animal vào cage
                    System.out.print("Enter animal name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter animal description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter animal sound: ");
                    String sound = scanner.nextLine();
                    Animal animal = new Animal(name, description, sound);
                    System.out.print("Enter cage code: ");
                    String cageCode = scanner.nextLine();
                    Cage cage = findcage(zoo, cageCode);
                    if (cage != null) {
                        cage.addAnimal(animal);
                        System.out.println("Animal added to cage successfully.");
                    } else {
                        System.out.println("cage not found.");
                    }
                    break;
                case 2: // Xóa Animal khỏi cage
                    System.out.print("Enter animal name: ");
                    String animalName = scanner.nextLine();
                    System.out.print("Enter cage code: ");
                    String cageCodeToRemove = scanner.nextLine();
                    Cage cageToRemove = findcage(zoo, cageCodeToRemove);
                    if (cageToRemove != null) {
                        Animal animalToRemove = findAnimal(cageToRemove, animalName);
                        if (animalToRemove != null) {
                            cageToRemove.removeAnimal(animalToRemove);
                            System.out.println("Animal removed from cage successfully.");
                        } else {
                            System.out.println("Animal not found in cage.");
                        }
                    } else {
                        System.out.println("cage not found.");
                    }
                    break;
                case 3: // Thêm cage
                    System.out.print("Enter cage code: ");
                    String newcageCode = scanner.nextLine();
                    Cage newcage = new Cage(newcageCode);
                    zoo.addCage(newcage);
                    System.out.println("cage added successfully.");
                    break;
                case 4: // Xóa cage
                    System.out.print("Enter cage code: ");
                    String cageCodeToRemove2 = scanner.nextLine();
                    zoo.removeCage(cageCodeToRemove2);
                    System.out.println("cage removed successfully.");
                    break;
                case 5: // Hiển thị thông tin
                    displayInformation(zoo);
                    break;
                case 6: // Thoát
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    // Tìm kiếm cage trong zoo
    private static Cage findcage(Zoo zoo, String cageCode) {
        for (Cage cage : zoo.getCages()) {
            if (cage.getCageCode().equals(cageCode)) {
                return cage;
            }
        }
        return null;
    }

    // Tìm kiếm Animal trong cage
    private static Animal findAnimal(Cage cage, String animalName) {
        for (Animal animal : cage.getAnimals()) {
            if (animal.getName().equals(animalName)) {
                return animal;
            }
        }
        return null;
    }

    // Hiển thị thông tin
    private static void displayInformation(Zoo zoo) {
        for (Cage cage : zoo.getCages()) {
            System.out.println("cage Code: " + cage.getCageCode());
            for (Animal animal : cage.getAnimals()) {
                System.out.println("Animal Name: " + animal.getName());
                System.out.println("Description: " + animal.getDescription());
                System.out.println("Sound: " + animal.getSound());
                System.out.println();
            }
        }
    }
}
// 🦁🐯🐶🐱🐬🐊🦉🦚