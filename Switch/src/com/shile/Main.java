package com.shile;

public class Main {

    public static void main(String[] args) {
        int value = 1;
        if (value == 1) {
            System.out.println("Value was 1");
        } else if (value == 2) {
            System.out.println("Value was 2");
        } else {
            System.out.println("Was not 1 or 2");
        }
        同一个变量适合用switch
        int switchVAlue = 3;
        switch (switchVAlue) {
            case 1:
                System.out.println("Value was 1");
                break;
            case 2:
                System.out.println("VAlue was 2");
                break;

            case 3:
            case 4:
            case 5:
                System.out.println("Was a 3 or 4 or 5");
                break;
            default:
                System.out.println("Was not 1 2 3 4 or 5");
                break;
        }

        char charVAlue = 'A';
        switch (charVAlue) {
            case 'A':
                System.out.println("A was found.");
                break;
            case 'B':
                System.out.println("B was found.");
                break;
            case 'C':
            case 'D':
            case 'E':
                System.out.println(charVAlue + " was found");
                break;
            default:
                System.out.println("Counld not found A,B,C,D or E");
                break;
        }

        String month = "JUNE";
        switch (month.toLowerCase()) {
            case "January":
                System.out.println("Jan");
                break;
            case "June":
                System.out.println("Jun");
                break;
            default:
                System.out.println("Not Sure!");
        }


    }
}
