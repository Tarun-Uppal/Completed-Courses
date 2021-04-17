package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(printDayoftheWeek(2));
        System.out.println(DayOfTheWeekChallenge(2));

    }
	public static int printDayoftheWeek(int day){
	    switch (day){
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Invalid day");
                break;
        }
        return day;
        }
        public static int DayOfTheWeekChallenge(int day){
        if (day == 1){
            System.out.println("Sunday");
        }
            if (day == 2){
                System.out.println("Monday");
            }
            if (day == 3){
                System.out.println("Tuesday");
            }
            if (day == 4){
                System.out.println("Wednesday");
            }
            if (day == 5){
                System.out.println("Thursday");
            }
            if (day == 6){
                System.out.println("Friday");
            }
            if (day == 7){
                System.out.println("Saturday");
            }
            else{
                System.out.println("Invalid Day");
            }
            return day;
        }
}
