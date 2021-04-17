package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(hasSameLastDigit(777,771,77));
        System.out.println(isValid(1));
    }

    public static boolean hasSameLastDigit(int number1, int number2, int number3) {
        if ((number1 >= 10) && (number1 <= 1000) && (number2 >= 10) && (number3 <= 1000) && (number3 >= 10) && (number3 <= 1000)) {
            number1 %= 10;
            number2 %= 10;
            number3 %= 10;
            if (number1==number2){
                return true;
            }
            if(number2==number3){
                return true;
            }
            if(number3==number1){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
    public static boolean isValid(int number1){
        if((number1 >= 10) && (number1 <= 1000)){
            return true;
        }
        else{
            return false;
        }
    }
}
