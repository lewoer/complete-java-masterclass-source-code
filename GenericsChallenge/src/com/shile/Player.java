package com.shile;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 21:47 2018/12/18
 */
public abstract class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
