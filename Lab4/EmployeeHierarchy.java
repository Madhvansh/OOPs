// Lab 4: Inheritance
// Program: Employee hierarchy demonstrating inheritance with method overriding

// Base class
class Employee {
    String name;
    int id;
    double baseSalary;

    Employee(String name, int id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }

    double calculateSalary() {
        return baseSalary;
    }

    void displayInfo() {
        System.out.println("ID        : " + id);
        System.out.println("Name      : " + name);
        System.out.println("Salary    : " + calculateSalary());
    }
}

// Manager extends Employee
class Manager extends Employee {
    double bonus;

    Manager(String name, int id, double baseSalary, double bonus) {
        super(name, id, baseSalary);
        this.bonus = bonus;
    }

    @Override
    double calculateSalary() {
        return baseSalary + bonus;
    }

    @Override
    void displayInfo() {
        System.out.println("Role      : Manager");
        super.displayInfo();
        System.out.println("Bonus     : " + bonus);
    }
}

// Intern extends Employee
class Intern extends Employee {
    int durationMonths;

    Intern(String name, int id, double baseSalary, int durationMonths) {
        super(name, id, baseSalary);
        this.durationMonths = durationMonths;
    }

    @Override
    void displayInfo() {
        System.out.println("Role      : Intern");
        super.displayInfo();
        System.out.println("Duration  : " + durationMonths + " months");
    }
}

public class EmployeeHierarchy {
    public static void main(String[] args) {
        System.out.println("--- Employee ---");
        Employee emp = new Employee("Alice", 1001, 50000);
        emp.displayInfo();

        System.out.println("\n--- Manager ---");
        Manager mgr = new Manager("Bob", 1002, 70000, 15000);
        mgr.displayInfo();

        System.out.println("\n--- Intern ---");
        Intern intern = new Intern("Charlie", 1003, 20000, 6);
        intern.displayInfo();
    }
}
