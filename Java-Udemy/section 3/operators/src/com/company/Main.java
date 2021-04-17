package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        int result = 1 + 2; //1+2=3
        System.out.println(result);
        int previousresult = result;
        System.out.println("previous result " + previousresult);

        result = result - 1;
        System.out.println("3 - 1 = " + result);
        System.out.println("previous result " + previousresult);

        result = result * 10;
        System.out.println("2 * 10 = " + result);

        result = result / 5;
        System.out.println("20 / 5 = " + result);

        result = result % 3;
        System.out.println("4 % 3 = " + result);

        result++;
        System.out.println("1 + 1 = " + result);

        result--;
        System.out.println("2 - 1 = " + result);

        result += 2;
        System.out.println("1 + 2 = " + result);

        result *= 10;
        System.out.println("3 * 10 = " + result);

        result /= 3;
        System.out.println("30 / 3 = " + result);

        result -= 2;
        System.out.println("10 - 2 = " + result);

        boolean isalien = false;

        if (isalien == false) {
            System.out.println("it is not an alien");
            System.out.println("it is is an alien");
        }
        int topscore = 80;
        if (topscore < 100) {
            System.out.println("you got the high score");
        }

        int secondtopscore = 60;
        if ((topscore > secondtopscore) && (topscore < 100)) {
            System.out.println("greater than top score but less than 100");
        }
        if ((topscore > 90) || (secondtopscore <= 90)) {
            System.out.println("either or both of the conditions are true");

            int newvalue = 50;
            if (newvalue == 50) {
                System.out.println("this is true");
            }

            boolean iscar = false;
            if (iscar == true){
                System.out.println("this is not supposed to happen");
            }
            boolean wascar = iscar ? true : false;
            iscar = true;
            if (wascar){
                System.out.println("was car is true");
            }


        }

    }
}