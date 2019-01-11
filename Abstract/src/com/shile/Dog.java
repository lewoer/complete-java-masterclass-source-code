package com.shile;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 21:54 2018/12/15
 */
public class Dog extends Animal {
    public Dog(String name) {
        super(name);  // 调用父类构造器
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating");
    }

    @Override
    public void breath() {
        System.out.println("breath in , breath out ,repeat");

    }
}
