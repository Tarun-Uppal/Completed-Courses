package com.company;

public class SIB {
    public static final String owner;

    static {
        owner = "Tim";
        System.out.println("SIB test initialization block called");
    }

    public SIB() {
        System.out.println("SIB constructor called");
    }

    static {
        System.out.println("Second initialization block called");
    }

    public void someMethod(){
        System.out.println("Some method called");
    }
}
