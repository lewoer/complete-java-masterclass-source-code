package com.shile;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Perform transfers from one bank to another
 * deposit(), withdraw(), transfer()
 * transfer()从源账号取钱,如果成功,存钱到目标账户,如果失败,退回钱款.
 *
 * 这个代码引发livelock,两个线程是Non-block,但是他们却不运行.它们持续取钱,转换,失败,然后退钱.一直循环,直到我们手动终结代码
 * 代码从来没有释放锁.
 *
 * 潜在执行过程.
 *
 */
public class Challenge7 {

    public static void main(String[] args) {
        NewBankAccount account1 = new NewBankAccount("12345-678", 500.00);
        NewBankAccount account2 = new NewBankAccount("98765-432", 1000.00);

        new Thread(new Transfer(account1, account2, 10.00), "Transfer1").start();
        new Thread(new Transfer(account2, account1, 55.88), "Transfer2").start();
    }
}

class NewBankAccount {
    private double balance;
    private String accountNumber;
    private Lock lock = new ReentrantLock();

    NewBankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public boolean withdraw(double amount) {
        if (lock.tryLock()) {
            try {
                try {
                    // 模拟数据库访问
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                }
                balance -= amount;
                System.out.printf("%s: Withdrew %f\n", Thread.currentThread().getName(), amount);
                return true;
            } finally {
                lock.unlock();
            }
        }
        return false;
    }

    public boolean deposit(double amount) {
        if (lock.tryLock()) {
            try {
                try {
                    // Simulate database access
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                }
                balance += amount;
                System.out.printf("%s: Deposited %f\n", Thread.currentThread().getName(), amount);
                return true;
            } finally {
                lock.unlock();
            }
        }
        return false;
    }

    public boolean transfer(NewBankAccount destinationAccount, double amount) {
        if (withdraw(amount)) {
            if (destinationAccount.deposit(amount)) {
                return true;
            }
            else {
                // The deposit failed. Refund the money back into the account.
                System.out.printf("%s: Destination account busy. Refunding money\n",
                        Thread.currentThread().getName());
                deposit(amount);
            }
        }

        return false;
    }
}

class Transfer implements Runnable {
    private NewBankAccount sourceAccount, destinationAccount;
    private double amount;

    Transfer(NewBankAccount sourceAccount, NewBankAccount destinationAccount, double amount) {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
    }

    public void run() {
        while (!sourceAccount.transfer(destinationAccount, amount))
            continue;
        System.out.printf("%s completed\n", Thread.currentThread().getName());
    }
}
