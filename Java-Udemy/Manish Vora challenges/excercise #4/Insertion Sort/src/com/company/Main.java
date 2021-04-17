package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] array = inputNumbers();
        array = sortIntegers(array);
        for(int i = 0;i < array.length;i++){
            System.out.println(array[i]);
        }
    }
    public static int[] sortIntegers(int[] array) {

        int valuePosition;
        int value;

        for (int i = 1 ;i<array.length;i++){

            value = array[i];
            valuePosition = i;

            while (valuePosition > 0 && array[ valuePosition - 1] >value) {

                array[valuePosition] = array[valuePosition - 1];
                
                valuePosition = valuePosition - 1;
            }

            array[valuePosition] = value;

        }

        return array;
    }

    public static int[] inputNumbers(){
        System.out.print("please enter the number of numbers you want to: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        int[] array = new int[number];
        for(int i=0;i<array.length;i++){
            System.out.print("please enter a number: ");
            int number1 = scanner.nextInt();
            scanner.nextLine();
            array[i] = number1;
        }
        return array;
    }
}
