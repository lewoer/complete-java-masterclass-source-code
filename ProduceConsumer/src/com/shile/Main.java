package com.shile;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.shile.Main.EOF;

/**
 * 一.synchronized 能够避免thread interference,但是它也有缺点
 * 1. 阻塞的线程等待去执行不能打断的synchronize代码,一旦它们阻塞,它们停在那里,直到它们得到object lock
 * 2. synchronized block必须在同一个方法里.
 * 3. 我们不能测试, 去看是否一个对象的内在锁可用或找出有关该锁的任何其他信息.当我们抵达同步锁的开始,
 * 我们等待lock一段时间,之后如果lock不可用,我们不能timeout.
 * 4. 如果多个线程等待获取lock,不是先来先得.第一个阻塞的线程可以是最后一个获取lock的线程.
 * <p>
 * 二,使用try finally 确保释放锁
 * 三,java.util.concurrent.locks 中 ReentrantLock代替synchronize
 */
public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);
//        ReentrantLock bufferLock = new ReentrantLock();
        /*Thread pool适合于大量线程的程序,应为应用它们可以使JVM优化线程管理.
         * java.util.concurrent 中的大多数executor实现都使用由Worker Thread组成的Thread pool.这种线程与Runnable,Callable 任务分别存在
         * */
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        /*Future用来代表异步计算的结果,它的方法用来检查是否计算完成,等待计算,检索计算结果(get())*/
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {  // 计算结果
                System.out.println(ThreadColor.ANSI_WHITE + "I'm being printed for Callable class");
                return "This is callable result";
            }
        });
        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("Something went wrong");
        } catch (InterruptedException e) {
            System.out.println("Thread runing the task was interrupted");
        }
        executorService.shutdown();
    }
}

class MyProducer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding ..." + num);
                buffer.put(num);

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }
        System.out.println(color + "Adding EOF and Existing..");
        try {
            buffer.put("EOF"); // ArrayList isn't thread safe, cause thread interference
        } catch (InterruptedException e) {

        }
    }
}

class MyConsumer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        while (true) {
            /* 如果lock是自由的可以被当前线程获得或是lock早已被当前线程获取,返回true*/

            /*我们使用isEmpty检查容器是否为空,如果不为空,我们peek()获取下一个元素.但是,Myconsumer 线程可以挂起,当calling为空
            * 调用peek(),此时这个线程挂起,而另外的Myconsumer线程从队列中获取下一个元素,这时上一个线程再次运行peek()返回为null,
            * 结果得到NullPointerException.
             *
             * 所以即使thread-safe(如ArrayBlockingQueue)也要添加synchronized 代码*/
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take()); // take():检索并移去队列头部,返回队列的头部
                    }
                } catch (InterruptedException e) { }
            }
        }
    }
}
