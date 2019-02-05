package com.shile;

import static com.shile.ThreadColor.ANSI_PURPLE;
import static com.shile.ThreadColor.ANSI_RED;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello form main thread");
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("==Another Thread==");
        /*如果直接调用run()会执行main thread, 所以应该使用start()*/
        anotherThread.run();

        new Thread() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "hello from anonymous class");
            }
        }.start();

        Thread myRunableThread = new Thread(new MyRunable()) {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anonymous class's implementation of run()");
                try {
                    anotherThread.join();  // Waits for this thread to die
                    System.out.println(ANSI_RED + "AnotherThread terminated or time out .so i'm runing again");
                }catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "I could't wait after all. I was interrupted" );
                }
            }
        };
        myRunableThread.start();
//        anotherThread.interrupt();

        System.out.println(ANSI_PURPLE + "Hello again fron main thread");

    }
}
