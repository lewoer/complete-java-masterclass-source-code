package com.shile;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 23:22 2019/1/2
 */
public class Moon extends HeavenlyBody {
    public Moon(String name, double orbintalPeriod) {
        super(name, orbintalPeriod, BodyTypes.MOON);
    }
}
