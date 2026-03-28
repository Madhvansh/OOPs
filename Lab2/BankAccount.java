// Lab 2: Classes and Objects
// Program: BankAccount class demonstrating encapsulation with private fields

public class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;

    // Method to initialize account
    void openAccount(String holder, String number, double initialDeposit) {
        this.accountHolder = holder;
        this.accountNumber = number;
        this.balance = initialDeposit;
        System.out.println("Account opened for " + accountHolder);
    }

    // Deposit money
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + " | New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw money
    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " | New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    // Display account details
    void displayAccount() {
        System.out.println("\nAccount Holder : " + accountHolder);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Balance        : " + balance);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.openAccount("Alice", "ACC-001", 1000.0);
        account.deposit(500.0);
        account.withdraw(200.0);
        account.withdraw(2000.0);
        account.displayAccount();
    }
}
