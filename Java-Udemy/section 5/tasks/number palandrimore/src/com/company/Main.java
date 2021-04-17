package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(isPalidrome(-2112));

    }
    public static boolean isPalidrome(int number){
        int reverse =0;
        int lastDigit=0;

        do{
            lastDigit=number%10;
            reverse+=lastDigit;
           if(number == reverse){
               return true;
           }
        } while(lastDigit!=0);
        return false;
    }
}
