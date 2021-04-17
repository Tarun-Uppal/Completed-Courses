package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("Tarun",500.20);
        Customer anotherCustomer;
        anotherCustomer = customer;
        anotherCustomer.setBalence(300.12);
        System.out.println(customer.getBalence() + " *** " + anotherCustomer.getBalence());

        ArrayList<Integer> intList = new ArrayList<>();

        intList.add(1);
        intList.add(3);
        intList.add(4);
        for (int i = 0; i < intList.size();i++){
            System.out.println(intList.get(i));
        }
        System.out.println("*****");

        intList.add(1,2);

        for (int i = 0; i < intList.size();i++){
            System.out.println(intList.get(i));
        }
    }
}
