package com.shile;

public class Main {

    public static void main(String[] args) {
        for (double i=2; i<9; i++) {
            System.out.println("10,000 at "+ i + " % interest = " +
                    String.format("%.2f", calculateInterest(10000.0,i)));
        }
        System.out.println("***********************");
        for (double i=8; i>=2; i--) {
            System.out.println("10,000 at "+ i + " % interest = " +
                    String.format("%.2f", calculateInterest(10000.0,i)));
        }

        int count = 0;
        for (int i=10; i<50; i++) {
            if (isPrime(i)) {
                count++;
                System.out.println("Number" + i + " is a prime number");
                if (count == 10) {
                    System.out.println("Exiting the loop");
                    break;
                }
            }
        }
    }

    public static double calculateInterest(double amount, double interestRate) {
        return(amount * (interestRate / 100));
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        // 如果n不是素数，它必然有一个小于根号n因子。比n/2简单。
        for(int i=2; i <= (long) Math.sqrt(n); i++) {
            System.out.println("Looping " + i);
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
