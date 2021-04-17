package com.company;

public class Customer {
    private String name;
    private double balence;

    public Customer(String name, double balence) {
        this.name = name;
        this.balence = balence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalence() {
        return balence;
    }

    public void setBalence(double balence) {
        this.balence = balence;
    }
}
