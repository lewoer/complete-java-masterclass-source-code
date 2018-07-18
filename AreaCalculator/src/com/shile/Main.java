package com.shile;

public class Main {

    private static final double PI = 3.14159;
    private static final String INVALID_STRING_MESSAGE = "invalid value";

    public static void main(String[] args) {
        System.out.println(area(5.0));
        System.out.println(area(-1));
        System.out.println(area(5.0,4.0));
        System.out.println(area(-1.0,4.0));

    }

    public static double area(double radius) {
        if (radius < 0) {
            return -1.0;
        }

        double areaOfCircle = PI * radius * radius;
        return areaOfCircle;
    }

    public static double area(double x, double y) {
        if(x < 0 || y < 0) {
            return  -1.0;
        }

        double areaOfRectangle = x * y;
        return areaOfRectangle;
    }

}

