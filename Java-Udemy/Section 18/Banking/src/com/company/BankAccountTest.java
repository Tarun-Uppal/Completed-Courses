package com.company;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class BankAccountTest {

    private BankAccount account = new BankAccount("Tim","Buchalka",1000.0,BankAccount.CHECKING);
    private static int count = 0;

    @org.junit.jupiter.api.BeforeAll
    public static void beforeAll(){
        System.out.println("this executes only once : count = " + (count++));
    }

    @org.junit.jupiter.api.Test
    void deposit() {
       account.deposit(200.0,true);
       assertEquals(1200,account.getBalence(),0);
    }

    @org.junit.jupiter.api.Test
    void withdraw() throws Exception {
        double balence = account.withdraw(600.00,true);
        assertEquals(400,balence,0);
    }

    @org.junit.jupiter.api.Test
    void getBalence_deposit() {
        account.deposit(200.0,true);
        assertEquals(1200,account.getBalence(),0);
    }

    @org.junit.jupiter.api.Test
    void getBalence_withdraw() {
        account.withdraw(200.0, true);
        assertEquals(800, account.getBalence(), 0);
    }

    @org.junit.jupiter.api.Test
    public void isChecking_true(){
        assertTrue(account.isChecking());
    }

    @org.junit.jupiter.api.AfterAll
    public static void afterAll(){
        System.out.println("this executes after all : count : " + (count++));
    }
}

