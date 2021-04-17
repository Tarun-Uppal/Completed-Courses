package com.company;

public class Main {

    public static void main(String[] args) {
	 Account timsAccount = new Account("Tim");
	 timsAccount.deposit(1000);
	 timsAccount.withdraw(500);
	 timsAccount.withdraw(-200);
	 timsAccount.deposit(-20);
	 timsAccount.calculateBalence();

        System.out.println("balance in account is " + timsAccount.getBalance());
    }
}
