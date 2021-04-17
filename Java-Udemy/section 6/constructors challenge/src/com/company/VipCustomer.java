package com.company;

public class VipCustomer {
    private String name;
    private int creditLimit;
    private String email;

    public VipCustomer(){
        this("unkown",50000,"fault@email.com");
    }
    public VipCustomer(String name,int creditLimit){

        this(name,creditLimit,"unkown@email.com");
    }
    public VipCustomer(String name , int creditLimit ,String email){
        this.name=name;
        this.creditLimit=creditLimit;
        this.email=email;
    }

    public String getName() {
        return name;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }
}
