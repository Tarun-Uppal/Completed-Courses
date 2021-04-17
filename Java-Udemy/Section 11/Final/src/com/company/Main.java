package com.company;

public class Main {

    public static void main(String[] args) {
//	SomeClass someClass1 = new SomeClass("One");
//	SomeClass someClass2 = new SomeClass("Two");
//	SomeClass someClass3 = new SomeClass("Three");
//

//		System.out.println(Math.PI);

//        int pw = 674312;
//        ExtendedPassword password = new ExtendedPassword(pw);
//
//    password.letMeIn(1);
//    password.letMeIn(213);
//    password.letMeIn(998);
//    password.letMeIn(674312);

        System.out.println("main method called");
        SIB test = new SIB();
        test.someMethod();
        System.out.println("owner is " + SIB.owner);
    }

}
