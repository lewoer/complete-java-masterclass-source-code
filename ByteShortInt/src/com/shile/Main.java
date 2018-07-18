package com.shile;

public class Main {

    public static void main(String[] args) {
        // 添加下划线便于区分
        // int has a width of 32
        int myMinValue = -2_147_483_648;
	    int myMaxValue = 2_147_483_647;
	    int myTotal = (myMinValue / 2);
        System.out.println(myTotal);

	    // byte -128~127之间
        // byte has a width of 8
	    byte myByteValue = -128;
	    byte myNewByteValue = (byte) (myByteValue / 2);
        System.out.println(myNewByteValue);

        // short has a width of 16
        short myShortValue = 32767;
        short myNewShortValue = (short)(myShortValue / 2);
        System.out.println(myNewShortValue);
        // long has a width of 64
        long myLongValue = 100L;
        long myTotalLong = 50000L +10L * (myNewByteValue + myNewShortValue + myTotal);
        System.out.println(myTotalLong);



    }
}
