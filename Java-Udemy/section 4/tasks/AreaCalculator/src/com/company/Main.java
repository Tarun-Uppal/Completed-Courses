package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(area(10,100));
        System.out.println(area(100));
    }

	public static double area(double radius){
	    if (radius < 0.0){
	        return -1.0;
        }
        return 22 / 7 / (radius * radius);
        }
    public static double area(double x,double y){
        if ((x < 0.0) || (x < 0.0)){
            return -1.0;

        }
        return x * y;
    }

}
