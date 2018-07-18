package com.shile;

public class Main {

    private static final String INVALID_MESSAGE = "Invalid Value";

    public static void main(String[] args) {
	    printYearsAndDays(30000);
	    printYearsAndDays(525600);
	    printYearsAndDays(-1111);
    }
    public static void printYearsAndDays(long minutes) {

        long years = minutes / (60 * 24 * 365);
        long days = minutes % (60 * 24 * 365) / (24 * 60);
        if (minutes < 0) {
            System.out.println(INVALID_MESSAGE);
        } else {
            System.out.println(minutes + " min = " + years + " y and " + days + " d");
        }
    }
}
