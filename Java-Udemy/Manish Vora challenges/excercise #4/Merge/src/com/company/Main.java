package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	int[] array1 = inputNumbers();
	int[] array2 = inputNumbers();

        int[] array3 = new int[array1.length+array2.length];
        for(int i = 0;i < array3.length;i++){

                for(int a1 = 0;a1 < array1.length;a1++,i++){
                    array3[i] = array1[a1];
            }
                for(int a2 = 0;a2 < array2.length;a2++,i++){
                    array3[i] = array2[a2];
                }
        }

        array3 = sortIntegers(array3);

        for(int i = 0;i < array3.length;i++){
            System.out.println(array3[i]);
        }

    }
    public static int[] sortIntegers(int[] array) {
        int[] sortedArray = Arrays.copyOf(array, array.length);

        boolean flag = true;
        int temp;
        while(flag) {
            flag = false;

            for(int i=0; i<sortedArray.length-1; i++) {
                if(sortedArray[i] > sortedArray[i+1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = temp;
                    flag = true;
                }
            }
        }

        return sortedArray;
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
