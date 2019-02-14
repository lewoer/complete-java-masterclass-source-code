package com.shile;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 17:43 2019/2/14
 */
@RunWith(Parameterized.class)
public class UtilitiesTestParametrized {
    private Utilities util;
    private String input;
    private String output;

    @org.junit.Before
    public void setup() {
        util = new Utilities();
    }

    public UtilitiesTestParametrized(String input, String output) {
        this.input = input;
        this.output = output;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][]{
                {"ABCDEFF","ABCDEF"},
                {"AB88EFFG","AB8EFG"},
                {"112233445566","123456"},
                {"A","A"}
        });
    }

    @org.junit.Test
    public void removePairs() {
        assertEquals(output,util.removePair(input));
    }
}
