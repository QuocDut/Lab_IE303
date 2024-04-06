import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Từ Quốc Anh - 21521842

class Student {
    private int studentId;
    private String fullName;
    private float calculusGrade;
    private float physicsGrade;
    private float programmingGrade;
    private float averageGrade;

    /**
     * Phương thức khởi tạo cho đối tượng Student.
     *
     * @param studentId        the student's ID
     * @param fullName         the student's full name
     * @param calculusGrade    the student's calculus grade
     * @param physicsGrade     the student's physics grade
     * @param programmingGrade the student's programming grade
     */
    public Student(int studentId, String fullName, float calculusGrade, float physicsGrade, float programmingGrade) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.calculusGrade = calculusGrade;
        this.physicsGrade = physicsGrade;
        this.programmingGrade = programmingGrade;
        this.averageGrade = calculateAverageGrade();
    }

    /**
     * trả về ID của sinh viên.
     *
     * @return the student's ID
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * trả về tên đầy đủ của sinh viên.
     *
     * @return the student's full name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * trả về điểm toán của sinh viên.
     *
     * @return the student's calculus grade
     */
    public float getCalculusGrade() {
        return calculusGrade;
    }

    /**
     * Điểm lý
     *
     * @return the student's physics grade
     */
    public float getPhysicsGrade() {
        return physicsGrade;
    }

    /**
     * điểm code của sinh viên.
     *
     * @return the student's programming grade
     */
    public float getProgrammingGrade() {
        return programmingGrade;
    }

    /**
     * trả về điểm trung bình của sinh viên.
     *
     * @return the student's average grade
     */
    public float getAverageGrade() {
        return averageGrade;
    }

    /**
     * tính và trả về điểm trung bình của sinh viên.
     *
     * @return the student's average grade
     */
    private float calculateAverageGrade() {
        return (calculusGrade + physicsGrade + programmingGrade) / 3;
    }

    /**
     * trả về một chuỗi biểu diễn của sinh viên.
     *
     * @return a string representation of the student
     */
    @Override
    public String toString() {
        return "Student ID: " + studentId +
                ", Full Name: " + fullName +
                ", Average Grade: " + String.format("%.2f", averageGrade);
    }
}

public class bai1 {
    public static void main(String[] args) {
        // Tạo danh sách sinh viên
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "John Tran", 8.5f, 9.0f, 9.5f));
        students.add(new Student(2, "Jane Nguyen", 7.5f, 8.0f, 9.0f));
        students.add(new Student(3, "David Jack 5tr", 9.0f, 9.5f, 8.0f));
        students.add(new Student(4, "Antholy Davis", 8.0f, 8.5f, 9.5f));

        // danh sách sinh viên nhận học bổng
        System.out.println("Students who receive scholarships:");
        for (Student student : students) {
            if (student.getAverageGrade() >= 8.0f && student.getProgrammingGrade() >= 9.0f) {
                System.out.println(student);
            }
        }

        // sắp xếp danh sách sinh viên theo điểm trung bình giảm dần
        Collections.sort(students, Comparator.comparing(Student::getAverageGrade).reversed());

        // in ra danh sách sinh viên có điểm trung bình cao nhất
        System.out.println("\nStudents with the highest average grade:");
        float highestAverageGrade = students.get(0).getAverageGrade();
        for (Student student : students) {
            if (student.getAverageGrade() == highestAverageGrade) {
                System.out.println(student);
            } else {
                break;
            }
        }

        // top 10 sinh viên có điểm trung bình cao nhất~
        System.out.println("\nTop 10 students with the highest grades:");
        int count = 0;
        for (Student student : students) {
            System.out.println(student);
            count++;
            if (count == 10) {
                break;
            }
        }
    }
}
