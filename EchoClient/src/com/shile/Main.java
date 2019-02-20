package com.shile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    try(Socket socket = new Socket("127.0.0.1",5000)) {
	        socket.setSoTimeout(5000);
            BufferedReader echoes = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String echoString;
            String response;

            do {
                System.out.println("Enter String to be echoed: ");
                echoString = scanner.nextLine();

                stringToEcho.println(echoString);
                if (!echoString.equals("exit")) {
                    response = echoes.readLine();
                    System.out.println(response);
                }


            }while (!echoString.equals("exit"));


        }catch (SocketTimeoutException ste) {
            System.out.println("The socket timeed out");
        }
	    catch (IOException ioe) {
            System.out.println("Client error: " + ioe.getMessage());
        }
    }
}
