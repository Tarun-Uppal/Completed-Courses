package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("please enter the number of numbers you want to be shown ");
        int noOfTimes = scanner.nextInt();
        scanner.close();

        int fib1=1;
        int fib2=0;



        while (true) {
            fib1=fib2+fib1;
            noOfTimes--;
            System.out.println(fib1);
            if(noOfTimes==0){
                break;
            }
            fib2=fib1+fib2;
            noOfTimes--;
            System.out.println(fib2);
            if(noOfTimes==0){
                break;
            }
        }
        }

    }

