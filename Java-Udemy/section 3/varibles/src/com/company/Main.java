package com.company;

public class Main {

    public static void main(String[] args) {

        int myValue = 10000;

        int myintminvalue = Integer.MIN_VALUE;
        int myintmaxvalue = Integer.MAX_VALUE;
        System.out.println("my min int value = " + myintminvalue);
        System.out.println("my max int value = " + myintmaxvalue);
        System.out.println("busted max value = " + (myintmaxvalue + 1));
        System.out.println("busted min value = " + (myintminvalue - 1 ));
    }
}
