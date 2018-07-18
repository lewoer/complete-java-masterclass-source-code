package com.shile;

public class Main {

    public static void main(String[] args) {
        numberToWords(233);
        numberToWords(0);
        numberToWords(1);

    }
    public static void numberToWords(int number) {
        if (number < 0) {
            System.out.println("Invalid Value");
        }

        int digits = getDigitCount(number);

        String[] stringArray = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        number = reverse(number);
        for (int i= 1; i <= digits; i++) {
            int lastDigits = number % 10;
            number = number / 10;
            switch (lastDigits) {
                case 0:
                    System.out.println(stringArray[0]);
                    break;
                case 1:
                    System.out.println(stringArray[1]);
                    break;
                case 2:
                    System.out.println(stringArray[2]);
                    break;
                case 3:
                    System.out.println(stringArray[3]);
                    break;
                case 4:
                    System.out.println(stringArray[4]);
                    break;
                case 5:
                    System.out.println(stringArray[5]);
                    break;
                case 6:
                    System.out.println(stringArray[6]);
                    break;
                case 7:
                    System.out.println(stringArray[7]);
                    break;
                case 8:
                    System.out.println(stringArray[8]);
                    break;
                case 9:
                    System.out.println(stringArray[9]);
                    break;
            }
        }
    }

    public static int reverse(int number) {
        int reverseNumber = 0;
        while (number != 0) {
            int digit  = number % 10;
            reverseNumber = reverseNumber * 10 + digit;
            number = number / 10;
        }
        return reverseNumber;
    }

    public static int getDigitCount(int number) {
        if (number < 0) {
            return -1;
        }
        int digits = 0;
        while (number >= 0) {x
            digits++;
            number = number / 10;
            if (number == 0) {
                break;
            }
        }
        return digits;

        }
}

