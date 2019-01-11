package com.shile;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 22:14 2018/12/15
 */
public class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        super.fly();
        System.out.println("擅长游泳，不怎么会飞");
    }
}
