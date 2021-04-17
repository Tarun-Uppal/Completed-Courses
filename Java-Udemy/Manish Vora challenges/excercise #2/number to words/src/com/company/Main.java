package com.company;

import java.util.Scanner;
import java.util.SplittableRandom;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter a number below 100 crore");
        int number = scanner.nextInt();
        scanner.nextLine();
        scanner.close();

        int thousands = 0;
        int lakhs = 0;
        int crores = 0;
        int hundreds = 0;
        int number2 = number;

        while (true) {

            if (getdigitcount(number2) == 8 || getdigitcount(number2) == 9) {
                //crores

                crores = number2 / 10000000;

                System.out.print(zerotonineteen(crores) + " crore ");
                crores*=10000000;
                number2 -= crores;
                if (number2 <= 0) {
                    break;
                }
            }
            if (getdigitcount(number2) == 7 || getdigitcount(number2) == 6) {
                //lakhs and ten lakhs

                lakhs = number2 / 100000;
                System.out.print(zerotonineteen(lakhs) + " lakh ");
                lakhs*=100000;
                number2 -= lakhs;

                if (number2 <= 0) {
                    break;
                }

            }
            if (getdigitcount(number2) == 5 || getdigitcount(number2) == 4) {
                //thousands and ten thousands

                thousands = number2 / 1000;
                System.out.print(zerotonineteen(thousands) + "thousand ");
                thousands *= 1000;
                number2 -= thousands;

                if (number2 <= 0) {
                    break;
                }

            }

            if (getdigitcount(number2) == 3) {
                //hundreds

                hundreds = number2 / 100;
                System.out.print(zerotonine(hundreds) + " Hundred ");
                hundreds *= 100;
                number2 -= hundreds;
                if (number2 <= 0) {
                    break;
                }

            }

            if (getdigitcount(number2) == 2 || getdigitcount(number2) == 1) {
                //tens and ones

                System.out.print(zerotonineteen(number2));
                number2 -= number2;
                if (number2 <= 0) {
                    break;
                }
            }
            if (number2 <= 0) {
                break;
            }
        }
    }

    public static String zerotonineteen(int number) {
        if (number > 19) {
            String string = twentytoninetynine(number);
            return string;
        }
        else {
            switch (number) {
                case 0:
                    return "";
                case 1:
                    return "One";
                case 2:
                    return "Two";
                case 3:
                    return "Three";
                case 4:
                    return "Four";
                case 5:
                    return "Five";
                case 6:
                    return "Six";
                case 7:
                    return "Seven";
                case 8:
                    return "Eight";
                case 9:
                    return "Nine";
                case 10:
                    return "Ten";
                case 11:
                    return "Eleven";
                case 12:
                    return "Twelve";
                case 13:
                    return "Thirteen";
                case 14:
                    return "Fourteen";
                case 15:
                    return "Fifteen";
                case 16:
                    return "Sixteen";
                case 17:
                    return "Seventeen";
                case 18:
                    return "Eighteen";
                case 19:
                    return "Nineteen";

            }

        }
        return "";
    }

    public static String zerotonine(int number) {
        switch (number) {
            case 0:
                return "";
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            default:
                return " ";
        }
    }

    public static String tenswithoutzero(int number) {
        switch (number) {
            case 1:
                return "Ten";
            case 2:
                return "Twenty";
            case 3:
                return "Thirty";
            case 4:
                return "Forty";
            case 5:
                return "Fifty";
            case 6:
                return "Sixty";
            case 7:
                return "Seventy";
            case 8:
                return "Eighty";
            case 9:
                return "Ninety";
            default:
                return " ";
        }
    }

    public static int getdigitcount(int number) {
        int digitcount = 0;
        while (true) {
            number /= 10;
            digitcount++;
            if (number == 0) {
                break;
            }
        }
        return digitcount;
    }

    public static String twentytoninetynine(int number) {
        int number2 = number;
        int number3 = number;

        number3 %= 10;
        number2 /=10;


        String tens=tenswithoutzero(number2);
        String ones= zerotonineteen(number3);
        return tens+ " " + ones;
    }
}

