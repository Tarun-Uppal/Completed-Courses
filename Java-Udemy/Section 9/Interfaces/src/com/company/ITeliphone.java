package com.company;

public interface ITeliphone {
    void powerOn();
    void dial(int phoneNumber);
    void answer();
    boolean callPhone(int phoneNumber);
    boolean idRinging();

}
