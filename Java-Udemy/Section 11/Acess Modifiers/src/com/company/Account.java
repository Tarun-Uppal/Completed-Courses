package com.company;

import java.util.ArrayList;

public class Account {
    private String accountName;
    private int balance;
    private ArrayList<Integer> transactions;

    public Account(String accountName) {
        this.accountName = accountName;
        this.transactions = new ArrayList<Integer>();
    }

    public int getBalance() {
        return balance;
    }

    public void deposit (int amount){
        if(amount > 0){
            transactions.add(amount);
            this.balance+=amount;
            System.out.println(amount + " deposited, balence is now " + this.balance);
        }else{
            System.out.println("cannot deposit negitive amount");
        }
    }

    public void withdraw (int amount){
        int withdraw =balance - amount;
        if(withdraw < 0){
            transactions.add(withdraw);
            this.balance+=withdraw;
            System.out.println(amount + " deposited, balence is now " + this.balance);
        }else{
            System.out.println("cannot withdraw negative sums");
        }
    }

    public void calculateBalence(){
        this.balance = 0;
        for(int i : this.transactions){
            this.balance +=i;
        }
        System.out.println("calculated balence is " + this.balance);
    }
}
