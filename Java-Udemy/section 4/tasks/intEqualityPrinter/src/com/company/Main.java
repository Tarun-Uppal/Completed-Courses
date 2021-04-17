package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(printEqual(2, 3,1));
    }
    public static int printEqual(int first ,int second,int third){
        if ((first < 0) || (second < 0) || (third < 0)){
            System.out.println("invalid Value");
        }
        if ((first == second) && (second == third) && (third == second)){
            System.out.println("All  numbers are equal");
        }
        if ((first != second) && (second != third) && (first != third)){
            System.out.println("all numbers are different");
        }
        else if ((first != second) || (second != third) || (first != third)){
            System.out.println("neither are equal or different");
        }
        return 0;
        }
}
