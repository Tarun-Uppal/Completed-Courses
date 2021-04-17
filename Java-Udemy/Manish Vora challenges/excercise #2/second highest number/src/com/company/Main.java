package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int largestnumber = 0;
        int secondlargestnumber = 0;
        int nooflargest = 0;

        while (true) {
            System.out.println("enter a number");
            boolean numberchecker = scanner.hasNextInt();

            if (!numberchecker) {
                break;
            }
            int number = scanner.nextInt();

            if(number>largestnumber){
                if(nooflargest>=1){
                    if(secondlargestnumber<largestnumber){
                        secondlargestnumber=largestnumber;
                        largestnumber=number;
                        nooflargest++;
                    }else{
                        largestnumber=number;
                        nooflargest++;
                    }
                }else {
                    largestnumber = number;
                    nooflargest++;
                }
            }
                if((number>secondlargestnumber) && (number<largestnumber)){
                    secondlargestnumber=number;
                }


        }
       
        System.out.println(secondlargestnumber);
       scanner.close();
    }
}