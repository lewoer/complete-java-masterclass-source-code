package com.shile;

public class Main {

    public static void main(String[] args) {
	    Account lewoerAccount = new Account("lewoer");
	    lewoerAccount.deposit(1000);
	    lewoerAccount.withdraw(500);
	    lewoerAccount.withdraw(-200);
	    lewoerAccount.deposit(-20);
	    lewoerAccount.calculateBalance();
	    lewoerAccount.balance = 50000;

        System.out.println("Balance on account is " + lewoerAccount.getBalance());
        lewoerAccount.transactions.add(4000);
        lewoerAccount.calculateBalance();
    }
}
