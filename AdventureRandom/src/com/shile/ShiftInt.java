package com.shile;

/**
 * Created by timbuchalka on 19/05/2016.
 * @Description: 1. bitewise shift
 *                  - >> 二进制有符号右移，>> 1 常常代表原来0.5倍，移动位数int 超过32位，long超过64位取余数，
 *                      右移动后，左侧用0补齐。1，代表附负数，0代表正数
 *                  - << 有符号左移，<< 1 常代表原来2倍，
 *                  - >>> 无符号右移
 */
public class ShiftInt {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        int x = 922342959;

        writeInt(x);
    }


    private static void display(int x) {
        String all = String.format("%32s", Integer.toBinaryString(x)).replace(" ", "0");
        String colouredBinary = all.substring(0, 24) + ANSI_BLUE + all.substring(24) + ANSI_RESET;
        int y = x & 0xFF;
        String output = String.format("%10d and 0xFF is %8s \t %10d is ",  y, Integer.toBinaryString(y), x) + colouredBinary;
        System.out.println(output);
    }

    private static void writeInt(int v) {
        int x;
        display(v >>> 24);
        display(v >>> 16);
        display(v >>> 8);
        display(v >>> 0);
    }
}
