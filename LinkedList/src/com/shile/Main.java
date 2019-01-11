package com.shile;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    Customer customer = new Customer("tim", 54.87);
	    Customer anotherCustomer;
	    // java将内存地址保存，并没有创建一个新的类
	    anotherCustomer = customer;
	    // 第二个类仅仅是对第一个类的更新
	    anotherCustomer.setBalance(12.99);
        System.out.println("balance for a customer " + customer.getName() + " is " + customer.getBalance());


        ArrayList<Integer> intList = new ArrayList<Integer>();

        intList.add(1);
        intList.add(3);
        intList.add(4);
        for (int i = 0; i< intList.size(); i++) {
            System.out.println(i + ": " + intList.get(i));
        }
        // 结果显示插入了元素，插入元素后，原来的元素就会移动位置来为新的元素腾出空间
        // 那如果数据很大的话，增加或删除会增加很大的开销。
        intList.add(1,2);
        for (int i = 0; i< intList.size(); i++) {
            System.out.println(i + ": " + intList.get(i));
        }
    }
}
