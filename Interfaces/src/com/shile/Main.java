package com.shile;

public class Main {

    public static void main(String[] args) {
        ITelephone lewoerPhone;
        lewoerPhone = new DeskPhone(123456);
        lewoerPhone.powerOn();
        lewoerPhone.callPhone(123456);
        lewoerPhone.anwser();

        lewoerPhone = new MobilePhone(23456);
        lewoerPhone.powerOn();
        lewoerPhone.callPhone(23456);
        lewoerPhone.anwser();




    }
}
