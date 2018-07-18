package com.shile;

public class Main {

    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(252));
        System.out.println(getEvenDigitSum(-1));
        System.out.println(getEvenDigitSum(12345678));
    }

    public static int getEvenDigitSum(int number) {

        if (number < 0) {
            return -1;
        }
        int evenDigitSum = 0;
        while (number > 0) {
            int lastdigit = number % 10;
            number = number / 10;
            if (lastdigit % 2 == 0) {
                evenDigitSum += lastdigit;
            }
        }

        return evenDigitSum;

    }
}
