package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter the divident");

        int divident = scanner.nextInt();

        scanner.nextLine();
        System.out.println("please enter the divisor");

        int divisor = scanner.nextInt();

        scanner.nextLine();
        scanner.close();

        int remainder=0;
        int quotient=0;

            quotient=divident/divisor;
            remainder=divident%divisor;

        System.out.print(quotient+".");
        System.out.print(remainder);
    }


}
