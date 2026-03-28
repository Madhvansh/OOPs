// Lab 7: Exception Handling
// Program: Demonstrating various built-in exceptions and exception chaining

public class ExceptionHandling {

    // Method demonstrating ArrayIndexOutOfBoundsException
    static void arrayDemo() {
        int[] arr = {10, 20, 30};
        System.out.println("Array elements: ");
        try {
            for (int i = 0; i <= arr.length; i++) {
                System.out.println("arr[" + i + "] = " + arr[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught: Array index out of bounds - " + e.getMessage());
        }
    }

    // Method demonstrating NumberFormatException
    static void numberFormatDemo() {
        String[] inputs = {"42", "3.14", "abc", "100"};
        System.out.println("\nParsing integers:");
        for (String input : inputs) {
            try {
                int value = Integer.parseInt(input);
                System.out.println("Parsed '" + input + "' = " + value);
            } catch (NumberFormatException e) {
                System.out.println("Cannot parse '" + input + "': " + e.getMessage());
            }
        }
    }

    // Method demonstrating NullPointerException
    static void nullPointerDemo() {
        String str = null;
        System.out.println("\nNull pointer demo:");
        try {
            System.out.println("Length: " + str.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: string is null.");
        }
    }

    // Correct factorial — handles n <= 1 as base case
    static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    // Helper that recurses infinitely to trigger StackOverflowError
    static void infiniteRecurse() {
        infiniteRecurse();
    }

    static void stackOverflowDemo() {
        System.out.println("\nStack overflow demo:");
        try {
            infiniteRecurse();
        } catch (StackOverflowError e) {
            System.out.println("Caught StackOverflowError: too deep recursion.");
        }
    }

    public static void main(String[] args) {
        arrayDemo();
        numberFormatDemo();
        nullPointerDemo();
        stackOverflowDemo();
    }
}
