package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] array = inputNumbers();
        System.out.println(isPalindrome(array));
    }

static boolean isPalindrome(int array[]) {
    boolean isTrue = false;
    int number = array.length;

    for (int i = 0; i <= number / 2 && number != 0; i++) {

        if (array[i] != array[number - i - 1]) {
            isTrue = true;
            return false;
        }
    }
        return true;
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
