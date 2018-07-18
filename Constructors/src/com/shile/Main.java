package com.shile;

public class Main {

    public static void main(String[] args) {

//        Account bobsAccount = new Account();//"12345", 0.00, "Bob Brown",
//               // "shile4408@126.com", "18722580672");
//
//        System.out.println(bobsAccount.getNumber());
//        System.out.println(bobsAccount.getBalance());
//
//        bobsAccount.withdrawal(100.0);
//
//        bobsAccount.deposit(50.0);
//        bobsAccount.withdrawal(100);
//
//        bobsAccount.deposit(51.0);
//        bobsAccount.withdrawal(100.0);
//
        Account timsAccount = new Account("tim", "sih@126.com", "12345");
        System.out.println(timsAccount.getNumber() + " name " + timsAccount.getCustomerName());
        System.out.println("current balance is " + timsAccount.getBalance());
        timsAccount.withdrawal(100.55);


//        VipPerson person1 = new VipPerson();
//        System.out.println(person1.getName());
//
//        VipPerson person2 = new VipPerson("Bob", 25000.00);
//        System.out.println(person2.getName());
//
//        VipPerson person3 = new VipPerson("shile", 100, "lewoer@emai.com");
//        System.out.println(person3.getName());
    }
}
