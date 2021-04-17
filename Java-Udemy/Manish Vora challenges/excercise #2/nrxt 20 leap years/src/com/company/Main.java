package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("enter a year ");
        int year = scanner.nextInt();
        scanner.nextLine();
        scanner.close();
        int nooftimes=0;
        while(true) {
            year++;
            if ((year % 4 == 0) || (year % 100 == 0) && (year % 400 == 0)) {
                System.out.println(year);
                nooftimes++;
                if(nooftimes==20){
                    break;
                }
            }
        }

    }
}
