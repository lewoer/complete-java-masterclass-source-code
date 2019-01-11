package com.shile;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initialAmount) {
        this.name = name;
        // 必须对交易进行初始化
        this.transactions = new ArrayList<Double>();
        addTransaction(initialAmount);
    }

    public void addTransaction(double amount) {
        // autoboxing
        this.transactions.add(amount);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
