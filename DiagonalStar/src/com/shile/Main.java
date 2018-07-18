package com.shile;

public class Main {

    public static void main(String[] args) {
        printSquareStar(190);
    }

    public static void printSquareStar(int number) {
        if (number < 5) {
            System.out.print("Invalid Value");
            return;
        }

        for (int y = number; y >= 1; y--) {
            for (int x = 1; x <= number; x++) {
                String string = " ";
                if (y == number || x == number || y == 1 || x == 1 || y == x || x == (number - y + 1)) {
                    string = "*";
                }
                System.out.print(string);
            }
            System.out.println();
        }
    }

}
