package com.shile;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 22:31 2019/1/29
 */
public class SharedResource {
    private Worker owner;

    public SharedResource(Worker owner) {
        this.owner = owner;
    }

    public Worker getOwner() {
        return owner;
    }

    public synchronized void setOwner(Worker owner) {
        this.owner = owner;
    }
}
