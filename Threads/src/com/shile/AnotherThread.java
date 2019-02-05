package com.shile;

import static com.shile.ThreadColor.ANSI_BLUE;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 12:04 2019/1/28
 */
public class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from" + currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE + "Another thread wake me up");
            return;
        }

        System.out.println(ANSI_BLUE + "Three second has passed and i'm awake");
    }
}
