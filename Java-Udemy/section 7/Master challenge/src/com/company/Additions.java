package com.company;

import java.util.Scanner;

public class Additions {
    private int breadRollCost;
    private int breadRollType;

    private int additionsCost;
    private int additions1;
    private int additions2;
    private int additions3;
    private int additions4;

    private int isMeat;
    private int meatCost;
    Scanner scanner=new Scanner(System.in);

    public int breadRollType(){
        System.out.println("Enter 1 if you want normal bread roll");
        System.out.println("Enter 2 if you want whole wheat bread roll");
        System.out.println("Enter 3 if you want hot dog bread roll");
        breadRollType = scanner.nextInt();
        scanner.nextLine();
        switch (breadRollType){
            case 1:
                breadRollCost +=0;
                break;
            case 2:
                breadRollCost+=5;
                break;
            case 3:
                breadRollCost+=10;
                break;
        }
        return breadRollCost;
    }

    public int lettuceTomatoCarrotMayonise(){

        System.out.println("Enter 1 if you want lettuce or else enter 2");
        additions1= scanner.nextInt();
        scanner.nextLine();
        if(additions1==1){
            additionsCost+=5;
        }
        System.out.println("Enter 1 if you want tomato or else enter 2");
        additions2= scanner.nextInt();
        scanner.nextLine();
        if(additions2==1){
            additionsCost+=5;
        }

        System.out.println("Enter 1 if you want carrot or else enter 2");
        additions3= scanner.nextInt();
        scanner.nextLine();
        if(additions3==1){
            additionsCost+=5;
        }

        System.out.println("Enter 1 if you want mayonise or else enter 2");
        additions4= scanner.nextInt();
        scanner.nextLine();
        if(additions4==1){
            additionsCost+=5;
        }


        return additionsCost;
    }

    public int meat(){
        System.out.println("please enter 1 if you want meat or else enter 2");
        isMeat= scanner.nextInt();
        scanner.nextLine();
        scanner.close();
        if(isMeat==1){
            meatCost=20;
        }else{
            meatCost=0;
        }
        return meatCost;
    }

}
