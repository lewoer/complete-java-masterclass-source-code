package com.shile;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();

    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customName, double initialAmount) {
        if (findCustomer(customName) == null) {
            this.customers.add(new Customer(customName, initialAmount));
            return true;
        }

        return false;
    }

    public boolean addCustomerTransaction(String customeName, double amount) {
        // ctrl + shift + delete解除if等的包装
        Customer existingCustomer = findCustomer(customeName);
        if (existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

    private Customer findCustomer(String customerName) {
        for (int i=0; i<this.customers.size(); i++) {
            Customer checkedCustomer = this.customers.get(i);
            if (checkedCustomer.getName().equals(customerName)) {
                return checkedCustomer;
            }
        }
        return null;
    }



}
