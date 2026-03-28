// Lab 6: Abstract Classes and Interfaces
// Program: Demonstrating abstract classes with a Payment system

abstract class Payment {
    protected String payerName;
    protected double amount;

    Payment(String payerName, double amount) {
        this.payerName = payerName;
        this.amount = amount;
    }

    // Abstract method — must be implemented by subclasses
    abstract void processPayment();

    // Concrete method shared by all subclasses
    void displayReceipt() {
        System.out.println("Payer  : " + payerName);
        System.out.println("Amount : Rs. " + amount);
        System.out.println("Status : Payment Processed Successfully");
    }
}

class CreditCardPayment extends Payment {
    String cardNumber;

    CreditCardPayment(String payerName, double amount, String cardNumber) {
        super(payerName, amount);
        this.cardNumber = cardNumber;
    }

    @Override
    void processPayment() {
        System.out.println("Processing Credit Card payment...");
        String displayCard = cardNumber.length() >= 4
                ? cardNumber.substring(cardNumber.length() - 4)
                : cardNumber;
        System.out.println("Card (last 4 digits): " + displayCard);
        displayReceipt();
    }
}

class UPIPayment extends Payment {
    String upiId;

    UPIPayment(String payerName, double amount, String upiId) {
        super(payerName, amount);
        this.upiId = upiId;
    }

    @Override
    void processPayment() {
        System.out.println("Processing UPI payment...");
        System.out.println("UPI ID: " + upiId);
        displayReceipt();
    }
}

class CashPayment extends Payment {
    CashPayment(String payerName, double amount) {
        super(payerName, amount);
    }

    @Override
    void processPayment() {
        System.out.println("Processing Cash payment...");
        displayReceipt();
    }
}

public class AbstractPayment {
    public static void main(String[] args) {
        Payment[] payments = {
            new CreditCardPayment("Alice", 1500.0, "1234567890123456"),
            new UPIPayment("Bob", 800.0, "bob@upi"),
            new CashPayment("Charlie", 500.0)
        };

        for (Payment payment : payments) {
            System.out.println("-------------------------------");
            payment.processPayment();
        }
    }
}
