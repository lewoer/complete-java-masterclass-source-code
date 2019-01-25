package com.shile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 16:51 2019/1/19
 */
public class CopyBytes {
    public static void main(String[] args) throws IOException {
        double start = System.currentTimeMillis();
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("xanadu.txt");
            out = new FileOutputStream("outagain.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            System.out.println((System.currentTimeMillis() - start) / 1000);
        }
    }
}
