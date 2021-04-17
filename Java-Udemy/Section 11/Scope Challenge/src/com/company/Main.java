package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner  scanner = new Scanner(System.in);
    private static int x;

    public static void main(String[] args) {
        System.out.print("enter a number below 10: ");
        x = scanner.nextInt();

        for (int x = 0;x<=12;x++){
            System.out.println(x*Main.x);
        }
    }

}
