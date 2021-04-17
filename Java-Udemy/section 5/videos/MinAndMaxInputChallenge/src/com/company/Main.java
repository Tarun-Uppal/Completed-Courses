package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int MaxValue=0;
        int MinValue=Integer.MAX_VALUE;

        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("Enter number :");
            boolean hasNextInt = scanner.hasNextInt();


            if(hasNextInt) {
                int number = scanner.nextInt();

                if (MaxValue < number) {
                    MaxValue = number;
                }
                if (MinValue > number) {
                    MinValue = number;
                }
            }
            else{
                System.out.println("Invalid Value");
                break;
            }
        }
        scanner.close();
        System.out.println("maximum value = "+ MaxValue +" minimum value = "+ MinValue);


    }
}
