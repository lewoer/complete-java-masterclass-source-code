package com.shile;

import java.util.ArrayList;

class intClass {

    // 创建了一个包装类
    private int myValue;

    public intClass(int myValue) {
        this.myValue = myValue;
    }

    public int getMyValue() {
        return myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
    }
}

public class Main {

    public static void main(String[] args) {
        String[] strArray = new String[10];
        int[] intArray = new int[10];

        // String是一个类
        ArrayList<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add("tim");
        stringArrayList.remove(0);

        // 如果没有包装类的话，就需要这样创建int类型的ArrayList
        ArrayList<intClass> intClassArrayList = new ArrayList<intClass>();
        intClassArrayList.add(new intClass(10));
        Integer integer = new Integer(10);
        Double doubleValue = new Double(12.22);

        ArrayList<Integer> intArrayList = new ArrayList<Integer>();

//        for (int i=0; i<=10; i++) {
//            intArrayList.add(Integer.valueOf(i));
//        }
//        for (int i=0; i<=10; i++) {
//            System.out.println(i + " --> " + intArrayList.get(i).intValue());
//        }

        Integer myIntValue =  56; // Integer.valueOf(56);
        // Returns the value of this Integer as an int
        int myInt = myIntValue.intValue();  // myIntValue.intValue

        ArrayList<Double> myDoubleValue  = new ArrayList<Double>();
        for (double dbl=0.0; dbl<=10.0; dbl+=0.5) {
            myDoubleValue.add(dbl);
        }
        for (int i=0; i<myDoubleValue.size(); i++) {
            double value = myDoubleValue.get(i);
            System.out.println(i + " --> " + value);
        }
    }
}
