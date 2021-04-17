package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter your year of birth");
        int yearofbirth = scanner.nextInt();

        System.out.println("enter your month of birth in numbers");
        int monthofbirth = scanner.nextInt();

        System.out.println("enter your date of birth");
        int dateofbirth = scanner.nextInt();

        scanner.nextLine();
        scanner.close();
        int yearage = 2020 - yearofbirth;
        int currentmonth = 4;
        int yearstodays = yearage*365;
        int monthtodays = monthofbirth * 30;
        int currentmonthtodays = currentmonth * 30;
        int currentday = 25;

        int finaldays = currentday - dateofbirth;
        int finalyearstodays = yearstodays;
        int finalmonthtodays = currentmonthtodays - monthtodays;
        finaldays = yearstodays + finalmonthtodays + finaldays + finaldays;

        int daystoyears = finaldays / 365;
        int remainingdaystoyears = finaldays % 365;
        int daystomonths = remainingdaystoyears / 30;
        int remainingdaystomonths = remainingdaystoyears % 30;

        System.out.println("you are " + daystoyears + " years " + daystomonths + " months " + remainingdaystomonths + " days ");


    }
}


