package com.company;

public class BankAccount {
    private String firstName;
    private String lastName;
    private double balence;

    public static final int CHECKING = 1;
    public static final int SAVINGS = 2;

    private int accountType;

    public BankAccount(String firstName, String lastName, double balence,int checking) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balence = balence;
    }

    public double deposit(double amount , boolean branch){
        balence+=amount;
        return balence;
    }

    public double withdraw(double amount,boolean branch) throws IllegalArgumentException{
        if (amount > 500 && !branch){
        throw new IllegalArgumentException();
        }else {
            balence -= amount;
            return balence;
        }
    }

    public double getBalence() {
        return balence;
    }

    public boolean isChecking(){
        return accountType != CHECKING;
    }
}
