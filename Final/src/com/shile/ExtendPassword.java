package com.shile;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 18:26 2018/12/31
 */
public class ExtendPassword extends Password {
    private int decrypedPassword;

    public ExtendPassword(int password) {
        super(password);
        this.decrypedPassword = password;
    }

//    @Override
//    public void storePassword() {
//        System.out.println("Saving password as " + this.decrypedPassword);
//    }
}
