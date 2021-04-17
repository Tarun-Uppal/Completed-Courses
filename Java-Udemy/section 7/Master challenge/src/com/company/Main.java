package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int hamburger;

        System.out.println("Please enter 1 for a Standard hamburger");
        System.out.println("Please enter 2 for a Vegie hamburger");
        System.out.println("Please enter 3 for a Funcy hamburger");
        System.out.println("Please enter 4 for a Healthy hamburger");
        System.out.println("Please enter 5 for a Dulex hamburger");
        Scanner scanner = new Scanner(System.in);

        hamburger = scanner.nextInt();
        scanner.nextLine();

        while (true) {
            if (hamburger == 1) {
                new Hamburger().hamburger1();
                break;
            }
            if (hamburger == 2) {
                new Hamburger().hamburger2();
            break;
            }
            if (hamburger == 3) {
                new Hamburger().hamburger3();
            break;
            }
            if (hamburger == 4) {
                new Hamburger().hamburger4();
            break;
            }
            if (hamburger == 5) {
                new Hamburger().hamburger5();
            break;
            }
            scanner.close();
        }

    }
}
