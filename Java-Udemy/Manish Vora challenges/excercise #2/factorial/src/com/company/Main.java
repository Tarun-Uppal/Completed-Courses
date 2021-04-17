package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter a number");
        int number = scanner.nextInt();
        scanner.nextLine();
        scanner.close();

        int factorial=1;

        if(number>=0){
            for(int i=1;i!=number+1;i++){

                factorial*=i;
            }
            System.out.println("the factorial of "+ number + " is "+ factorial);
        }
        else{
            System.out.println("Undefined");
        }

    }
}
