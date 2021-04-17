package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(sumFirstAndLastDigits(5112));

    }
    public static int sumFirstAndLastDigits(int number) {
        int sum =0;
        int number2=number;
        if (number < 0) {
            return -1;
        }
        number2%=10;
        sum += number2;
        do{
            if(number<10) {
                sum += number;
            }
            number /=10;

        } while(number !=0 );
        return sum;
    }
}


        //The method needs to find the first and the last digit of the parameter number passed to the method,
        // using a loop and return the sum of the first and the last digit of that number.

