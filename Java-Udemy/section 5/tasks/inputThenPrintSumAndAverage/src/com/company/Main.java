package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    }
    public static void inputThenPrintSumAndAverage(){
        long sum=0;
        long average=0;
        long NoOfTimes=0;

        Scanner scanner = new Scanner(System.in);

while(true) {

    boolean hasNextInt = scanner.hasNextInt();

    if (hasNextInt) {
        int number = scanner.nextInt();
        NoOfTimes++;
        sum += number;
        average = sum / NoOfTimes;
    }
    else {
        break;
    }
}
        scanner.close();
        System.out.println("SUM = "+ sum +" AVG = "+ average);

    }
}
