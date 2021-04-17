package com.company;

public class Main {

    public static void main(String[] args) {
	  String varFour = "this is a private to main()";

	  ScopeCheck scopeCheck = new ScopeCheck();
	  scopeCheck.useInner();
        System.out.println("ScopeCheck.privateVar is " + scopeCheck.getVar1());
        System.out.println(varFour);

        scopeCheck.timeTwo();

        ScopeCheck.InnerClass innerClass = scopeCheck.new InnerClass();

        innerClass.timeTwo();
    }
}

