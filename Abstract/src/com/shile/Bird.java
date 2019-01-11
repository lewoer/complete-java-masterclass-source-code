package com.shile;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 22:04 2018/12/15
 */
public abstract class Bird extends Animal implements CanFly{
    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is pecking");  // peck 啄食
    }

    @Override
    public void breath() {
        System.out.println("breath in, breath out , repeat");

    }

    @Override
    public void fly() {
        System.out.println(getName() + " is flaping to wings");
    }
}
