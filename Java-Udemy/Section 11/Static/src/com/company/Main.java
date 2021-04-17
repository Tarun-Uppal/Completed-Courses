package com.company;

public class Main {

    public static void main(String[] args) {
	StaticTest firstInstance = new StaticTest("1st Instance");
        System.out.println(firstInstance.getName()+" number " + firstInstance.getNumInstances());

        StaticTest secondInstance = new StaticTest("2nd Instance");
        System.out.println(secondInstance.getName()+" number " + secondInstance.getNumInstances());

        StaticTest thirdInstance = new StaticTest("3rd Instance");
        System.out.println(thirdInstance.getName()+" number " + thirdInstance.getNumInstances());
    }
}
