package com.shile;

import java.io.*;
import java.net.Socket;

/**
 * 每一个client都有一个线程使用,避免block
 */
public class Echoer extends Thread {
    private Socket socket;

    public Echoer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true );
            while (true) {
                String echoString = input.readLine();
                System.out.println("Received client input: " + echoString);
                if (echoString.equals("exit")) {
                    break;
                }
                try {
                    Thread.sleep(15000);
                }catch (InterruptedException e) {
                    System.out.println("Interruption :" +e.getMessage());
                }
                output.println(echoString);
            }

        }catch (IOException e) {
            System.out.println("oops: " +e.getMessage());
        }finally {
            try {
                socket.close();
            }catch (IOException e) {
                // enenenne
            }
        }
    }
}
