package com.shile;

public class Main {

    public static void main(String[] args) {
	    int myIntValue = 5 / 2;
	    float myFloatValue = 5f / 3f;
	    double myDoubleValue = 5d / 3d;
        // double 更加精确，java默认的就是double
        System.out.println("myIntValue = " + myIntValue);
        System.out.println("myFloatValue =" + myFloatValue);
        System.out.println("myDoubleValue = " + myDoubleValue);

        double numPounds = 200d;
        double convertedKilogram = numPounds * 0.4535927d;
        System.out.println("Kilogram = " + convertedKilogram);
    }
}
