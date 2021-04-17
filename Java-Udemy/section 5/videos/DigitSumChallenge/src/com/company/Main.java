package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(sumDigits(123));
        System.out.println(sumDigits2(123));
    }
    public static int sumDigits(int number){
        if(number>=10){
            int firstDigit=number%10;
            number=number/10;
            int secondDigit=number%10;
            number= number/10;
            int thirdDigit=number%10;
            number=number/10;

            int sum=secondDigit+firstDigit+thirdDigit;
            return sum;
        }
        return -1;

    }
    //another way to do it is

    public static int sumDigits2(int number2) {
        int sum=0;
        int number=0;
        if(number2<10){
            return -1;
        }
        do{
            number = number2% 10;
            number2 /= 10;
            sum+=number;
        } while(number2 !=0 );
        return sum;

    }
}
