// Lab 1: Introduction to Java
// Program 2: Basic Data Types and Operators

public class DataTypes {
    public static void main(String[] args) {
        // Primitive data types
        int age = 20;
        float height = 5.9f;
        double salary = 55000.75;
        char grade = 'A';
        boolean isStudent = true;
        String name = "Alice";

        System.out.println("Name      : " + name);
        System.out.println("Age       : " + age);
        System.out.println("Height    : " + height);
        System.out.println("Salary    : " + salary);
        System.out.println("Grade     : " + grade);
        System.out.println("Is Student: " + isStudent);

        // Arithmetic operators
        int a = 10, b = 3;
        System.out.println("\nArithmetic Operations:");
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));
    }
}
