package com.company;

import java.util.ArrayList;

public class Customer {
    private String Name;
    private ArrayList<Double> transaction;

    public Customer(String name,double initialAmount) {
        Name = name;
        this.transaction = new ArrayList<Double>();
        addTransaction(initialAmount);
    }

    public void addTransaction(double amount){
        this.transaction.add(amount);
    }

    public String getName() {
        return Name;
    }

    public ArrayList<Double> getTransaction() {
        return transaction;
    }

}
