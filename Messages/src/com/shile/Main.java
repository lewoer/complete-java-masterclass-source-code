package com.shile;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();
    }
}

class Message {
    private String message;
    private Boolean empty = true;

    public synchronized String read() {
        while (empty) {
            try {
                wait();
            }catch (InterruptedException e) {

            }

        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void write(String message) {
        while (!empty) {
            try {
                wait();
            }catch (InterruptedException e) {

            }

        }
        empty = false;
        notifyAll();
        this.message = message;
    }
}

class Writer implements Runnable{
    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    public void run() {
        String messages[] = {
                "shile zai chifan",
                "shile shibai le",
                "shile si lian le ,hao nan shou",
                "ni qu na li le"
        };

        Random random  = new Random();  // 实例用来穿件伪随机数,random delay
        for (int i=0; i<messages.length; i++) {
            message.write(messages[i]);
            try {
                Thread.sleep(random.nextInt(2000));
            }catch (InterruptedException e) {

            }
        }
        message.write("Finished");
     }
}

class Reader implements Runnable {
    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    public void run() {
        Random random = new Random();
        for (String lastMessage = message.read(); !lastMessage.equals("Finished");
            lastMessage = message.read()) {
            System.out.println(lastMessage);
            try {
                Thread.sleep(random.nextInt(2000));
            }catch (InterruptedException e) {

            }
        }
    }
}