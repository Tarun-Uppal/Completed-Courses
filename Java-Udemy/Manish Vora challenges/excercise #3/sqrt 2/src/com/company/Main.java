package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter a number");
        int end = scanner.nextInt();
        scanner.close();

        double sqrt = 0;
        for (int i = end; i >= 0; i--) {
            sqrt = Math.sqrt(2);
        }
        System.out.println(sqrt);


    }
}
