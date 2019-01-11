package com.shile;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 18:15 2018/12/31
 */
public class Password {
    private static final int KEY = 769303765;
    private final int encryptedPassword;

    public Password(int password) {
        this.encryptedPassword = encryptDecrypt(password);
    }

    private int encryptDecrypt(int password) {
        return password * KEY;
    }

    public final void storePassword() {
        System.out.println("Saving password " + this.encryptedPassword);
    }

    public boolean letMeIn(int password) {
        if (encryptDecrypt(password) == this.encryptedPassword) {
            System.out.println("welcome");
            return true;
        } else {
            System.out.println("Nope,you can't come in ");
            return false;
        }
    }
}
