package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
        int count=readCount();
        int[] intArray=getIntegers(count);
        int min=findMin(intArray);
        System.out.println("The minimum int value = " + min);
    }
    public static int readCount(){
        System.out.println("Enter a number");
        int values = scanner.nextInt();
        scanner.nextLine();

        return values;
    }

    public static int[] getIntegers(int number){
        System.out.println("Enter " + number + " Integer values.\n");
        int [] values = new int[number];

        for(int i=0;i<values.length;i++){
            values[i]=scanner.nextInt();
        }
        return values;
    }
    public static int findMin (int[] number){
        int smallestNumber=999999999;
        for(int i=0;i<number.length;i++){
            if(number[i]<smallestNumber){
                smallestNumber=number[i];
            }
        }
        return smallestNumber;
    }
}
