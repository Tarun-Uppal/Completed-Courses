package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] array1 = inputNumbers();
        int[] array2 = inputNumbers();

        int[] array3 = intersectionArray(array1,array2);

                for(int i = 0;i<array3.length;i++){
                    if(array3[i]==0){
                        break;
                    }
                    System.out.println(array3[i]);
                }

    }

    public static int[] intersectionArray(int[] array1,int[] array2){
        int[] array3 = new int[1000];
        int array3count = 0;
        for(int i = 0;i<array1.length;i++){
            int array1checker = array1[i];
            for(int w = 0; w<array2.length;w++){
                int array2checker = array2[w];
                if(array1checker == array2checker){
                    array3[array3count] = array1checker;
                    array3count++;
                }else{
                    continue;
                }
            }
        }
        return array3;
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
