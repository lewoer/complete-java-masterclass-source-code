package com.shile.mylibrary;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 15:40 2018/12/30
 */
public class Series {
    public static long nSum(int n) {
        return (n * (n + 1)) / 2;
    }

    public static long factorial( int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n-1);
    }

    public static long fibonacci(int n) {
        long  result = 0;
        if (n <=1) {
            return n;
        } else {
            result = fibonacci(n-1) + fibonacci(n-2);
        }
        return result;
    }
}
