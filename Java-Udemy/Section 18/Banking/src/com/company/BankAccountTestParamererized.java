package com.company;


public class BankAccountTestParamererized {

    private BankAccount account;
    @org.junit.jupiter.api.BeforeEach
    public void beforeEach(){
        account = new BankAccount("Tim","Buchalka",1000,BankAccount.CHECKING);
        System.out.println("Running a test");
    }
}
