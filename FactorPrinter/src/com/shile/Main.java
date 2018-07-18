package com.shile;

public class Main {
    private static final String INVALID_VALUE = "Invalid Value";

    public static void main(String[] args) {
	    printFactors(12);
    }
    public static void printFactors(int number) {
        if (number < 1) {
            System.out.println(INVALID_VALUE);
        }

        for (int i=1; i<=number;i++) {
            if (number % i == 0) {
                System.out.println(i);
            }
        }
    }
}
