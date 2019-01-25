package com.shile;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 17:49 2019/1/19
 */
public class CopyCharacters {
    public static void main(String[] args) throws IOException {
        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("xanadu.txt");
            outputStream = new FileWriter("characteroutput.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
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
