package com.shile;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 15:14 2019/2/14
 */
public class Utilities {
    // return a char array containing every nth char. When sourceArray.length < n, return source Array.
    public char[] everyNthChar(char[] sourceArray, int n) {

        if (sourceArray == null || sourceArray.length < n) {
            return sourceArray;
        }
        int returnedLength = sourceArray.length / n;
        char[] result = new char[returnedLength];
        int index = 0;
        for (int i = n-1; i<sourceArray.length; i += n) {
            result[index++] = sourceArray[i];
        }
        return result;
    }

    // remove pair of the same character that are next to each other,
    // by removing on a occruance of the character
    // "ABBCDEEF" -> "ABCDEF"
    // "ABCBDEEF" -> "ABCBEF"
    public String removePair(String source) {
        // if length is less than 2 , there won't be any pairs
        if (source == null || source.length() < 2) {
            return source;
        }

        StringBuilder sb = new StringBuilder();
        char[] string = source.toCharArray();
        for (int i=0; i<string.length-1; i++) {
            System.out.println(string[i]);  //
            if (string[i] != string[i + 1]) {
                sb.append(string[i]);
            }
        }
        System.out.println(string[string.length -1]);
        // add the final character , which is always safe
        sb.append(string[string.length -1]);
        return sb.toString();
    }

    public int converter(int a, int b) {
        return (a/b) + (a*30) - 2;
    }

    public String nullIfOddLength(String source) {
        if (source.length() % 2 == 0) {
            return source;
        }
        return null;
    }
}
