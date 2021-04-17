package com.company;

public class Main {

    public static void main(String[] args) {

        calcFeetAndInchesToCentimeters();
        calcFeetAndInchesToCentimeters();

    }

    private static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        if ((feet < 0) || (inches < 0) || (inches > 12)){
            return -1;
        }
        double centimeters = (feet * 12) * 2.54;
        centimeters += inches * 2.54;
        System.out.println(feet + " feet " + inches + " inches= " + centimeters + "cm");
        return centimeters;
    }
    private static double calcFeetAndInchesToCentimeters(double inches) {
        if (inches <0){
            return -1;
        }
        double feet = (int) inches /12;
        double remaininginches = (int) inches % 12;
        System.out.println(inches + "inches = " + feet "feet " + remaininginches + " inches");
        return calcFeetAndInchesToCentimeters(feet,inches);
    }
}
