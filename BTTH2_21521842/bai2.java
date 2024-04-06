import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.awt.Point;

//Từ Quôc Anh - 21521842

@SuppressWarnings("unused")
abstract class Diem {
    protected double x;
    protected double y;

    public Diem(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract void input();

    public abstract void output();

    public abstract void translate(double dx, double dy);

    public abstract void scale(double factor);

    public abstract void rotate(double angle);

    public abstract double calculateArea();

    public abstract double calculatePerimeter();
}

class Polygon {
    protected Diem[] vertices;

    public Polygon(Diem[] vertices) {
        this.vertices = vertices;
    }

    public void input() {
        for (int i = 0; i < vertices.length; i++) {
            System.out.println("Enter coordinates for vertex " + (i + 1) + ":");
            vertices[i].input();
        }
    }

    public void output() {
        for (int i = 0; i < vertices.length; i++) {
            System.out.print("Vertex " + (i + 1) + ": ");
            vertices[i].output();
        }
    }

    public void translate(double dx, double dy) {
        for (int i = 0; i < vertices.length; i++) {
            vertices[i].translate(dx, dy);
        }
    }

    public void scale(double factor) {
        for (int i = 0; i < vertices.length; i++) {
            vertices[i].scale(factor);
        }
    }

    public void rotate(double angle) {
        for (int i = 0; i < vertices.length; i++) {
            vertices[i].rotate(angle);
        }
    }

    public double calculateArea() {
        // kiểu trả về phụ thuộc vào loại đa giác cụ thể
        return 0.0;
    }

    public double calculatePerimeter() {
        // kiểu trả về phụ thuộc vào loại đa giác cụ thể
        return 0.0;
    }
}

class Triangle extends Polygon {
    public Triangle(Diem[] vertices) {
        super(vertices);
    }

    @Override
    public double calculateArea() {
        // kiểu trả về phụ thuộc vào loại đa giác cụ thể
        return 0.0;
    }

    @Override
    public double calculatePerimeter() {
        // kiểu trả về phụ thuộc vào loại đa giác cụ thể
        return 0.0;
    }
}

class Quadrilateral extends Polygon {
    public Quadrilateral(Diem[] vertices) {
        super(vertices);
    }

    @Override
    public double calculateArea() {
        // kiể trả về phụ thuộc vào loại đa giác cụ thể
        return 0.0;
    }

    @Override
    public double calculatePerimeter() {

        return 0.0;
    }
}

class Parallelogram extends Quadrilateral {
    public Parallelogram(Diem[] vertices) {
        super(vertices);
    }

    // Phương thức và ghi đè bổ sung cụ thể cho hình bình hành
}

class Rectangle extends Parallelogram {
    public Rectangle(Diem[] vertices) {
        super(vertices);
    }

    // Phương pháp và ghi đè bổ sung cụ thể cho hình chữ nhật
}

class Square extends Rectangle {
    public Square(Diem[] vertices) {
        super(vertices);
    }

    // phương pháp và ghi đè bổ sung cụ thể cho hình vuông
}

class ConcreteDiem extends Diem {
    public ConcreteDiem(double x, double y) {
        super(x, y);
    }

    @Override
    public void input() {
        // cung cấp phương thức triển khai
    }

    @Override
    public void output() {
        // cung cấp phương thức triển khai
    }

    @Override
    public void translate(double dx, double dy) {
        // Tự động kế thừa từ lớp cha
        throw new UnsupportedOperationException("Unimplemented method 'translate'");
    }

    @Override
    public void scale(double factor) {
        // Tự động kế thừa từ lớp cha
        throw new UnsupportedOperationException("Unimplemented method 'scale'");
    }

    @Override
    public void rotate(double angle) {
        // Tự động kế thừa từ lớp cha
        throw new UnsupportedOperationException("Unimplemented method 'rotate'");
    }

    @Override
    public double calculateArea() {
        // tự động kế thừa từ lớp cha
        throw new UnsupportedOperationException("Unimplemented method 'calculateArea'");
    }

    @Override
    public double calculatePerimeter() {
        // tự động kế thừa từ lớp cha
        throw new UnsupportedOperationException("Unimplemented method 'calculatePerimeter'");
    }

    // Còn các phương thức khác????
}

public class bai2 {
    /**
     * @param args
     */
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices for the polygon:");
        int numVertices = scanner.nextInt();

        Diem[] vertices = new Diem[numVertices];

        System.out.println("Enter the type of polygon (triangle, quadrilateral, parallelogram, rectangle, square):");
        String polygonType = scanner.next();

        switch (polygonType) {
            case "triangle":
                if (numVertices != 3) {
                    System.out.println("Invalid number of vertices for a triangle.");
                    return;
                }
                vertices = new Diem[3];
                for (int i = 0; i < 3; i++) {
                    vertices[i] = new ConcreteDiem(0, 0);
                }
                Triangle triangle = new Triangle(vertices);
                triangle.input();
                triangle.output();
                // biểu diễn các phép biến đổi khác trên tam giác
                break;
            case "quadrilateral":
                if (numVertices != 4) {
                    System.out.println("Invalid number of vertices for a quadrilateral.");
                    return;
                }
                vertices = new Diem[4];
                for (int i = 0; i < 4; i++) {
                    vertices[i] = new ConcreteDiem(0, 0);
                }
                Quadrilateral quadrilateral = new Quadrilateral(vertices);
                quadrilateral.input();
                quadrilateral.output();
                // Biểu diễn các phép biến đổi khác trên tứ giác
                break;
            case "parallelogram":
                if (numVertices != 4) {
                    System.out.println("Invalid number of vertices for a parallelogram.");
                    return;
                }
                vertices = new Diem[4];
                for (int i = 0; i < 4; i++) {
                    vertices[i] = new ConcreteDiem(0, 0);
                }
                Parallelogram parallelogram = new Parallelogram(vertices);
                parallelogram.input();
                parallelogram.output();
                // Biểu diễn các phép biến đổi khác trên hình bình hành
                break;
            case "rectangle":
                if (numVertices != 4) {
                    System.out.println("Invalid number of vertices for a rectangle.");
                    return;
                }
                vertices = new Diem[4];
                for (int i = 0; i < 4; i++) {
                    vertices[i] = new ConcreteDiem(0, 0);
                }
                Rectangle rectangle = new Rectangle(vertices);
                rectangle.input();
                rectangle.output();
                // biểu diễn các phép biến đổi khác trên hình chữ nhật
                break;
            case "square":
                if (numVertices != 4) {
                    System.out.println("Invalid number of vertices for a square.");
                    return;
                }
                vertices = new Diem[4];
                for (int i = 0; i < 4; i++) {
                    vertices[i] = new ConcreteDiem(0, 0);
                }
                Square square = new Square(vertices);
                square.input();
                square.output();
                // biểu diễn các phép biến đổi khác trên hình vuông
                break;
            default:
                System.out.println("Invalid polygon type.");
                return;
        }

        scanner.close();
    }
}