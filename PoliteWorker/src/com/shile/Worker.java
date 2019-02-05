package com.shile;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 22:31 2019/1/29
 */
public class Worker {
    private String name;
    private Boolean active;

    public Worker(String name, Boolean active) {
        this.name = name;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public Boolean isActive() {
        return active;
    }

    public synchronized void work(SharedResource sharedResource, Worker otherWorker) {
        while (active) {
            if (sharedResource.getOwner() != this) {
                try {
                    wait(10);
                }catch (InterruptedException e) {

                }
                continue;
            }

            if (otherWorker.isActive()) {
                System.out.println(this.getName() + " : give the resource to the worker" + otherWorker.getName());
                sharedResource.setOwner(otherWorker);
                continue;
            }

            System.out.println(this.getName() + " : working on commen resource");
            active = false;
            sharedResource.setOwner(otherWorker);
        }
    }
}
