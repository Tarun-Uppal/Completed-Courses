package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("enter a number");

        int number = scanner.nextInt();

        scanner.nextLine();
        scanner.close();
        System.out.println(isdividisibleby7(number));

    }
    public static boolean isdividisibleby7(int number){
        int number2=0;
        while(true){

            if(number>=0 && number<=70){
                if(number%7==0){
                    return true;
                }
                else{
                    return false;
                }
            }

        number2=number%10;
        number2*=2;
        number-=number2;

        }

    }
}
