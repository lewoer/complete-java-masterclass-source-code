package com.shile;

import org.junit.Before;

import static org.junit.Assert.*;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 16:48 2019/2/14
 */
public class UtilitiesTest {

    private Utilities util;

    @Before
    public void setup() {
        util = new Utilities();
    }

    @org.junit.Test
    public void everyNthChar() {
        char[] output = util.everyNthChar(new char[]{'h','e','l','l','o'},2);
        assertArrayEquals(new char[]{'e','l'},output);
        char[] output2 = util.everyNthChar(new char[]{'h','e','l','l','o'},8);
        assertArrayEquals(new char[]{'h','e','l','l','o'},output2);


    }

    @org.junit.Test
    public void removePair() {
        assertEquals("ABCDEF",util.removePair("AABCDDEFF"));
        assertEquals("ABCABDEF",util.removePair("ABCCABDEEF"));
        assertNull("Did not return null when argument is null",util.removePair(null));
        assertEquals("A",util.removePair("A"));
        assertEquals("",util.removePair(""));

    }

    @org.junit.Test
    public void converter() {
        assertEquals(300,util.converter(10,5));
    }

    @org.junit.Test(expected = ArithmeticException.class)
    public void convert_arithmeticsException() {
        util.converter(10,0);
    }

    @org.junit.Test
    public void nullIfOddLength() {
        assertNull(util.nullIfOddLength("odd"));
        assertNotNull(util.nullIfOddLength("even"));
    }


}