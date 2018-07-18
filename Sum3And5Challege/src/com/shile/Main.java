package com.shile;

import com.sun.org.apache.xml.internal.utils.SuballocatedByteVector;

public class Main {

    public static void main(String[] args) {
	    int count = 0;
	    int sum  = 0;

	    for (int i=1; i <= 1000; i++) {
	        if ((i % 3 == 0) && (i % 5 == 0)) {
	            count++;
	            sum += i;
                System.out.println("Found number = " + i);
            }

            if (count == 5) {
	            break;
            }
        }
        System.out.println("Sum = " + sum);
        System.out.println(isOdd(0));
        System.out.println(sumOdd(10,20));
    }

    public static boolean isOdd(int number) {
        return ((number > 0) && (number % 2 != 0));
    }

    public static int sumOdd(int start, int end) {
        int sum = 0;
        if ((end < start) || (start < 1 || end < 1)) {
            return -1;
        }
        for (int i=start; i <= end; i++) {
            if(isOdd(i)) {
                sum += i;
            }
        }
        return sum;
    }
}

class Dog {
    private static String name;

    // 静态变量传递到constructor
    public Dog(String name) {
        Dog.name = name;
    }
    public void printName() {
        System.out.println("name= " + name);
    }
}
public class Main {

    public static void main(String[] args) {
        // create instance rex
        Dog rex = new Dog("rex");
        // create instance fluffy
        Dog fluffy = new Dog("fluffy");
        rex.printName();  // print fluffy
        fluffy.printName(); // print fluffy
    }
}







