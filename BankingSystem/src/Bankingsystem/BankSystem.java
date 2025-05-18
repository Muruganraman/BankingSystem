package Bankingsystem;

import java.util.*;

public class BankSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<Integer, Account> accounts = new HashMap<>(); // Store accounts using account number

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to the Banking System");
            System.out.println("1. Create Account");
            System.out.println("2. View Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    viewAccount();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    withdrawMoney();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // Method to create a new account
    private static void createAccount() {
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial deposit: ");
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        int accountNumber = generateAccountNumber();
        Account newAccount = new Account(name, accountNumber, initialDeposit);
        accounts.put(accountNumber, newAccount);

        System.out.println("Account created successfully. Account number: " + accountNumber);
    }

    // Method to view account details
    private static void viewAccount() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println(account);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to deposit money
    private static void depositMoney() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();  // Consume newline
            account.deposit(amount);
            System.out.println("Deposited " + amount + " into the account. New balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to withdraw money
    private static void withdrawMoney() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();  // Consume newline
            account.withdraw(amount);
            System.out.println("Withdrawn " + amount + " from the account. New balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    // Generate a unique account number
    private static int generateAccountNumber() {
        Random random = new Random();
        return 100000 + random.nextInt(900000); // Random 6-digit account number
    }
}



