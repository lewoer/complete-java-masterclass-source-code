package com.shile._static;

/**
 * @Author: ShiLe
 * @Description: static field,每一个类中只有一个这样field，被所有实例共享。static field属于类
 *               而不是任何单独的个体
 * @Date: Created in 15:05 2018/12/31
 */
public class StaticTest {
    private static int numInstance = 0;
    private String name;

    public StaticTest(String name) {
        this.name = name;
        numInstance++;
    }

    public static int getNumInstance() {
        return numInstance;
    }

    public String getName() {
        return name;
    }
}
