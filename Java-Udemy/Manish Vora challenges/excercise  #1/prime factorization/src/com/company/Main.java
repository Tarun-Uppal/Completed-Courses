package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter a number");
        int number = scanner.nextInt();
        scanner.nextLine();
        scanner.close();

        if (0<=number){
                for(int primefactor = 2; primefactor< number; primefactor++) {
                    while(number%primefactor == 0) {
                        System.out.println(primefactor+" ");
                        number = number/primefactor;
                    }
                }
                if(number >2) {
                    System.out.println(number);
                }
        }
    }
}
