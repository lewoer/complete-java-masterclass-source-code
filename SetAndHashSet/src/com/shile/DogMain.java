package com.shile;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 17:50 2019/1/2
 */
public class DogMain {
    public static void main(String[] args) {
        Labrador rover = new Labrador("Rover");
        Dog rover1 = new Dog("Rover");

        System.out.println(rover.equals(rover1));
        System.out.println(rover1.equals(rover));
    }
}
