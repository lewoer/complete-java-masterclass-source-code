package com.shile;

//public class BarkingDog {
//    public static void main(String[] args) {
//        bark(true, 1);
//        bark(false, 2);
//        bark(true, 8);
//        bark(true, -1);
//
//    }
//
//    public static boolean bark(boolean barking, int hourOfDay) {
//        if (hourOfDay < 0 || hourOfDay > 23) {
//            return false;
//        }
//        return barking && (hourOfDay < 8 || hourOfDay > 22);
//    }
//}

public class DecimalComparator{
    public static boolean areEqualByThreeDecimalPlaces(double numOne, double numTwo) {
        return (int) (numOne * 1000) == (int) (numTwo * 1000);
    }
}














