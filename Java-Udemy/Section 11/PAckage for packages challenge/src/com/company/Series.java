package com.company;

public class Series {
    public static int[] nSum(int n){
        int w = 0;
        int[] nSum = new int[n];
        for(int i=0;i<n;i++){
            w+=i;
            nSum[i] = w;
        }
        return nSum;
    }

    public static int[] factorial(int n){
        int w = 1;
        int[] factorial = new int[n];
        for(int i=1;i<n;i++){
            w*=i;
            factorial[i] = w;
        }
        return factorial;
    }

    public static int[] fibonacci(int n){
        int fib1=1;
        int fib2=0;
        int noOfTimes = n;
        int[] fib = new int[noOfTimes];


        while (true) {
            fib1=fib2+fib1;
            noOfTimes--;
            fib[noOfTimes] = fib1;

            if(noOfTimes==0){
                break;
            }
            fib2=fib1+fib2;
            noOfTimes--;
            fib[noOfTimes] = fib2;
            if(noOfTimes==0){
                break;
            }
        }
       return fib;
    }
}
