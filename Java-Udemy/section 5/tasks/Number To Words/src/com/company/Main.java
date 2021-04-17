package com.company;

public class Main {

    public static void main(String[] args) {

    }
    public static void numberToWords (int number){
        int noOfNumbers=0;
        noOfNumbers+=getDigitCount(number);
        number = reverse(number);
        int noOfoutputNumbers=0;
        if (number<0){
            System.out.println("Invalid Value");
        }else {
            do {
                int number2 = number % 10;
                switch (number2) {
                    case 1:
                        System.out.println("One");
                        noOfoutputNumbers = noOfoutputNumbers + 1;
                        break;
                    case 2:
                        System.out.println("Two");
                        noOfoutputNumbers = noOfoutputNumbers + 1;
                        break;
                    case 3:
                        System.out.println("Three");
                        noOfoutputNumbers = noOfoutputNumbers + 1;
                        break;
                    case 4:
                        System.out.println("Four");
                        noOfoutputNumbers = noOfoutputNumbers + 1;
                        break;
                    case 5:
                        System.out.println("Five");
                        noOfoutputNumbers = noOfoutputNumbers + 1;
                        break;
                    case 6:
                        System.out.println("Six");
                        noOfoutputNumbers = noOfoutputNumbers + 1;
                        break;
                    case 7:
                        System.out.println("Seven");
                        noOfoutputNumbers = noOfoutputNumbers + 1;
                        break;
                    case 8:
                        System.out.println("Eight");
                        noOfoutputNumbers = noOfoutputNumbers + 1;
                        break;
                    case 9:
                        System.out.println("Nine");
                        noOfoutputNumbers = noOfoutputNumbers + 1;
                        break;
                    case 0:
                        System.out.println("Zero");
                        noOfoutputNumbers = noOfoutputNumbers + 1;
                        break;
                }
                number /= 10;
            } while (number != 0);
            noOfNumbers -= noOfoutputNumbers;
            if (noOfNumbers == 0) {
            } else {
                do {
                    System.out.println("Zero");
                    noOfNumbers--;
                } while (noOfNumbers != 0);
            }
        }
    }
    public static int reverse(int number){
        int reversed=0;

        do {
            int digit=number%10;
            reversed=reversed *10+digit;
            number/=10;
        }while(number!=0);
        number+= reversed;
    return number;
    }
    public static int getDigitCount(int number){
        if (number<0){
            return -1;
        }
        int noOfNumbers=0;
        do {
            noOfNumbers++;
            number/=10;
        }while(number!=0);
        return noOfNumbers;
    }
}
