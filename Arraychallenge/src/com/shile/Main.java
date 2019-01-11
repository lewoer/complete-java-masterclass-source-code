package com.shile;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Create a program using arrays that sorts a list of integers in descending order.
        // Descending order is highest value to lowest.
        // In other words if the array had the values in it 106, 26, 81, 5, 15 your program should
        // ultimately have an array with 106,81,26, 15, 5 in it.
        // Set up the program so that the numbers to sort are read in from the keyboard.
        // Implement the following methods - getIntegers, printArray, and sortIntegers
        // getIntegers returns an array of entered integers from keyboard
        // printArray prints out the contents of the array
        // and sortIntegers should sort the array and return a new array containing the sorted numbers
        // you will have to figure out how to copy the array elements from the passed array into a new
        // array and sort them and return the new sorted array.
        //
        int[] myIntegers = getIntegers(5);
        int[] sorted = sortIntegers(myIntegers);
        printArray(sorted);

    }

    public static int[] getIntegers(int capacity) {
        System.out.println("Enter " + capacity + " integer value:\r");
        int[] arrays = new int[capacity];

        for (int i=0; i<arrays.length;i++) {
            arrays[i] = scanner.nextInt();
        }

        return arrays;
    }
    public static void printArray(int[] array) {

        for (int i=0; i<array.length; i++) {
            System.out.println("element " + i + " content " + array[i]);
        }
    }
    public static int[] sortIntegers(int[] array) {

        // 复制数组是为了故障安全。
        int[] sortedArray = Arrays.copyOf(array, array.length);

        boolean flag = true;
        int temp;
        while(flag) {
            flag = false;
            for (int i=0; i<sortedArray.length - 1; i++) {
                // i<sortedArray.length -1是为了防止数组index超出。
                if (sortedArray[i] < sortedArray[i+1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = temp;
                    flag = true;  // 设置为true保障了循环。
                }
            }
        }
        return sortedArray;
    }
}
