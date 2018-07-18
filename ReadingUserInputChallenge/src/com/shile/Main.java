package com.shile;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int counter = 0;
        int sum = 0;

//        while (true)
        // while 加入条件直接去掉break，break让一切很不明确。
        while (counter < 10) {
            int order = counter + 1;
            System.out.println("Enter number #" + order + ":");

            boolean isAnint = scanner.hasNextInt();

            if (isAnint) {
                int number = scanner.nextInt();
                counter++;
                sum += number;
//                if (counter == 10) {
//                    break;
//                }
            } else {
                System.out.println("Invalid Number");
            }

            scanner.nextLine();  // handle end of line(enter key)
        }
        System.out.println("sum = " + sum);
        scanner.close();
    }
}
