package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(122));
    }

    public static int getEvenDigitSum(int number) {
        int sum=0;
        int number2=0;
        if(number<0){
            return -1;
        }
        do{
            number2 = number% 10;
            number /= 10;
            if(number2%2==0) {
                sum += number2;
            }
        } while(number !=0 );
        return sum;


    }
}
