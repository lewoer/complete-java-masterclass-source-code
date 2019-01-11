package com.shile;

public class Main {

    public static void main(String[] args) {
	    String varFour = "this is private to main()";

	    ScopeCheck scopeInstance = new ScopeCheck();
	    scopeInstance.useInner();

	    ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
        System.out.println("varThree is not accessable here " + innerClass.varthree);
        System.out.println("ScopeInstance's varOne is " + scopeInstance.getVarOne());
//        System.out.println(varFour);
//
//        scopeInstance.timeTwo();
//        System.out.println("******************************");
//        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
//        innerClass.timeTwo();
    }
}
