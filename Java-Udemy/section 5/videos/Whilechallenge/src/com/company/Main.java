package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(isEvenNumber(10));

    }
    public static boolean isEvenNumber(int no){
    while(true){
    if(no%2==0){
        return true;

    }
    return false;
    }
    }
}
