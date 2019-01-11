package com.shile;

/**
 * @Author: ShiLe
 * @Description: 抽象类可以有filed和具体的方法
 * @Date: Created in 21:48 2018/12/15
 */
public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }
    public abstract void eat();
    public abstract void breath();

    public String getName() {
        return name;
    }
}
