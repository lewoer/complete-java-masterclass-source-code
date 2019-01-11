package com.shile;

public class Main {

    public static void main(String[] args) {
	    Dog dog = new Dog("huhu");
	    dog.breath();
	    dog.eat();

	    Bird parrot = new Parrot("蓝鹦鹉");
	    parrot.eat();
	    parrot.breath();
	    parrot.fly();

	    Bird penguin = new Penguin("帝企鹅");
	    penguin.eat();
	    penguin.breath();
	    penguin.fly();
    }
}
