package com.shile;

public class Main {

    public static void main(String[] args) {

        // You job is to create a simple banking application.
        // There should be a Bank class
        // It should have an arraylist of Branches
        // Each Branch should have an arraylist of Customers
        // The Customer class should have an arraylist of Doubles (transactions)
        // Customer:
        // Name, and the ArrayList of doubles.
        // Branch:
        // Need to be able to add a new customer and initial transaction amount.
        // Also needs to add additional transactions for that customer/branch
        // Bank:
        // Add a new branch
        // Add a customer to that branch with initial transaction
        // Add a transaction for an existing customer for that branch
        // Show a list of customers for a particular branch and optionally a list
        // of their transactions
        // Demonstration autoboxing and unboxing in your code
        // Hint: Transactions
        // Add data validation.
        // e.g. check if exists, or does not exist, etc.
        // Think about where you are adding the code to perform certain actions

        Bank bank = new Bank("National Australia Bank");

        bank.addBranch("Adelaide");

        bank.addCustomer("Adelaide", "Tim", 50.5);
        bank.addCustomer("Adelaide", "Mike", 173.4);
        bank.addCustomer("Adelaide", "Percy", 123.0);

        bank.addBranch("Sydney");
        bank.addCustomer("Sydney", "Bob", 150.4);

        bank.addCustomerTransaction("Adelaide", "Tim", 44.33);
        bank.addCustomerTransaction("Adelaide", "Tim", 12.44);
        bank.addCustomerTransaction("Adelaide", "Mike", 44.33);

        bank.listCustomer("Adelaide", true);
        bank.listCustomer("Sydney", true);

        if (!bank.addBranch("Adelaide")) {
            System.out.println("Adelaide already exist");
        }
    }
}










