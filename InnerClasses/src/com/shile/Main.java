package com.shile;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {
//        class ClickListener implements Button.OnClickListener {
//            public ClickListener() {
//                System.out.println(" I've been attached");
//            }
//            @Override
//            public void onClick(String title) {
//                System.out.println(title + " was clicked");
//            }
//        }
//        btnPrint.setOnClickListener(new ClickListener());
        /*匿名类相当于一个参数传入一个方法*/
        btnPrint.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        });
        listen();

    }
    private static void listen() {
        boolean quit = false;
        while (!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    btnPrint.OnClick();
            }
        }
    }
}
