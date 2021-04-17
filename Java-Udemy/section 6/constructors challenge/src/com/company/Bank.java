package com.company;

public class Bank {

    private int accountNumber;
    private int balence;
    private String customerName;
    private String email;
    private String phoneNumber;
    private int withdrawalOrDeposit;
    private int amounttowthdrawordeposit;

    public Bank (int accountNumber,int balence , String customerName , String email,
                 String phoneNumber){
        this.accountNumber=accountNumber;
        this.balence=balence;
        this.customerName=customerName;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }

    public Bank(String customerName, String email, String phoneNumber) {
        this(9999999, 1005, customerName, email, phoneNumber);
    }

    public int getAccountNumber(){

        return this.accountNumber;
    }
    public String getCustomerName(){

        return this.customerName;
    }
    public String getEmail(){

        return this.email;
    }
    public String getPhoneNumber(){

        return this.phoneNumber;
    }
    public int getAmounttowthdrawordeposit(){
        return this.amounttowthdrawordeposit;
    }
    public int getWithdrawalOrDeposit(){
        switch (withdrawalOrDeposit){
            case 1:
                if(amounttowthdrawordeposit>balence){
                    amounttowthdrawordeposit=0;
                    return balence;
                }
                else{
                    return withdraw(amounttowthdrawordeposit);
                }
            case 2:
                return deposit(amounttowthdrawordeposit);
            default:
                return 0;

        }
    }

    public int withdraw(int amounttowthdrawordeposit){
        balence-=amounttowthdrawordeposit;
        return balence;
    }
    public int deposit(int amounttowthdrawordeposit){
        balence+=amounttowthdrawordeposit;
        return balence;
    }
}
