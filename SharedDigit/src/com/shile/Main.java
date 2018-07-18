package com.shile;

public class Main {

    public static void main(String[] args) {
        System.out.println(hasSharedDigit(12,22));
        System.out.println(hasSharedDigit(-11,21));
        System.out.println(hasSharedDigit(1,2));
    }
    public static boolean hasSharedDigit(int firstNum, int secondNum) {
        if (firstNum < 10 || firstNum > 99 || secondNum < 10 || secondNum > 99) {
            return false;
        } else {
            int lastDigit1, lastDigit2;
            while (firstNum > 0) {
                lastDigit1 = firstNum % 10;
                while (secondNum > 0) {
                    lastDigit2 = secondNum % 10;
                    if (lastDigit2 == lastDigit1) {
                        return true;
                    }
                    secondNum = secondNum / 10;
                }
                firstNum = firstNum / 10;
            }
            return false;
        }
    }
}
