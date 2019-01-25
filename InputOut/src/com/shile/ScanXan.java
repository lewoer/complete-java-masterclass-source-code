package com.shile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 19:33 2019/1/19
 */
public class ScanXan {
    public static void main(String[] args) throws IOException {
        System.out.format("%f, %1$+020.10f %n", Math.PI);
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("xanadu.txt")));

            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
