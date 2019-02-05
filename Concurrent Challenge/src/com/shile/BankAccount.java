package com.shile;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Thread-safe 的方法
 * 1. 使用synchronized关键字
 * 2. 使用synchronized block,建议使用这一种,尽可能减少同步的范围.
 * 3. 使用ReentrantLock
 * - 创建lock field
 * - 构造器中进行初始化,this.lock = new ReentrantLock();
 * - 使用try finally对关键部分进行lock unlock
 * 4. Use tryLock with a timeout value;
 * 使用timeoutvalue 为1s,如果等待的超时,打印出"could not get the lock to the console"
 *
 *
 * challenge 6: update the code so that the status variable code is thread safe
 *      因为status variable是一个本地变量,它早已thread safe.本地变量存储在thread stack,所以每个线程都有一份自己的copy
 *      所以set get status value,线程不会相互影响
 */
public  class BankAccount {
    /*操作field的方法进行synchronized block*/

    private double balance;
    private String accountNumber;

    private Lock lock;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
    }

    //    public  synchronized void deposit(double amount) {
//        balance += amount;
//    }
//
//    public synchronized void withdraw(double amount) {
//        balance -= amount;
//    }
//    public  void deposit(double amount) {
//        lock.lock();
//        try {
//            balance += amount;
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public  void withdraw(double amount) {
//        lock.lock();
//        try {
//            balance -= amount;
//        } finally {
//            lock.unlock();
//        }
//    }
    public void deposit(double amount) {

        boolean status = false;
        try {
            if (lock.tryLock(1000, TimeUnit.MICROSECONDS)) {
                try {
                    balance += amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("could not get the lock");
            }

        } catch (InterruptedException e) {
            // do something here
        }
        System.out.println("Trasaction status = " + status);
    }

    public void withdraw(double amount) {
        boolean status = false;
        try {
            if (lock.tryLock(1000, TimeUnit.MICROSECONDS)) {
                try {
                    balance -= amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("could not get the lock");
            }
        } catch (InterruptedException e) {
            // do something here
        }
        System.out.println("Transcation status = " + status);
    }

    public String getAccountNumber() {  // 读取accountnumber 不需要synchronize
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account number = " + accountNumber);
    }
}
