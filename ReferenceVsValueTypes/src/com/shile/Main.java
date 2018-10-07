package com.shile;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int myIntValue = 10;
	    int anotherValue = myIntValue;

        System.out.println("myIntValue = " + myIntValue);
        System.out.println("anotherVAlue = " + anotherValue);

        anotherValue++;

        System.out.println("myIntValue = " + myIntValue);
        System.out.println("anotherVAlue = " + anotherValue);

        // 两个reference都指向内存中的同一个数组
        int[] myIntArray = new int[5];
        int[] anotherArray = myIntArray;

        System.out.println("myIntAray = " + Arrays.toString(myIntArray));
        System.out.println("anotherArray = " + Arrays.toString(anotherArray));

        // 指定数组第一个element为1，两个引用都看到变化
        anotherArray[0] = 1;

        System.out.println("after change myIntAray = " + Arrays.toString(myIntArray));
        System.out.println("after change anotherArray = " + Arrays.toString(anotherArray));

        // 使用method,参数为第三个指向数组的reference
        // 只能间接引用（dereference）
        anotherArray = new int[]{4, 5, 6, 7, 8};
        modifyArray(myIntArray);

        System.out.println("after modify myIntAray = " + Arrays.toString(myIntArray));
        System.out.println("after modify anotherArray = " + Arrays.toString(anotherArray));

    }
    private static void modifyArray(int[] array) {
        array[0] = 2;
        // 指向一个新的数组
        array = new int[] {1, 2, 3, 4, 5};
    }
}
