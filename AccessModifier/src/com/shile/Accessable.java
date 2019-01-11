package com.shile;

/**
 * @Author: ShiLe
 * @Description: 访问权限为package-private
 * @Date: Created in 0:48 2018/12/31
 */
interface Accessable {
    int SOME_CONSTANT = 10; // public static final
    public void methodA();  // interface里面都是public

}
