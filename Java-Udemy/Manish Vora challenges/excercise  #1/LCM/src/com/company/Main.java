package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter your number #1");
        int number1 = scanner.nextInt();
        scanner.nextLine();

        System.out.println("enter your number #2");
        int number2 = scanner.nextInt();
        scanner.nextLine();

        scanner.close();

        int LCM = 1;
        int number = 0;
        int step = 0;
        
            if (number1 > number2) {
                number = number1;
            }
            else {
                number = number2;
            }

            while (number1 != 0) {
                if ((number % number1 == 0) && (number % number2 == 0)) {
                    LCM = number;
                    break;
                }
                number ++;
            }
            System.out.println("LCM of " + number1 +" and "+number2+" is " + LCM);

        

    }
    }

