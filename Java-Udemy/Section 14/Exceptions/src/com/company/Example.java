package com.company;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        try {
            int result = divide();
            System.out.println(result);
        }catch (ArithmeticException | NoSuchElementException e){
            System.out.println(e.toString());
            System.out.println("Unable to perform division");
        }
        // or in catching exceptions is | not || like it is in if statements
    }

    public static int divide(){
        int x = 0;
        int y = 0;
//        try {
            x = getInt();
            y = getInt();
            System.out.println("x is " + x + " y is " + y);
            return x/y;
//        }catch (NoSuchElementException e){
//            throw new ArithmeticException("No suitable input");
//        }catch (ArithmeticException e){
//            throw new ArithmeticException("Attempt to divide by zero");
//        }
    }

    private static int getInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter an integer");
        while (true) {
            try {
                return scanner.nextInt();
            }catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println("Please enter a number using digits 0 - 9");
            }

        }
    }
}
