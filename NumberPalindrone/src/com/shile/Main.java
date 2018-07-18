package com.shile;

public class Main {

    public static void main(String[] args) {
        System.out.println(isPalindrome(1001));
        System.out.println(isPalindrome(1234));
        System.out.println(isPalindrome(-1001));
        System.out.println(isPalindrome(701));
    }
    public static boolean isPalindrome(int number) {
        int reverseNum = 0;
        int num = number;
        while (num != 0) {
            int lasDigit = num % 10;
            reverseNum = (reverseNum * 10) + lasDigit;
            num = num / 10;
//            System.out.println(reverseNum);
    }
        return reverseNum == number;
    }
}
