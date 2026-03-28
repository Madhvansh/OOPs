// Lab 7: Exception Handling
// Program: Demonstrating try-catch-finally, multiple exceptions, and custom exceptions

// Custom exception class
class InsufficientFundsException extends Exception {
    double amount;

    InsufficientFundsException(double amount) {
        super("Insufficient funds! Short by: " + amount);
        this.amount = amount;
    }
}

class BankAccountException {
    private String owner;
    private double balance;

    BankAccountException(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
    }

    void deposit(double amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive. Got: " + amount);
        }
        balance += amount;
        System.out.println("Deposited: " + amount + " | Balance: " + balance);
    }

    void withdraw(double amount) throws InsufficientFundsException, IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive. Got: " + amount);
        }
        if (amount > balance) {
            throw new InsufficientFundsException(amount - balance);
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount + " | Balance: " + balance);
    }

    double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        BankAccountException account = new BankAccountException("Alice", 1000.0);

        // Test valid deposit
        try {
            account.deposit(500.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test invalid deposit
        try {
            account.deposit(-100.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test valid withdrawal
        try {
            account.withdraw(300.0);
        } catch (InsufficientFundsException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test insufficient funds
        try {
            account.withdraw(5000.0);
        } catch (InsufficientFundsException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Final balance: " + account.getBalance());
        }

        // Test ArithmeticException
        try {
            int result = 10 / 0;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        } finally {
            System.out.println("Finally block always executes.");
        }
    }
}
