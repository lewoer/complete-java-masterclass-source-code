package com.shile;

public class Main {

    public static void main(String[] args) {
//	int pw = 434343;
//	Password password = new ExtendPassword(pw);
//	password.storePassword();
//
//	password.letMeIn(1);
//	password.letMeIn(34);
//	password.letMeIn(-1);
//	password.letMeIn(434343);

		System.out.println("Main method called");

		SIBTest sibTest = new SIBTest();
		sibTest.someMethod();
		System.out.println("owner is " + SIBTest.owner);



    }
}
