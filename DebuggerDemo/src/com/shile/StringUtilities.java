package com.shile;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 9:48 2019/2/14
 */
public class StringUtilities {
    private StringBuilder sBuidler = new StringBuilder();
    private int charAdded = 0;

    public void addChar(StringBuilder sBuidler, char c) {
        sBuidler.append(c);
        charAdded++;
    }

    public String upperAndPrefix(String str) {
        String upper = str.toUpperCase();
        return "Prefix_" + upper;
    }
    public String addSuffix(String str) {
        return str + "_Suffix";
    }
}
