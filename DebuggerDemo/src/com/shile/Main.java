package com.shile;

public class Main {

    /**
     * allpication runing out of memory: we appending the charactor to the
     * StringUtilities instance rather StringBuilder.
    * */

    public static void main(String[] args) {
        StringUtilities utils = new StringUtilities();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 10) {
            utils.addChar(sb,'a');
        }
        System.out.println(sb);

        String str = "abcdefg";
        String result = utils.upperAndPrefix(utils.addSuffix(str));
    }
}
