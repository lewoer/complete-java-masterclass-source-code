package com.shile;

import java.io.IOException;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 22:15 2019/1/6
 */
public class TestException {
    public static void main(String[] args) throws IOException {
        try {
            a();

        } catch (IOException ioe) {
            StackTraceElement[] stackTrace = ioe.getStackTrace();
            for (int i = 0; i < stackTrace.length; i++) {
                System.err.println("Exception thrown from " +
                        stackTrace[i].getMethodName() + " in class " +
                        stackTrace[i].getClassName() + " on line " +
                        stackTrace[i].getLineNumber() + " of file " +
                        stackTrace[i].getFileName());
                System.err.println();
            }
        }
    }


    static void a() throws IOException {
        b();
    }

    static void b() throws IOException {
        throw new IOException();
    }
}