package com.shile;

import static com.shile.ThreadColor.ANSI_RED;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 14:35 2019/1/28
 */
public class MyRunable implements Runnable {
    @Override
    public void run() {
        System.out.println(ANSI_RED + "Hello from myRunable implementation of run()");
    }
}
