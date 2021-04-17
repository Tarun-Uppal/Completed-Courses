package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter a number");
        int number = scanner.nextInt();
        scanner.close();

        double sum = 0;
        double pi=0;
        for (int i = 0; i < number; i++) {
            sum += Math.pow(2, i+1) / (2 * i + 1);

        }
        pi = sum;
        System.out.println(pi);
    }
}
