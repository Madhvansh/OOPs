// Lab 3: Constructors and Method Overloading
// Program: Calculator demonstrating method overloading

public class Calculator {

    // Overloaded add methods
    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    double add(double a, double b) {
        return a + b;
    }

    String add(String a, String b) {
        return a + b;
    }

    // Overloaded multiply methods
    int multiply(int a, int b) {
        return a * b;
    }

    double multiply(double a, double b) {
        return a * b;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("add(5, 3)          = " + calc.add(5, 3));
        System.out.println("add(5, 3, 2)       = " + calc.add(5, 3, 2));
        System.out.println("add(5.5, 3.2)      = " + calc.add(5.5, 3.2));
        System.out.println("add(\"Hello\", \" World\") = " + calc.add("Hello", " World"));
        System.out.println("multiply(4, 5)     = " + calc.multiply(4, 5));
        System.out.println("multiply(2.5, 4.0) = " + calc.multiply(2.5, 4.0));
    }
}
