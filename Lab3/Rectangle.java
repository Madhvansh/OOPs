// Lab 3: Constructors and Method Overloading
// Program: Rectangle class demonstrating constructors and overloaded methods

public class Rectangle {
    private double length;
    private double width;

    // Default constructor
    Rectangle() {
        this.length = 0;
        this.width = 0;
    }

    // Parameterized constructor
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Copy constructor
    Rectangle(Rectangle other) {
        this.length = other.length;
        this.width = other.width;
    }

    // Calculate area
    double area() {
        return length * width;
    }

    // Calculate perimeter
    double perimeter() {
        return 2 * (length + width);
    }

    // Overloaded method: scale by a factor
    void scale(double factor) {
        this.length *= factor;
        this.width *= factor;
    }

    // Overloaded method: scale length and width independently
    void scale(double lengthFactor, double widthFactor) {
        this.length *= lengthFactor;
        this.width *= widthFactor;
    }

    void display() {
        System.out.println("Length    : " + length);
        System.out.println("Width     : " + width);
        System.out.println("Area      : " + area());
        System.out.println("Perimeter : " + perimeter());
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        System.out.println("Default Rectangle:");
        r1.display();

        System.out.println("\nParameterized Rectangle:");
        Rectangle r2 = new Rectangle(5.0, 3.0);
        r2.display();

        System.out.println("\nCopied Rectangle:");
        Rectangle r3 = new Rectangle(r2);
        r3.display();

        System.out.println("\nAfter uniform scaling by 2:");
        r2.scale(2.0);
        r2.display();

        System.out.println("\nAfter independent scaling (length x3, width x2):");
        r3.scale(3.0, 2.0);
        r3.display();
    }
}
