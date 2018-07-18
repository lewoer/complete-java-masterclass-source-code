package com.shile;

public class Main {

    public static void main(String[] args) {

        System.out.println(sumFirstAndLastDigit(257));
        System.out.println(sumFirstAndLastDigit(4));

    }

    public static int sumFirstAndLastDigit(int number) {

        int firstDigit = number;
        int lastDigit;

        if (number < 0) {
            return -1;
        }
        while (firstDigit >= 10) {
            firstDigit = firstDigit / 10;
        }

        lastDigit = number % 10;

        return firstDigit + lastDigit;
    }
}
