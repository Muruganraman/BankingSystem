package Bankingsystem;

public class Account {
    private String accountHolder;
    private int accountNumber;
    private double balance;

    // Constructor
    public Account(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getter methods
    public String getAccountHolder() {
        return accountHolder;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit money into account
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdraw money from account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // String representation for easy display
    @Override
    public String toString() {
        return "Account Holder: " + accountHolder + ", Account Number: " + accountNumber + ", Balance: " + balance;
    }
}

