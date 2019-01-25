package com.shile;

import java.io.*;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 18:21 2019/1/19
 */
public class CopyLine {
    public static void main(String[] args) throws IOException{
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("xanadu.txt"));
            outputStream = new PrintWriter(new FileWriter("characteroutput.txt"));

            String s;
            while ((s = inputStream.readLine()) != null) {
                outputStream.println(s);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream !=null) {
                outputStream.close();
            }
        }
    }
}
