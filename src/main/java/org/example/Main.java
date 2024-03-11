package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // create the scanner object
        Scanner scanner = new Scanner(System.in);

        // create a bank object
        Bank cplBank = new Bank();

        // a variable to save the user choice from the menu
        int userChoice;

        do {
            System.out.println("\n1. Add Account");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.println("Enter Your Choice: ");

            userChoice = scanner.nextInt();
            scanner.nextLine(); // consumes the newLine character

            switch (userChoice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accountNumber = scanner.nextLine();

                    System.out.print("Enter Account Holder Name: ");
                    String accountHolder = scanner.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine(); // consumes new line of character

                    System.out.print("Enter the Account Type (e.g. Savings, Checking): ");
                    String accountType = scanner.nextLine();

                    cplBank.addAccount(accountNumber, accountHolder, balance, accountType);
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextLine();

                    BankAccount account = cplBank.getAccount(accountNumber);

                    if (account != null){
                        System.out.print("Enter the amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("Account Not Found!!!");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextLine();
                    account = cplBank.getAccount(accountNumber);

                    if (account != null){
                        System.out.print("Enter Amount To Withdraw: ");
                        double withdrawalAmount = scanner.nextDouble();
                        account.withdraw(withdrawalAmount);
                    } else {
                        System.out.println("Account Not Found");
                    }
                    break;
                case 4:
                    System.out.print("Enter the Account Number:");
                    accountNumber = scanner.nextLine();
                    account = cplBank.getAccount(accountNumber);
                    if (account != null) {
                        System.out.println("Transaction History for Account: " + accountNumber);
                        List<String> transactions = account.getTransactionHistory();
                        for (String transaction : transactions) {
                            System.out.println(transaction);
                        }
                    } else {
                        System.out.println("Account Not Found!!!");
                    }
                    break;
                case 5:
                    System.out.println("Exiting Program...");
                    break;
                default:
                    System.out.println("Invalid Choice. Please enter choice between 1 and 4.");
            }
        } while (userChoice != 5);


    // close the scanner object
    scanner.close();
    }
}