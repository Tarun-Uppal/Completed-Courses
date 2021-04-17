package com.company;

public class Main {

    public static void main(String[] args) {
        int count = 0;
        while (count != 5) {
            System.out.println("count value is " + count);
            count++;
        }
        System.out.println("************************");
        count = 1;
        while (true) {
            if (count == 6) {
                break;
            }
            System.out.println("count value is " + count);
            count++;
        }
        System.out.println("********************************");
        count = 1;
        do {
            System.out.println("count value was " + count);
            count++;
        }while(count!=6);

        System.out.println("******************************************");

        int number = 4;
        int finishnumber = 20;
        while (number <= finishnumber) {
            number++;
            if (!isEvenNumber(number)) {
                          continue;
                }
            System.out.println("even number is " + number);

                   }
        System.out.println("******************************");
        number = 4;
        finishnumber = 20;
        int NoOf = 0;
        while (number <= finishnumber) {
            number++;
            if (isEvenNumber(number) ==true) {
                NoOf++;
                System.out.println("even number is " + number);
                if(NoOf==5){
                    break;
                }
            }

        }
        System.out.println("the no of even numbers is " + NoOf);
        System.out.println("********************************");
    }
    public static boolean isEvenNumber(int no) {
        while (true) {
            if ((no % 2) == 0) {
                return true;
            }
            return false;
        }

    }
}
