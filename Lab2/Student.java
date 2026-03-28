// Lab 2: Classes and Objects
// Program: Student class demonstrating basic class structure, fields, and methods

public class Student {
    // Instance variables (fields)
    String name;
    int rollNumber;
    double marks;

    // Method to set student details
    void setDetails(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Method to display student details
    void displayDetails() {
        System.out.println("Name       : " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks      : " + marks);
    }

    // Method to determine grade
    String getGrade() {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 60) return "C";
        else return "F";
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setDetails("Alice", 101, 92.5);
        s1.displayDetails();
        System.out.println("Grade      : " + s1.getGrade());

        System.out.println();

        Student s2 = new Student();
        s2.setDetails("Bob", 102, 74.0);
        s2.displayDetails();
        System.out.println("Grade      : " + s2.getGrade());
    }
}
