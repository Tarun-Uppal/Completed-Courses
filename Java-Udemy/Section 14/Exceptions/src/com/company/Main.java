package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        int x = 98;
//        int y = 0;
//        System.out.println(divideFAPP(x,y));
//        System.out.println(divideLBYL(x,y));
//        System.out.println(divide(x,y));
//        int x = getInt();
//        System.out.println("int x = " + x);
        int x = getIntEAPP();
        System.out.println("int x = " + x);
    }

    private static int getIntLBYL(){
        Scanner scanner = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please enter a integer");
        String input = scanner.next();
        for (int i = 0;i<input.length();i++){
            if (!Character.isDigit(input.charAt(i))){
                isValid = false;
                break;
            }
        }
        if (isValid){
            return Integer.parseInt(input);
        }

        return 0;
    }

    private static int getIntEAPP(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an integer");
        try{
            return scanner.nextInt();
        }catch (InputMismatchException e){
            return 0;
        }
    }

    private static int getInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static int divideLBYL(int x,int y){
        if (y!=0){
            return x/y;
        }else{
            return 0;
        }
    }

    private static int divideFAPP(int  x,int y){
        try{
            return x/y;
        }catch (ArithmeticException e){
            return 0;
        }
    }

    private static int divide(int x,int y){
        return x/y;
    }
}
