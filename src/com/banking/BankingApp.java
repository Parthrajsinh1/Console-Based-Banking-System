package com.banking;

import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Banking System Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter account holder's full name: ");
                    scanner.nextLine(); // Clear the newline left by nextInt()
                    String fullName = scanner.nextLine(); // Read full name with spaces
                    System.out.print("Enter initial balance: ");
                    double initial = scanner.nextDouble();
                    bank.createAccount(fullName, initial);
                    break;
                case 2:
                    System.out.print("Enter account ID: ");
                    int depId = scanner.nextInt();
                    Account depAcc = bank.findAccount(depId);
                    if (depAcc != null) {
                        System.out.print("Enter deposit amount: ");
                        double depAmount = scanner.nextDouble();
                        depAcc.deposit(depAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter account ID: ");
                    int withId = scanner.nextInt();
                    Account withAcc = bank.findAccount(withId);
                    if (withAcc != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double withAmount = scanner.nextDouble();
                        withAcc.withdraw(withAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter account ID: ");
                    int balId = scanner.nextInt();
                    Account balAcc = bank.findAccount(balId);
                    if (balAcc != null) {
                        System.out.println("Balance for " + balAcc.getAccountHolderName() + ": " + balAcc.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting Banking System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }
}
