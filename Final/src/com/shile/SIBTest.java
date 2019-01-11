package com.shile;


/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 18:42 2018/12/31
 */
public class SIBTest  {
    public static final String owner;

    static {
        owner = "shile";
        System.out.println("SIBTest static initialization block called");
    }

    public SIBTest(){
        System.out.println("SIBtest constructor called");
    }

    static {
        System.out.println("2nd static initialization called");
    }

    public void someMethod(){
        System.out.println("somemethod called");
    }
}
