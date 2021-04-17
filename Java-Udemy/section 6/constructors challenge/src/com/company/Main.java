package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


//            Bank dad = new Bank(100, 10, "uolhgb", "uogjl",
//                    "8534");
//
//        Bank mom=new Bank("huoi","vuggb","yglikyhb");

VipCustomer person1=new VipCustomer();
        System.out.println(person1.getName());
        VipCustomer person2= new VipCustomer("ikbgkl",2059999);
        System.out.println(person2.getName());
        VipCustomer person3=new VipCustomer("oljnml",207777,"9ihy7un,mjul9o");
        System.out.println(person3.getName());
    }
}
