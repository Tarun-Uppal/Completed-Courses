package com.company;

public class Password {
    public static final int key = 748576362;
    private final int encryptedPassword;

    public Password(int encryptedPassword) {
        this.encryptedPassword = encryptDecrypt(encryptedPassword);
    }

    private int encryptDecrypt(int encryptedPassword){
        return encryptedPassword ;
    }
    public void storePassword(){
        System.out.println("Saving password as " + this.encryptedPassword);
    }

    public boolean letMeIn(int password){
        if(password == this.encryptedPassword){
            System.out.println("welcome");
            return true;
        }else{
            System.out.println("wrong password");
            return false;
        }
    }
}
