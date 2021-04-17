package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
            for(int i=0;i!=5;i++) {
                System.out.println("enter your car speed");
                int speed = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter your steering degree");
                int steeringDegree = scanner.nextInt();

                Evo9 car=new Evo9(steeringDegree,speed);
                System.out.println("You are Steering " + car.steeringDegree(steeringDegree));
                System.out.println("Changing gears to " + car.changingGears(speed));
                scanner.nextLine();
            }
        scanner.close();




    }
}
