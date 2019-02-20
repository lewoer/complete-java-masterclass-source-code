package com.shile;
import java.io.IOException;
import java.net.ServerSocket;


public class Main {

    public static void main(String[] args) {

        try(ServerSocket serverSocket = new ServerSocket(5000)) {
            while (true) {
                // accept监听一个到这个socket的连接, 如果监听成功,这个方法就会返回一个socket, 而且blcok
                new Echoer(serverSocket.accept()).start();
            }
        }catch (IOException ioe) {
            System.out.println("Server exception: " + ioe.getMessage());
        }
    }
}
