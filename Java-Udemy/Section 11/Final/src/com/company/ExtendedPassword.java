package com.company;

public class ExtendedPassword extends Password{
    private int decryptedPassword;

    public ExtendedPassword(int password) {
        super(password);
        this.decryptedPassword = password;
    }

    @Override
    public final void storePassword() {
        System.out.println("Saving password as " + this.decryptedPassword);
    }
}
