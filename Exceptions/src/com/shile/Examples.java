package com.shile;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @Author: ShiLe
 * @Description: multi exceptions 用| 分离
 * @Date: Created in 21:01 2019/1/4
 */
public class Examples {
    public static void main(String[] args) {
        try {
            int result = divide();
            System.out.println("result is " + result);
        } catch (ArithmeticException | NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("Unable to perform division, autopilot shutting down");
        }
    }

    private static int divide() {

        // stack trace非常小。
        int x, y;
//        try {
        x = getInt();
        y = getInt();
        System.out.println("x = " + x + " , y is " + y);
        return x / y;
//        } catch (NoSuchElementException e) {
//            throw new NoSuchElementException("no suitable input");
//        } catch (ArithmeticException e) {
//            throw new ArithmeticException("Atempt to divide by 0");
//        }
    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter integer:  ");
        while (true) {
            try {
                return s.nextInt();
            } catch (InputMismatchException e) {
                s.nextLine();
                System.out.println("please enter a number using only the digit from 0-9");
            }
        }

    }
}
