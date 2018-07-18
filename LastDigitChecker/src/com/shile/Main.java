package com.shile;

public class Main {

    public static void main(String[] args) {
        System.out.println(hasSameLastDigit(11,23,31));
        System.out.println(hasSameLastDigit(9,99,999));
    }

    public static boolean hasSameLastDigit(int numOne, int numTwo, int numThree) {
        if (numOne < 10 || numOne > 1000 || numTwo < 10 || numTwo > 1000 || numThree < 10 || numThree > 1000) {
            return false;
        }
        return (numOne % 10 == numTwo % 10 || numOne % 10 == numThree % 10 || numTwo % 10 == numThree % 10);
    }
}
