package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(getLargestPrime(21));
    }
    public static int getLargestPrime(int number){
        int LargestPrimeNumber=0;
        int noOfPrimeNumbers=0;
        if(number<=0) {
            return -1;
        }
            for (int i = 2; number >= i; i++) {


                if (number%i==0) {
                    if(number==i){
                        if(noOfPrimeNumbers==0){
                            LargestPrimeNumber=number;

                            break;
                        }
                        break;
                    }
                    noOfPrimeNumbers=1;
                    LargestPrimeNumber = i;
                    if(number==i){
                        break;
                    }
                }
                if (number == i) {
                    if(noOfPrimeNumbers==0){
                        LargestPrimeNumber=number;
                        break;
                    }
                }

            }
            if(LargestPrimeNumber==0){
                return -1;
            }
        return LargestPrimeNumber;
    }
}
