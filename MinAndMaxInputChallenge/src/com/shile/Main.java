package com.shile;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = Integer.MAX_VALUE;  // 常量的加入
        int max = Integer.MIN_VALUE;
//        boolean first = true;

        while (true) {
            System.out.println("Enter number");
            boolean isAnInt = scanner.hasNextInt();

            if (!isAnInt) {
                System.out.println("min = " + min + ",max = " + max);
                scanner.close();
                return;
            }
            int number = scanner.nextInt();

//                if (first) {
//                    first = false;
//                    min = number;
//                    max = number;
//                }
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
            scanner.nextLine();
        }

    }
}
