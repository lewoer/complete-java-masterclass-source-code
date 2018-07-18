package com.shile;

public class Main {

    public static void main(String[] args) {
        System.out.println(getGreatCommonDivisor(25, 15));
        System.out.println(getGreatCommonDivisor(12, 30));
        System.out.println(getGreatCommonDivisor(9, 18));
        System.out.println(getGreatCommonDivisor(81, 153));

    }
    // 欧几里得算法GCD(a,b)=GCD(b,r),a,b的最大公约数也是b的r的最大公约数
    public static int remainder(int a, int b) {
        return a % b;
    }

    public static int getGreatCommonDivisor(int numOne, int numTwo) {
        if (numTwo == 0) {
            return numOne;
        }
        return getGreatCommonDivisor(numTwo, remainder(numOne, numTwo));
    }


}
