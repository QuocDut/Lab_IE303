
public class B2 {
  public void Bai1(Scanner scanner) {
    String filePath = "A2.txt";
    System.out.println("Bai 1: \n------");
    System.out.print("Enter number of elements: ");
    int n = scanner.nextInt();
    try {

      // a) Input array A and write to A2.txt
      {
        String[] A = new String[n];
        for (int i = 0; i < n; ++i) {
          System.out.print("A[" + i + "]: ");
          A[i] = scanner.next();
        }

        Writer writer = new FileWriter(filePath);
        for (int i = 0; i < n; ++i) {
          writer.write(A[i]);
          writer.write(System.lineSeparator());
        }
        writer.close();
      }

      // b) Read array A from A2.txt
      {

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        int iterator = 0;
        String A[] = new String[n];
        while ((line = reader.readLine()) != null) {
          System.out.println(line);
          A[iterator] = line;
          ++iterator;
        }
        reader.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void Bai2(Scanner scanner) {
    String filePath = "sinhvien.txt";
    System.out.println("Bai 2: \n------");

    // a) Input n students to sinhvien.txt
    {
      System.out.print("Enter the number of students: ");
      int n = scanner.nextInt();

      List<SinhVien> students = new ArrayList<SinhVien>();

      for (int i = 0; i < n; ++i) {
        System.out.println("Enter information for student " + (i + 1) + ":");
        System.out.print("MSSV: ");
        String mssv = scanner.next();
        scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Class: ");
        String studentClass = scanner.next();
        scanner.nextLine();
        System.out.print("Scores: ");
        String scores = scanner.nextLine();

        SinhVien student = new SinhVien(mssv, name, studentClass, scores);
        students.add(student);
      }

      try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
        for (SinhVien student : students) {
          outputStream.writeObject(student);
        }
      } catch (IOException e) {
        System.out.println("Error writing to file: " + e.getMessage());
      }
      System.out.println("\n");
    }

    // b) Delete student with input mssv from sinhvien.txt
    {
      System.out.print("Enter the student ID to delete: ");
      String studentID = scanner.next();

      List<SinhVien> students = new ArrayList<SinhVien>();

      try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
        SinhVien student;
        while ((student = (SinhVien) inputStream.readObject()) != null) {
          if (student.getMSSV().equals(studentID)) {
            continue;
          }
          students.add(student);
        }
      } catch (EOFException e) {
        // Reached end of file
      } catch (IOException | ClassNotFoundException e) {
        System.out.println("Error reading from file: " + e.getMessage());
      }

      try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
        for (SinhVien student : students) {
          outputStream.writeObject(student);
        }
      } catch (IOException e) {
        System.out.println("Error writing to file: " + e.getMessage());
      }

      System.out.println("File after deleted:\n------");
      try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
        SinhVien student;
        while ((student = (SinhVien) inputStream.readObject()) != null) {
          System.out.println(String.join(", ", "MSSV: " + student.getMSSV(), "Name: " + student.getName(),
              "Class: " + student.getStudentClass(), "Scores: " +
                  student.getScores()));
        }
      } catch (EOFException e) {
        // Reached end of file
      } catch (IOException | ClassNotFoundException e) {
        System.out.println("Error reading from file: " + e.getMessage());
      }
      System.out.println("\n");
    }
  }

  public void Bai3(Scanner scanner) {
    String filePath = "btvn.txt";
    System.out.println("Bai 3: \n------");

    // a) Write the matrix to "btvn.txt"
    {
      System.out.print("Enter number of rows and columns: ");
      int n = scanner.nextInt();
      int m = scanner.nextInt();

      double[][] matrix = new double[n][m];
      Random random = new Random();

      try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
        for (int i = 0; i < n; ++i) {
          for (int j = 0; j < m; ++j) {
            matrix[i][j] = random.nextDouble();
            writer.print(matrix[i][j] + " ");
          }
          writer.println();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    // b) Read the matrix from "btvn.txt" and print it to the screen
    {
      try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        System.out.println("Matrix:");
        while ((line = reader.readLine()) != null) {
          String[] values = line.split(" ");
          System.out.println(String.join(" ", values));
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public B2(Scanner scanner) {
    System.out.println("B2. \n------------\n");
    Bai1(scanner);
    Bai2(scanner);
    Bai3(scanner);
  }
}
