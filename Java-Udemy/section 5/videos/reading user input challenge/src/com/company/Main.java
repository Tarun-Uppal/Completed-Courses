package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Enter number #1");
//        int number1 = scanner.nextInt();
//        scanner.nextLine();
//        boolean IntNumber1 = scanner.hasNextInt();
//
//        if(!IntNumber1){
//            System.out.println("Invalid Value");
//        }
//
//        System.out.println("Enter number #2");
//        int number2 = scanner.nextInt();
//        scanner.nextLine();
//        boolean IntNumber2= scanner.hasNextInt();
//
//        if(!IntNumber2){
//            System.out.println("Invalid Value");
//        }
//
//        System.out.println("Enter number #3");
//        int number3 = scanner.nextInt();
//        scanner.nextLine();
//        boolean IntNumber3= scanner.hasNextInt();
//
//        if(!IntNumber3){
//            System.out.println("Invalid Value");
//        }
//
//        System.out.println("Enter number #4");
//        int number4 = scanner.nextInt();
//        scanner.nextLine();
//        boolean IntNumber4= scanner.hasNextInt();
//
//        if(!IntNumber4){
//            System.out.println("Invalid Value");
//        }
//
//        System.out.println("Enter number #5");
//        int number5 = scanner.nextInt();
//        scanner.nextLine();
//        boolean IntNumber5= scanner.hasNextInt();
//
//        if(!IntNumber5){
//            System.out.println("Invalid Value");
//        }
//
//        System.out.println("Enter number #6");
//        int number6 = scanner.nextInt();
//        scanner.nextLine();
//        boolean IntNumber6= scanner.hasNextInt();
//
//        if(!IntNumber6){
//            System.out.println("Invalid Value");
//        }
//
//
//        System.out.println("Enter number #7");
//        int number7 = scanner.nextInt();
//        scanner.nextLine();
//        boolean IntNumber7= scanner.hasNextInt();
//
//        if(!IntNumber7){
//            System.out.println("Invalid Value");
//        }
//
//
//        System.out.println("Enter number #8");
//        int number8 = scanner.nextInt();
//        scanner.nextLine();
//        boolean IntNumber8= scanner.hasNextInt();
//
//        if(!IntNumber8){
//            System.out.println("Invalid Value");
//        }
//
//
//        System.out.println("Enter number #9");
//        int number9 = scanner.nextInt();
//        scanner.nextLine();
//        boolean IntNumber9= scanner.hasNextInt();
//
//        if(!IntNumber9){
//            System.out.println("Invalid Value");
//        }
//
//
//        System.out.println("Enter number #10");
//        int number10 = scanner.nextInt();
//        scanner.nextLine();
//        boolean IntNumber10= scanner.hasNextInt();
//
//        if(!IntNumber10){
//            System.out.println("Invalid Value");
//        }
//        scanner.close();
//
//        int total=number1+number2+number3+number4+number5+number6+number7+number8+number9+number10;
//        System.out.println(total);

        //an alternalte method both by me
        int sum = 0;
        Scanner number = new Scanner(System.in);
        for (int i = 1; i != 11; i++) {

            System.out.println("Enter number #" + i +":");
            int imputnumber = number.nextInt();
            boolean numberchecker = number.hasNextInt();

            if (numberchecker=true) {
                number.nextLine();
                sum += imputnumber;
            }
            else {
                System.out.println("Invalid Value");
            }
        }
        number.close();
        System.out.println(sum);
    }
}
