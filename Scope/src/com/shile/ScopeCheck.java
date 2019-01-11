package com.shile;

/**
 * @Author: ShiLe
 * @Description: 变量的作用域仅仅限于封闭的括号之内。而inner class的field的scope是重写class的作用域，overwrite。
 *              而this的使用可以跳过local variable直接使用field
 * @Date: Created in 16:54 2018/12/30
 */
public class ScopeCheck {
    public int publicVar = 0;
    private int varOne = 1;

    public ScopeCheck() {
        System.out.println("ScopeCheck created , publicVar = " + publicVar + " : varOne" + varOne);
    }

    public int getVarOne() {
        return varOne;
    }

    public void timeTwo() {
        int varTwo = 2;

        for (int i=0; i<10; i++) {
            // 使用this可以跳过上诉变量使用 private变量
            System.out.println(i + " time two is " + i * varTwo);
        }
    }

    public void useInner() {
        InnerClass innerClass = new InnerClass();
        System.out.println("Varthree from outter class:" + innerClass.varthree);
    }

    public class InnerClass {
        private int varthree = 3;  // overwrite上诉的private varOne

        public InnerClass() {
            System.out.println("InnerClass created , varThree is " + varthree + " and varOne is " + varOne);
        }

        public void timeTwo() {
            System.out.println("varOne is still avaialable here " + varOne);
            for (int i=0; i<10; i++) {
                // 使用this可以跳过上诉变量使用 private变量
                System.out.println(i + " time two is " + i * varthree);
            }
        }
    }

}
