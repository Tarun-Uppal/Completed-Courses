package com.company;

public class Main {

    public static void main(String[] args) {
//        System.out.println("10,000 at 2% intrest = " + calculateIntrest(10000,2));
//      for (int i =0; i<5; i++){
//            System.out.println("loop " + i + " hello");
//        }
        for (int i =2;i < 9;i++){
            System.out.println("10,000 at "+ i +" intrest = " + calculateIntrest(10000,i));
        }
        System.out.println("******************************");
        for (int i =8;i > 2;i--){
            System.out.println("10,000 at "+ i +" intrest = " + calculateIntrest(10000,i));
        }
    }
    public static double calculateIntrest(double amount, double intrestrate){
        return(amount*(intrestrate/100));



    }
}
