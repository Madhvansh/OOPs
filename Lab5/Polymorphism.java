// Lab 5: Polymorphism
// Program: Shape hierarchy demonstrating runtime polymorphism (method overriding)

// Abstract base class
abstract class Shape {
    String color;

    Shape(String color) {
        this.color = color;
    }

    // Abstract methods — each subclass must provide its own implementation
    abstract double area();
    abstract double perimeter();

    void display() {
        System.out.println("Shape     : " + getClass().getSimpleName());
        System.out.println("Color     : " + color);
        System.out.println("Area      : " + area());
        System.out.println("Perimeter : " + perimeter());
    }
}

class Circle extends Shape {
    double radius;

    Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class RectangleShape extends Shape {
    double length, width;

    RectangleShape(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }

    @Override
    double perimeter() {
        return 2 * (length + width);
    }
}

class Triangle extends Shape {
    double a, b, c;

    Triangle(String color, double a, double b, double c) {
        super(color);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double area() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    double perimeter() {
        return a + b + c;
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        // Array of base class references — runtime polymorphism
        Shape[] shapes = {
            new Circle("Red", 7.0),
            new RectangleShape("Blue", 6.0, 4.0),
            new Triangle("Green", 3.0, 4.0, 5.0)
        };

        for (Shape shape : shapes) {
            shape.display();
            System.out.println();
        }
    }
}
