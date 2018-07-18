package com.shile;

import java.time.temporal.TemporalAmount;

public class Account {
    private String number;
    private double balance;
    private String customerName;
    private String customEmailAddress;
    private String customPhoneNUmber;

    public Account() {
        // 构造器能够被重载。this必须放在第一行,
        this("9911", 2.50, "default name",
                "default email", "default phone");
        System.out.println("Empty constructors called");

    }

    public Account(String number, double balance, String customerName,
                   String customEmailAddress, String customPhoneNUmber) {

        System.out.println("Account constructors with parameters called");

        this.number = number;
        this.balance = balance;
        this.customerName = customerName;
        this.customEmailAddress = customEmailAddress;
        this.customPhoneNUmber = customPhoneNUmber;
    }

    public Account(String customerName, String customEmailAddress, String customPhoneNUmber) {
        // default 2 parameters
        // 其他的调用构造器
        this("12323", 100.55, customerName, customEmailAddress, customPhoneNUmber);
    }

    public void deposit(double depositAccount) {
        this.balance += depositAccount;
        System.out.println("Deposit of " + depositAccount + " made. New balance is " + this.balance);
    }

    public void withdrawal(double withdrawalAmount) {
        // 大于小于等于经常发生错误，注意！！！
        if (this.balance - withdrawalAmount < 0) {
            System.out.println("only " + this.balance + " available. Withdrawal not processed");
        } else {
            this.balance -= withdrawalAmount;
            System.out.println("Withdrawal of " + withdrawalAmount + " processed. Remaining balance is " + this.balance);
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomEmailAddress() {
        return customEmailAddress;
    }

    public void setCustomEmailAddress(String customEmailAddress) {
        this.customEmailAddress = customEmailAddress;
    }

    public String getCustomPhoneNUmber() {
        return customPhoneNUmber;
    }

    public void setCustomPhoneNUmber(String customPhoneNUmber) {
        this.customPhoneNUmber = customPhoneNUmber;
    }
}
