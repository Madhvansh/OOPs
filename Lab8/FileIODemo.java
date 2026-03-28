// Lab 8: File I/O
// Program: Reading from and writing to files using Java I/O

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIODemo {

    static final String FILE_PATH = "students.txt";

    // Write student records to a file
    static void writeStudents() {
        String[] students = {
            "Alice,101,92.5",
            "Bob,102,74.0",
            "Charlie,103,85.5",
            "Diana,104,68.0"
        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write("Name,RollNo,Marks");
            writer.newLine();
            for (String student : students) {
                writer.write(student);
                writer.newLine();
            }
            System.out.println("Student records written to " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // Read and display student records from the file
    static void readStudents() {
        System.out.println("\nReading from " + FILE_PATH + ":");
        System.out.println("----------------------------------");

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            boolean isHeader = true;
            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    System.out.printf("%-12s %-10s %-6s%n", "Name", "Roll No", "Marks");
                    System.out.println("----------------------------------");
                    isHeader = false;
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    System.out.printf("%-12s %-10s %-6s%n", parts[0], parts[1], parts[2]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Append a new student record to the file
    static void appendStudent(String name, int rollNo, double marks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(name + "," + rollNo + "," + marks);
            writer.newLine();
            System.out.println("\nAppended: " + name + " to " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
    }

    // Delete the file
    static void deleteFile() {
        File file = new File(FILE_PATH);
        if (file.delete()) {
            System.out.println("\nFile '" + FILE_PATH + "' deleted successfully.");
        } else {
            System.out.println("\nFailed to delete file.");
        }
    }

    public static void main(String[] args) {
        writeStudents();
        readStudents();
        appendStudent("Eve", 105, 91.0);
        readStudents();
        deleteFile();
    }
}
