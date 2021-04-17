package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(printYearsAndDays(525600));
    }
	public static int printYearsAndDays(long minutes){
	    if (minutes < 0){
            System.out.println("Invalid Value");
        }
	    else{
	        long xx = minutes;
            long yy = xx / 60 / 24 / 365;
            long zz = xx / 60 / 24 % 365;
            System.out.println(xx + " min = " + yy + " y and " + zz + " d");
        }
	    return 0;
        }

}
